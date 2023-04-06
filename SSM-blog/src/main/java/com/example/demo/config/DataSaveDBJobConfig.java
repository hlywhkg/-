/**
 * @ClassName $申先生
 * @Description days
 * @date 2023/4/4 19:09
 * @Version 1.0
 */
package com.example.demo.config;

import com.example.demo.controller.FavoriteController;
import com.example.demo.controller.LikeController;
import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author Zhongger
 * @Description 定时器，不定时地把redis中的数据取出写入到数据库中
 * @Date 2020.2.28
 */
@Component
@Configurable //相当于xml配置文件，可以被Spring扫描初始化
@EnableScheduling //开启对计划任务的支持
public class DataSaveDBJobConfig {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private LikeController likeController;

    @Autowired
    private FavoriteController favoriteController;

    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private LikeMapper likeMapper;

    @Autowired
    private  FavoriteMapper favoriteMapper;

    private static final String COUNT_LIKE="like:list:userId:";
    private static final String COUNT_FAVORITE="favorite:list:userId:";
    private static final String CANCEL_LIKE = "cancelLike:list:userId";
    private static final String CANCEL_FAVORITE = "cancelFavorite:list:userId";
    @Scheduled(cron = "*/10 * * * * *")//声明为定时任务，每10秒一次。工程上一般是指定凌晨2点左右进行持久化
    public void savePraiseDataToMySQL(){
        List<Blog> list = blogMapper.selectAllBlogs();
        List<Integer> blogIds = new ArrayList<>();
        for (Blog blog:list) {
            int blogId = blog.getBlogId();
            blogIds.add(blogId);
        }
        for (int i = 0; i < blogIds.size() ; i++) {
            //1.在redis缓存中所有点赞该博客的用户ID
            int blogId = blogIds.get(i);
            System.out.println("blogID:"+blogId);
            Set<Integer> likes = redisTemplate.opsForSet().members(COUNT_LIKE+blogId);
            Set<Integer> favorites = redisTemplate.opsForSet().members(COUNT_FAVORITE+blogId);
            Set<Integer> CancelLikes = redisTemplate.opsForSet().members(CANCEL_LIKE+blogId);
            Set<Integer> CancelFavorites = redisTemplate.opsForSet().members(CANCEL_FAVORITE+blogId);
            int count_like = 0,count_favorite = 0;
            //新增的数据
            for (Integer userId:likes) {
                System.out.println("userID:"+userId);
                //判断原来数据库中是否有这条记录
                //有就跳过，没有就添加进去
                if(likeController.IsLike(blogId,userId)){
                    continue;
                }else{
                    count_like++;
                    likeController.insert(blogId,userId);
                }
            }
            for (Integer userId:favorites) {
                if(favoriteController.IsFavorite(blogId,userId)){
                    continue;
                }else{
                    count_favorite++;
                    favoriteController.insert(userId,blogId);
                }
            }
            //用户取消的操作
            for (Integer userId:CancelLikes) {
                System.out.println("userID:"+userId);
                //判断原来数据库中是否有这条记录
                //没有就跳过，有就从数据库中删除
                if(!likeController.IsLike(blogId,userId)){
                    continue;
                }else{
                    count_like--;
                    likeMapper.delete(blogId,userId);
                }
            }
            for (Integer userId:CancelFavorites) {
                if(!favoriteController.IsFavorite(blogId,userId)){
                    continue;
                }else{
                    count_favorite--;
                    favoriteMapper.delete(blogId,userId);
                }
            }
            //更新点赞数和收藏数
            Blog blog = blogMapper.selectBlogByBlogId(blogId);
            System.out.println(count_like);
            System.out.println(count_favorite);
            blogMapper.updateLike(blog.getCount_like()+count_like,blogId);
            blogMapper.updateFavorite(blog.getCount_favorite()+count_favorite,blogId);

            //清除redis中缓存
            redisTemplate.delete(COUNT_LIKE+blogId);
            redisTemplate.delete(COUNT_FAVORITE+blogId);
        }
        System.out.println("结束");
    }
}


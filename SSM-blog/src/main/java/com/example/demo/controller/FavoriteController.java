/**
 * @ClassName $申先生
 * @Description days
 * @date 2023/4/5 11:18
 * @Version 1.0
 */
package com.example.demo.controller;

import com.example.demo.model.FavoriteListUserId;
import com.example.demo.model.FavoriteMapper;
import com.example.demo.model.LikeListUserId;
import com.example.demo.model.LikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class FavoriteController {
    @Resource
    private  FavoriteMapper favoriteMapper;

    //判断此用户之前是否点过收藏
    public boolean IsFavorite(Integer blogId,Integer userId){
        List<FavoriteListUserId> arrayList= favoriteMapper.selectUserId(blogId);
        if(arrayList == null){
            return false;
        }
        Set<Integer> favoriteUserIds = new HashSet<>();
        for (int i = 0; i < arrayList.size(); i++) {
            FavoriteListUserId l1 = arrayList.get(i);
            int id = l1.getUserId();
            favoriteUserIds.add(id);
        }
        return favoriteUserIds.contains(userId);
    }

    public void insert(Integer userId,Integer blogId){
        favoriteMapper.insert(blogId,userId);
    }
}

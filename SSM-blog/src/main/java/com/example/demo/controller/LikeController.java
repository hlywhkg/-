/**
 * @ClassName $申先生
 * @Description days
 * @date 2023/4/5 11:18
 * @Version 1.0
 */
package com.example.demo.controller;

import com.example.demo.model.FavoriteListUserId;
import com.example.demo.model.LikeListUserId;
import com.example.demo.model.LikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class LikeController {
    @Resource
    private  LikeMapper likeMapper;

    //判断此用户之前是否点过赞
    public boolean IsLike(Integer blogId,Integer userId){
        List<LikeListUserId> arrayList= likeMapper.selectUserId(blogId);
        if(arrayList == null){
            return false;
        }
        Set<Integer> likeUserIds = new HashSet<>();
        for (int i = 0; i < arrayList.size(); i++) {
            LikeListUserId l1 = arrayList.get(i);
            int id = l1.getUserId();
            likeUserIds.add(id);
        }
        return likeUserIds.contains(userId);
    }

    public void insert(Integer blogId,Integer userId){
        likeMapper.insert(blogId,userId);
    }
}

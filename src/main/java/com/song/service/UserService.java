package com.song.service;

import com.song.entity.User;
import com.song.repository.UserRepositoty;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Song on 2017/2/15.
 * User业务逻辑
 */
@Service
public class UserService {
    @Resource
    private UserRepositoty userRepositoty;

    public User findUserByName(String name,String password){
        User user = null;
        try{
            user = userRepositoty.findByUserName(name,password);
        }catch (Exception e){}
        return user;
    }
}

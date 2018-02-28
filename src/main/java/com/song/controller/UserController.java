package com.song.controller;

import com.song.entity.User;
import com.song.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Song on 2017/2/15.
 * User控制层
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/index")
    public String index(){
        return "user/index";
    }

    @RequestMapping(value = "/show",method = RequestMethod.GET)
    @ResponseBody
    public int show(@RequestParam(value = "name")String name,@RequestParam(value = "password") String password){
        User user = userService.findUserByName(name,password);
        if(null != user)
            return 1;
        else return 0;
    }
}

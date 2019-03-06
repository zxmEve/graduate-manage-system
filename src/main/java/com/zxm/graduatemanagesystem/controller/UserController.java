package com.zxm.graduatemanagesystem.controller;

import com.zxm.graduatemanagesystem.model.User;
import com.zxm.graduatemanagesystem.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * 2019/3/5
 * Create by zhouximin
 * Description:
 */

@RequestMapping("/user")
@Controller
public class UserController {
    @Resource
    private IUserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public User login(@RequestParam("username")String username,
                      @RequestParam("password")String password){
        User user = userService.login(username,password);
        return user;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public boolean update(@RequestBody User user){
        int flag = userService.updateUser(user);
        if(flag > 0){
            return true;
        }
        return false;
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<User> list(){
        return userService.getUserList();
    }


}

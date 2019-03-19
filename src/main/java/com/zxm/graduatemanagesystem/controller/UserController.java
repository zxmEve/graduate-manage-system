package com.zxm.graduatemanagesystem.controller;

import com.github.pagehelper.PageInfo;
import com.zxm.graduatemanagesystem.model.User;
import com.zxm.graduatemanagesystem.service.IStudentService;
import com.zxm.graduatemanagesystem.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
    @Resource
    private IStudentService studentService;


    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login( HttpServletRequest request) {
        System.out.println("1");
        String page="login";
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        try {
            User u = userService.login(username, password);

			System.out.println(u);
            if (u != null) {
                //登陆的用户放进session
                request.getSession().setAttribute("loginUser", u);
                page = "main";
            }
            else {
                page = "login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return page;
    }


//    @RequestMapping("/toLogin")
//    public ModelAndView toLoginPage(ModelAndView mv){
//        mv.setViewName("/login");
//        return mv;
//    }
    @RequestMapping("/toLogin")
    public String toLoginPage()	{
        return "login";
    }

    @RequestMapping("/toNav")
    public String toNavPage(){
        return "nav";
    }

    @RequestMapping("/toForm")
    public String toFormPage(){
        return "form";
    }
    @RequestMapping("/toIndex")
    public String toIndexPage(){
        return "index";
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
    public PageInfo list(@RequestParam int pageNum,@RequestParam int pageSize){
        return userService.getUserList(pageNum, pageSize);
    }


}

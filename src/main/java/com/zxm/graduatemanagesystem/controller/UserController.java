package com.zxm.graduatemanagesystem.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.zxm.graduatemanagesystem.constants.InstitudeEnum;
import com.zxm.graduatemanagesystem.constants.ProfessionEnum;
import com.zxm.graduatemanagesystem.constants.UserTypeEnum;
import com.zxm.graduatemanagesystem.model.StudentInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zxm.graduatemanagesystem.model.User;
import com.zxm.graduatemanagesystem.service.IStudentService;
import com.zxm.graduatemanagesystem.service.IUserService;
import org.springframework.web.servlet.ModelAndView;

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
                page = "/admin/main";
            }
            else {
                page = "/admin/login";
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
        return "/admin/login";
    }

    @RequestMapping("/toNav")
    public String toNavPage(){
        return "/admin/nav";
    }

    @RequestMapping("/toForm")
    public String toFormPage(){
        return "/admin/form";
    }
    @RequestMapping("/toIndex")
    public String toIndexPage(){
        return "/admin/index";
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
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

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public @ResponseBody
    ModelAndView insert(User user){

        int flag = userService.insertUser(user);

        return new ModelAndView("/index") ;
    }

    @RequestMapping(value = "/judgeUsername",method = RequestMethod.GET)
    @ResponseBody
    public Boolean judgeUsername(@RequestParam String username){
        User user = userService.selectByUsername(username);
        if (user != null) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @RequestMapping(value = "/toUserInfo",method = RequestMethod.GET)
    public String getUserInfo(Model modle, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("loginUser");
        if (user != null) {
            modle.addAttribute("user", user);
        }
        return "/admin/password_table";
    }

    @RequestMapping(value = "/toUserChange",method = RequestMethod.GET)
    public String changeUser(Model modle,@RequestParam Integer id){
        User user =userService.selectById(id);
        if (user != null) {
            modle.addAttribute("user", user);
        }
        return "/admin/password_table";
    }

    @RequestMapping(value = "/toRegister", method = RequestMethod.GET)
    public String toRegister(){
        return "/front/registration";
    }

    @RequestMapping("/toUpdateInfo")
    public String toUpdateInfo(Model modle, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("loginUser");
        if (user != null) {
            if(user.getUserType() == UserTypeEnum.STUDENT.getIntValue()) {
                StudentInfo stu = studentService.getStudentByUserId(user.getId());
                if (stu != null) {
                    modle.addAttribute("stu", stu);
                    modle.addAttribute("institudes", InstitudeEnum.values());
                    modle.addAttribute("professions", ProfessionEnum.getProFessionsByInstitude(stu.getInstitude()));
                }
                return "/admin/student_info";
            }else if(user.getUserType() == UserTypeEnum.COMPANY.getIntValue()){
                return "/admin/company_info";
            }
        }
        return "/admin/student_info";
    }

    @RequestMapping("/toUserTable")
    public String toTablePage(Model model, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8") int pageSize){
        PageInfo pageInfo = userService.getUserList(pageNum,pageSize);
        model.addAttribute("userType",UserTypeEnum.values());
        model.addAttribute("pageInfo",pageInfo);
        return "/admin/user_table";
    }

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    @ResponseBody
    public User queryById(@RequestParam int id){
        return userService.selectById(id);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public int deleteUser(@RequestParam int id){
        int res = userService.deleteUser(id);
        return res;
    }

    @RequestMapping(value = "/getLoginUser")
    public User getLoginUser(HttpServletRequest request){
        return (User)request.getSession().getAttribute("loginUser");
    }
}

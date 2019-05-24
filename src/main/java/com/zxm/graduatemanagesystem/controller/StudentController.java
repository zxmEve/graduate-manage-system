package com.zxm.graduatemanagesystem.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.zxm.graduatemanagesystem.constants.UserTypeEnum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zxm.graduatemanagesystem.constants.InstitudeEnum;
import com.zxm.graduatemanagesystem.constants.ProfessionEnum;
import com.zxm.graduatemanagesystem.model.StudentInfo;
import com.zxm.graduatemanagesystem.model.User;
import com.zxm.graduatemanagesystem.service.IDictionaryService;
import com.zxm.graduatemanagesystem.service.impl.StudentService;

/**
 * @author zhouximin
 * Created on 2019-03-10
 */

@RequestMapping("/student")
@Controller
public class StudentController {

    @Resource
    private StudentService studentService;
    @Resource
    IDictionaryService dictionaryService;

    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public boolean update(@RequestBody StudentInfo studentInfo){
        int flag = studentService.updateStudent(studentInfo);
        return flag > 0;
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public boolean insert(@RequestBody StudentInfo studentInfo){
        int flag = studentService.insertStudent(studentInfo);
        return flag > 0;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    @ResponseBody
    public boolean delete(@RequestParam int studentId){
        int flag = studentService.deleteStudent(studentId);
        return flag > 0;
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public PageInfo list(@RequestParam int pageNum, @RequestParam int pageSize){
        return studentService.getStudentList(pageNum, pageSize);
    }

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    @ResponseBody
    public StudentInfo queryById(@RequestParam int studentId){
        return studentService.getStudentByUserId(studentId);
    }


    @RequestMapping("/toStudentTable")
    public String toTablePage(Model model, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8") int pageSize){
        PageInfo pageInfo = studentService.getStudentList(pageNum,pageSize);
        model.addAttribute("pageInfo",pageInfo);
        return "/admin/student_table";
    }

    @RequestMapping("/toStudentInfo")
    public String toStudentInfo(Model model,@RequestParam int studentId){
        StudentInfo studentInfo = studentService.getStudentById(studentId);
        model.addAttribute("student",studentInfo);
        model.addAttribute("institudes",InstitudeEnum.values());
        model.addAttribute("professions",ProfessionEnum.getProFessionsByInstitude(studentInfo.getInstitude()));
        return "/admin/student_info";
    }

    @ResponseBody
    @RequestMapping(value = "/update_or_insert",method = RequestMethod.POST)
    public boolean updateOrInsert(Model modle, HttpServletRequest request, @RequestBody StudentInfo studentInfo){
        User user = (User) request.getSession().getAttribute("loginUser");
        if (user != null) {
            StudentInfo stu = studentService.getStudentByUserId(user.getId());
            if (stu == null) {
                // 学生信息表这个用户的信息为空，表示第一次完善信息
                studentInfo.setUserId(user.getId());
                int ret = studentService.insertStudent(studentInfo);
                return ret > 0;
            }
        }

        int flag = studentService.updateStudent(studentInfo);
        return flag > 0;
    }

    // 根据学院id 查找专业列表
    @ResponseBody
    @RequestMapping(value = "/professions", method = RequestMethod.GET)
    public List<ProfessionEnum> getProfessions(int institudeId) {
        return ProfessionEnum.getProFessionsByInstitude(institudeId);
    }

}

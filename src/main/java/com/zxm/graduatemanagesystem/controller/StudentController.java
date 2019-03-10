package com.zxm.graduatemanagesystem.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.zxm.graduatemanagesystem.model.StudentInfo;
import com.zxm.graduatemanagesystem.service.impl.StudentService;

/**
 * @author tangmingqiu
 * Created on 2019-03-10
 */

@RequestMapping("/student")
@Controller
public class StudentController {

    @Resource
    private StudentService studentService;

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

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public boolean delete(@RequestParam int studentId){
        int flag = studentService.deleteStudent(studentId);
        return flag > 0;
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public PageInfo list(@RequestParam int pageNum, @RequestParam int pageSize){
        return studentService.getStudentList(pageNum, pageSize);
    }

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public StudentInfo queryById(@RequestParam int studentId){
        return studentService.getStudentByUserId(studentId);
    }




}

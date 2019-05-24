package com.zxm.graduatemanagesystem.service;

import com.github.pagehelper.PageInfo;
import com.zxm.graduatemanagesystem.model.StudentInfo;
import com.zxm.graduatemanagesystem.vo.back.StudentVO;

import java.util.List;

/**
 * 2019/3/7
 * Create by zhouximin
 * Description:
 */
public interface IStudentService {
    List<StudentInfo> getStudentList();

    int insertStudent(StudentInfo studentInfo);

    int updateStudent(StudentInfo studentInfo);

    PageInfo getStudentList(int pageNum, int pageSize);

    int deleteStudent(Integer id);

    StudentInfo getStudentByUserId(Integer userId);

    StudentInfo getStudentById(Integer id);

    StudentVO getStudentVOById(Integer id);


}

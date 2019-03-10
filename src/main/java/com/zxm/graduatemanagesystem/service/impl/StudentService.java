package com.zxm.graduatemanagesystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxm.graduatemanagesystem.dao.mapper.StudentInfoMapper;
import com.zxm.graduatemanagesystem.model.StudentInfo;
import com.zxm.graduatemanagesystem.service.IStudentService;

import javax.annotation.Resource;
import java.util.List;

/**
 * 2019/3/7
 * Create by zhouximin
 * Description:
 */
public class StudentService implements IStudentService {

    @Resource
    private StudentInfoMapper studentInfoMapper;

    @Override
    public List<StudentInfo> getStudentList() {
        return studentInfoMapper.selectByExample(null);
    }

    @Override
    public int insertStudent(StudentInfo studentInfo) {
        return studentInfoMapper.insertSelective(studentInfo);
    }

    @Override
    public int updateStudent(StudentInfo studentInfo) {
        return studentInfoMapper.updateByPrimaryKeySelective(studentInfo);
    }

    @Override
    public PageInfo getStudentList(int pageNum, int pageSize) {
        List<StudentInfo> list = studentInfoMapper.selectByExample(null);
        PageHelper.startPage(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int deleteStudent(Integer id) {
        return studentInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public StudentInfo getStudentByUserId(Integer userId) {
        return studentInfoMapper.getStudentByUserId(userId);
    }
}

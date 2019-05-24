package com.zxm.graduatemanagesystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxm.graduatemanagesystem.constants.EducationEnum;
import com.zxm.graduatemanagesystem.constants.GenderEnum;
import com.zxm.graduatemanagesystem.constants.InstitudeEnum;
import com.zxm.graduatemanagesystem.dao.mapper.StudentInfoMapper;
import com.zxm.graduatemanagesystem.model.StudentInfo;
import com.zxm.graduatemanagesystem.service.IStudentService;
import com.zxm.graduatemanagesystem.vo.back.StudentVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 2019/3/7
 * Create by zhouximin
 * Description:
 */
@Service
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

    @Override
    public StudentInfo getStudentById(Integer id) {
        return studentInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public StudentVO getStudentVOById(Integer id) {
         StudentInfo studentInfo = studentInfoMapper.selectByPrimaryKey(id);
         StudentVO studentVO = new StudentVO();
         studentVO.setEducation(studentInfo.getEducation());
         studentVO.setEducationText(EducationEnum.getDescById(studentInfo.getEducation()));
         studentVO.setGender(studentInfo.getGender());
         studentVO.setGenderText(GenderEnum.getDescById(studentInfo.getGender()));
         studentVO.setInstitude(studentInfo.getInstitude());
         studentVO.setInstitudeText(InstitudeEnum.getDescById(studentInfo.getInstitude()));
         return studentVO;
    }
}

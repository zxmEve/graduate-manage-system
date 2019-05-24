package com.zxm.graduatemanagesystem.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.zxm.graduatemanagesystem.dao.CompanyInfoDao;
import com.zxm.graduatemanagesystem.dao.mapper.CompanyInfoMapper;
import com.zxm.graduatemanagesystem.dao.mapper.StudentInfoMapper;
import com.zxm.graduatemanagesystem.model.CompanyInfo;
import com.zxm.graduatemanagesystem.model.StudentInfo;
import com.zxm.graduatemanagesystem.model.UserCriteria;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxm.graduatemanagesystem.dao.UserDao;
import com.zxm.graduatemanagesystem.dao.mapper.UserMapper;
import com.zxm.graduatemanagesystem.model.User;
import com.zxm.graduatemanagesystem.service.IUserService;

/**
 * 2019/3/5
 * Create by zhouximin
 * Description:
 */
@Service
public class UserService implements IUserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserDao userDao;
    @Resource
    private StudentInfoMapper studentInfoMapper;
    @Resource
    private CompanyInfoDao companyInfoDao;

    @Override
    public List<User> getUserList() {
        return userMapper.selectByExample(null);
    }

    @Override
    public User login(String username, String password) {
        return userMapper.login(username,password);
    }

    @Override
    public User selectById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public User selectByUsername(String username) {
        UserCriteria criteria = new UserCriteria();
        criteria.createCriteria().andUsernameEqualTo(username);
        User user = null;
        List<User> list = userMapper.selectByExample(criteria);
        if(list.size() != 0){
            user = list.get(0);
        }
        return user;
    }

    @Override
    public int deleteUser(int id) {
        CompanyInfo companyInfo = companyInfoDao.getCompanyByUserId(id);
        StudentInfo studentInfo = studentInfoMapper.getStudentByUserId(id);
        if(studentInfo != null || companyInfo != null)
            return -1;
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageInfo getUserList(int pageNum, int pageSize) {
        List<User> list = userMapper.selectByExample(null);
        PageHelper.startPage(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo getUserListByType(int pageNum, int pageSize, Byte type) {
        List<User> list = userDao.getUserListByType(type);
        PageHelper.startPage(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo<>(list);
        return pageInfo;
    }


}

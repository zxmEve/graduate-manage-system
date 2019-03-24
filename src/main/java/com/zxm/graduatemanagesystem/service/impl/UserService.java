package com.zxm.graduatemanagesystem.service.impl;

import java.util.List;

import javax.annotation.Resource;

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

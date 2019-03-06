package com.zxm.graduatemanagesystem.service.impl;

import com.zxm.graduatemanagesystem.dao.mapper.UserMapper;
import com.zxm.graduatemanagesystem.model.User;
import com.zxm.graduatemanagesystem.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 2019/3/5
 * Create by zhouximin
 * Description:
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

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


}

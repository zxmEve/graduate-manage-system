package com.zxm.graduatemanagesystem.dao.impl;

import com.zxm.graduatemanagesystem.dao.UserDao;
import com.zxm.graduatemanagesystem.dao.mapper.UserMapper;
import com.zxm.graduatemanagesystem.model.User;
import com.zxm.graduatemanagesystem.model.UserCriteria;

import javax.annotation.Resource;
import java.util.List;

/**
 * 2019/3/10
 * Create by zhouximin
 * Description:
 */
public class UserDaoImpl implements UserDao {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> getUserListByType(Byte type) {
        UserCriteria userCriteria = new UserCriteria();
        userCriteria.createCriteria().andUserTypeEqualTo(type);

        return userMapper.selectByExample(userCriteria);
    }
}

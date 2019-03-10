package com.zxm.graduatemanagesystem.dao;

import com.zxm.graduatemanagesystem.model.User;

import java.util.List;

/**
 * 2019/3/10
 * Create by zhouximin
 * Description:
 */
public interface UserDao {
    List<User> getUserListByType(Byte type);
}

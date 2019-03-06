package com.zxm.graduatemanagesystem.service;

import com.zxm.graduatemanagesystem.model.User;

import java.util.List;

/**
 * 2019/3/5
 * Create by zhouximin
 * Description:
 */
public interface IUserService {
    List<User> getUserList();

    User login(String username, String password);

    User selectById(Integer id);

    int updateUser(User user);

}

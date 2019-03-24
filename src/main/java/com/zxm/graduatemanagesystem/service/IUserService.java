package com.zxm.graduatemanagesystem.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zxm.graduatemanagesystem.model.User;

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

    PageInfo getUserList(int pageNum, int pageSize);

    PageInfo getUserListByType(int pageNum, int pageSize, Byte type);

    int insertUser(User user);

}

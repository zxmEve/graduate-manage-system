package com.zxm.graduatemanagesystem.constants;

import lombok.Data;

/**
 * 2019/3/19
 * Create by zhouximin
 * Description:
 */
public enum  UserTypeEnum implements BaseEnum {
    ADMINSTRATOR(1,"管理员"),
    STUDENT(2,"学生"),
    COMPANY(3,"公司");

    UserTypeEnum(int id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    private int id;
    private String desc;

    @Override
    public int getIntValue() {
        return id;
    }

    @Override
    public String getText() {
        return desc;
    }
}

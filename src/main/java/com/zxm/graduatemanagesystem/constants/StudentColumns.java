package com.zxm.graduatemanagesystem.constants;

/**
 * 2019/3/18
 * Create by zhouximin
 * Description:
 */
public enum StudentColumns implements BaseEnum {
    ID(1, "ID"),
    NAME(2, "姓名"),
    USERNAME(3, "用户名/学号"),
    COLLEGE(4, "学院"),
    PROFESSION(5, "专业"),
    CLASS(6, "班级"),
    GENDER(7, "性别"),
    PHONE(8, "电话");

    private int id;
    private String desc;

    StudentColumns(int id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    @Override
    public int getIntValue() {
        return id;
    }

    @Override
    public String getText() {
        return desc;
    }
}

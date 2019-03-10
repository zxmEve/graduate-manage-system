package com.zxm.graduatemanagesystem.constants;

/**
 * 2019/3/7
 * Create by zhouximin
 * Description:
 */
public enum StatusEnum implements BaseEnum {
    NORMAL(1,"正常"),
    CANCELLED(2, "取消");

    private int id;
    private String desc;
    StatusEnum(int id, String desc){
        this.id = id;
        this.desc = desc;
    }
    @Override
    public int getIntValue() {
        return id;
    }

    @Override
    public String getText() {
        return null;
    }
}

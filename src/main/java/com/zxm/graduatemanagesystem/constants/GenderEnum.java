package com.zxm.graduatemanagesystem.constants;

/**
 * @Description: java类作用描述
 * @Author: zxm
 * @CreateDate: 2019/5/25 3:37
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public enum GenderEnum implements BaseEnum{
    MALE(1,"男"),
    FEMALE(2,"女")
    ;

    private int id;
    private String desc;

    GenderEnum(int id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public static String getDescById(int id){
        for (GenderEnum articalTypeEnum : GenderEnum.values()) {
            if (articalTypeEnum.getIntValue() == id) {
                return articalTypeEnum.getText();
            }
        }
        return "";
    }
    public int getId() {
        return id;
    }

    public String getDesc() {
        return desc;
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

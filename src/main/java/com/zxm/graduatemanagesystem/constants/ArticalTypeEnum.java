package com.zxm.graduatemanagesystem.constants;

/**
 * 2019/3/7
 * Create by zhouximin
 * Description: 文章类型
 */
public enum ArticalTypeEnum implements BaseEnum{
    NOTICE(1, "通知公告"),
    NEWS(2, "新闻动态"),
    POLICY(3, "政策法规"),
    WORKING_PROCESS(4,"办事流程"),
    CAREER_GUIDE(5,"就业指导");

    private int id;
    private String desc;

    ArticalTypeEnum(int id,String desc){
        this.id = id;
        this.desc = desc;
    }

    public static String getDescById(int id){
        for (ArticalTypeEnum articalTypeEnum : ArticalTypeEnum.values()) {
            if (articalTypeEnum.getIntValue() == id) {
                return articalTypeEnum.getText();
            }
        }
        return "";
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

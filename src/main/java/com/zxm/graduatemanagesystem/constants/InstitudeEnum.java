package com.zxm.graduatemanagesystem.constants;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author zhouximin
 * Created on 2019-03-30
 * 学院枚举
 */

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum InstitudeEnum {
    JI_SUAN_JI(1, "计算机与信息学院"),
    DIAN_QI(2, "电气与新能源学院"),
    SHUI_LI(3, "水利与环境学院"),

    ;

    int instituId;
    String instituName;

    InstitudeEnum(int instituId, String instituName) {
        this.instituId = instituId;
        this.instituName = instituName;
    }

    public int getInstituId() {
        return instituId;
    }

    public String getInstituName() {
        return instituName;
    }

    public static Map<Integer, InstitudeEnum> INSTITUDE_MAP;

    static {
        INSTITUDE_MAP = Arrays.stream(InstitudeEnum.values())
                .collect(Collectors.toMap(InstitudeEnum::getInstituId, institude -> institude));
    }
    public static String getDescById(int id){
        for (InstitudeEnum articalTypeEnum : InstitudeEnum.values()) {
            if (articalTypeEnum.getInstituId() == id) {
                return articalTypeEnum.getInstituName();
            }
        }
        return "";
    }

    public static InstitudeEnum ofValue(int id) {
        return INSTITUDE_MAP.getOrDefault(id, InstitudeEnum.JI_SUAN_JI);
    }
}

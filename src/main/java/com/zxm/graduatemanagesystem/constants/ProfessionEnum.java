package com.zxm.graduatemanagesystem.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author zhouximin
 * Created on 2019-03-30
 * 专业枚举
 */

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ProfessionEnum {

    // 计算机学院 id: 1
    JI_SUAN_JI_KE_XUE(1, 1, "计算机科学与技术"),
    WU_LIAN_WANG(2, 1, "物联网工程"),
    SHU_ZI_MEI_TI(3, 1, "数字媒体技术"),
    XIN_XI_GUAN_LI(4, 1, "信息管理与信息系统"),
    TONG_XIN(5, 1, "通信工程"),
    DIAN_ZI_XIN_XI(6, 1, "电子信息工程"),

    // 电气学院 id: 2
    DIAN_QI_GONG_CHENG(7, 2, "电气工程及其自动化"),
    SHU_DIAN_XIAN_LU(8, 2, "输电线路工程"),
    ZI_DONG_HUA(9, 2, "自动化"),
    ZHI_NENG_DIAN_WANG(10, 2, "智能电网信息工程"),

    // 水利环境学院 id: 3
    SHUI_LI_SHUI_DIAN(11, 3, " 水利水电工程"),
    SHUI_WEN_SHUI_ZI_YUAN(12, 3, "水文与水资源工程"),
    GONG_CHENG_GUAN_LI(13, 3, "工程管理"),
    HUAN_JING_GONG_CHENG(14, 3, "环境工程"),
    GONG_CHENG_ZAO_JIA(15, 3, "工程造价"),
    GANG_KOU_HANG_DAO(16, 3, "港口航道与海岸工程"),
    ;

    int professionId;
    int institudeId;
    String professionName;

    ProfessionEnum(int professionId, int instituId, String professionName) {
        this.institudeId = instituId;
        this.professionId = professionId;
        this.professionName = professionName;
    }

    public int getProfessionId() {
        return professionId;
    }

    public String getProfessionName() {
        return professionName;
    }

    public int getInstitudeId() {
        return institudeId;
    }

    public static Map<Integer, ProfessionEnum> PROFESSION_MAP;
    public static Map<Integer, List<ProfessionEnum>> INSTITUDE_PROFESSION_MAP = new HashMap<>();

    static {
        // 初始化专业id对应的专业枚举
        PROFESSION_MAP = Arrays.stream(ProfessionEnum.values()).collect(Collectors
                .toMap(ProfessionEnum::getProfessionId, professionEnum -> professionEnum));

        // 初始化学院对应的专业列表
        Arrays.stream(ProfessionEnum.values()).forEach(professionEnum ->
            INSTITUDE_PROFESSION_MAP
                    .computeIfAbsent(professionEnum.getInstitudeId(), ArrayList::new)
                    .add(professionEnum)
        );
    }

    // 根据id获取专业
    public static ProfessionEnum ofValue(int id) {
        return PROFESSION_MAP.getOrDefault(id, ProfessionEnum.JI_SUAN_JI_KE_XUE);
    }

    // 根据学院id获取专业列表
    public static List<ProfessionEnum> getProFessionsByInstitude(int institudeId) {
        return INSTITUDE_PROFESSION_MAP.get(institudeId);
    }
}

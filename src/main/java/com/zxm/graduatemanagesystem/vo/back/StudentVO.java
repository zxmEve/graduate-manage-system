package com.zxm.graduatemanagesystem.vo.back;

import lombok.Data;

/**
 * @Description: java类作用描述
 * @Author: zxm
 * @CreateDate: 2019/5/25 3:32
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Data
public class StudentVO {
    private Integer id;

    private Integer userId;

    private String name;

    private String idNum;

    private Byte gender;

    private String genderText;

    private String nation;

    private Byte institude;

    private String institudeText;

    private Byte profession;

    private String professionText;

    private Byte education;

    private String educationText;

    private String phone;

    private String studentClass;

    private String studentId;
}

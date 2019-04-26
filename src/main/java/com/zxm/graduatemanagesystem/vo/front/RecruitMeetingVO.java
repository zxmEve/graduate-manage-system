package com.zxm.graduatemanagesystem.vo.front;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 2019/3/24
 * Create by zhouximin
 * Description:
 */
@Data
public class RecruitMeetingVO {
    private Integer id;

    private String title;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private String startTime;

    @DateTimeFormat(pattern = "HH:mm")
    @JsonFormat(pattern = "HH:mm", timezone = "GMT+8")
    private String endTime;

    private String address;

    private String content;
}

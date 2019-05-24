package com.zxm.graduatemanagesystem.vo.front;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;


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
    @Getter
    private String startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @Getter
    private String endTime;

    private String address;

    private String content;

    private int authorId;
}

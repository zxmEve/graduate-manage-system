package com.zxm.graduatemanagesystem.service;

import com.zxm.graduatemanagesystem.constants.BaseEnum;
import com.zxm.graduatemanagesystem.dto.EnumDTO;

import java.util.List;

/**
 * 2019/3/18
 * Create by zhouximin
 * Description:
 */
public interface IDictionaryService {
     <T extends BaseEnum> List<EnumDTO> getDictionary(T[] obj);
}

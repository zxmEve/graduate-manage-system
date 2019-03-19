package com.zxm.graduatemanagesystem.service.impl;

import com.zxm.graduatemanagesystem.constants.BaseEnum;
import com.zxm.graduatemanagesystem.dto.EnumDTO;
import com.zxm.graduatemanagesystem.service.IDictionaryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 2019/3/18
 * Create by zhouximin
 * Description:
 */
@Service
public class DictionaryService implements IDictionaryService {
    @Override
    public <T extends BaseEnum> List<EnumDTO> getDictionary(T[] obj) {
        List<EnumDTO> typeList = new ArrayList<>();
        for (T type : obj) {
            if (type != null) {
                EnumDTO EnumDTO = new EnumDTO();
                EnumDTO.setId(type.getIntValue());
                EnumDTO.setDesc(type.getText());
                typeList.add(EnumDTO);
            }
        }
        return typeList;
    }
}

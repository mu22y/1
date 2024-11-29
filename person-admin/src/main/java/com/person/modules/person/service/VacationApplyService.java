package com.person.modules.person.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.person.common.utils.PageUtils;
import com.person.modules.person.entity.ConvertApplyEntity;
import com.person.modules.person.entity.VacationApplyEntity;

import java.util.Map;

public interface VacationApplyService extends IService<VacationApplyEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void deleteBatch(Long[] ids);

    void update(VacationApplyEntity record);
}

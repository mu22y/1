package com.person.modules.person.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.person.common.utils.PageUtils;
import com.person.modules.person.entity.EvectionApplyEntity;
import com.person.modules.person.entity.VacationApplyEntity;

import java.util.Map;

/**
 * @Author:宋红崇
 * @Date:12:34 2024/4/11
 **/
public interface EvectionApplyService extends IService<EvectionApplyEntity> {
    PageUtils queryPage(Map<String, Object> params);

    void deleteBatch(Long[] ids);

    void update(EvectionApplyEntity record);
}

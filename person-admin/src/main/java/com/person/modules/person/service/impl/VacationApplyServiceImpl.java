/**
 *
 */

package com.person.modules.person.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.person.common.utils.Constant;
import com.person.common.utils.PageUtils;
import com.person.common.utils.Query;
import com.person.modules.person.dao.VacationApplyDao;
import com.person.modules.person.entity.VacationApplyEntity;
import com.person.modules.person.entity.VacationApplyEntity;
import com.person.modules.person.service.VacationApplyService;
import com.person.modules.sys.service.SysUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service("vacationApplyService")
public class VacationApplyServiceImpl extends ServiceImpl<VacationApplyDao, VacationApplyEntity> implements VacationApplyService {
    @Autowired
    SysUserService userService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Long applyUserId = (Long) params.get("applyUserId");

        IPage<VacationApplyEntity> page = this.page(
                new Query<VacationApplyEntity>().getPage(params),
                new QueryWrapper<VacationApplyEntity>().
                        eq(applyUserId != null, "apply_user_id", applyUserId)
                        .apply(params.get(Constant.SQL_FILTER) != null, (String) params.get(Constant.SQL_FILTER))
        );
        List<VacationApplyEntity> records = page.getRecords();
        List<VacationApplyEntity> list = new ArrayList<VacationApplyEntity>();
        for (VacationApplyEntity r : records) {
            Long userId = r.getApplyUserId();
            Long approvalUserId = r.getApprovalUserId();
            if (null != userId) {
                r.setApplyName(userService.getById(userId).getName());
            }
            if (null != approvalUserId) {
                r.setApprovalName(userService.getById(approvalUserId).getName());
            }
            list.add(r);
        }
        page.setRecords(list);
        return new PageUtils(page);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        this.removeByIds(Arrays.asList(ids));
    }

    @Override
    public void update(VacationApplyEntity record) {
        this.updateById(record);
    }
}

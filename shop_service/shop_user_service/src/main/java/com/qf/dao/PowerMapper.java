package com.qf.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.entity.Power;

import java.util.List;

public interface PowerMapper extends BaseMapper<Power> {
   List<Power> querylist();
   List<Power> queryPowerByRid(Integer rid);
}

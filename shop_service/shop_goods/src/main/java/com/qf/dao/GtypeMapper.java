package com.qf.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.entity.Gtype;

import java.util.List;

public interface GtypeMapper extends BaseMapper<Gtype> {

   public List<Gtype> gtypelist();
}

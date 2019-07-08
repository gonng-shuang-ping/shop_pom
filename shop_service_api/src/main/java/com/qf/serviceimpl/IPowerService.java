package com.qf.serviceimpl;

import com.qf.entity.Power;

import java.util.List;

public interface IPowerService {

   public List<Power> queryAll();

   public int insertPower(Power power);

   public List<Power> powerListByRid(Integer rid);
}

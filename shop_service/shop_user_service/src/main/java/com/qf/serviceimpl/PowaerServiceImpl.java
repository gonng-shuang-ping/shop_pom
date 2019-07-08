package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.PowerMapper;
import com.qf.entity.Power;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class PowaerServiceImpl implements IPowerService {
    @Autowired
    PowerMapper powerMapper;
    @Override
    public List<Power> queryAll() {
//        List<Power> powers = powerMapper.selectList(null);
        List<Power> powers =powerMapper.querylist();
        return powers;
    }

    @Override
    public int insertPower(Power power) {
        int insert = powerMapper.insert(power);
        return insert;
    }

    @Override
    public List<Power> powerListByRid(Integer rid) {
        return powerMapper.queryPowerByRid(rid);
    }
}

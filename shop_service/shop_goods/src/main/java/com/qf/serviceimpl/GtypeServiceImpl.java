package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.GtypeMapper;
import com.qf.entity.Gtype;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class GtypeServiceImpl implements  IGtypeService {
    @Autowired
    GtypeMapper gtypeMapper;
    @Override
    public List<Gtype> gtypelist() {
//        List<Gtype> gtypes = gtypeMapper.selectList(null);
       List<Gtype> gtypes = gtypeMapper.gtypelist();
        return gtypes;
    }

    @Override
    public List<Gtype> queryAll() {
        List<Gtype> gtypes = gtypeMapper.selectList(null);
        return gtypes;
    }

    @Override
    public int insertGtype(Gtype gtype) {
        int insert = gtypeMapper.insert(gtype);
        return insert;
    }
}

package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.GoodsMapper;
import com.qf.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class GoodsServiceImpl implements IGoodsService {
    @Autowired
    GoodsMapper goodsMapper;
    @Override
    public List<Goods> queryAll() {
//        List<Goods> goods = goodsMapper.selectList(null);
        List<Goods> goods = goodsMapper.queryAll();
        return goods;
    }

    @Override
    public int insert(Goods goods) {
        int insert = goodsMapper.insert(goods);
        return insert;
    }
}

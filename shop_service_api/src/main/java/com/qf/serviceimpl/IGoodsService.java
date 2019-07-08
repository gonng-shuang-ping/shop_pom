package com.qf.serviceimpl;

import com.qf.entity.Goods;

import java.util.List;

public interface IGoodsService {
    public List<Goods> queryAll();

    public  int insert(Goods goods);
}

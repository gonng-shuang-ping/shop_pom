package com.qf.serviceimpl;

import com.qf.entity.Gtype;

import java.util.List;

public interface IGtypeService {
    public List<Gtype> gtypelist();

    public List<Gtype> queryAll();


    public int insertGtype(Gtype gtype);
}

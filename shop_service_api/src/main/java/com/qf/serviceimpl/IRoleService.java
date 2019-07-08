package com.qf.serviceimpl;

import com.qf.entity.Role;

import java.util.List;

public interface IRoleService {
    public List<Role> queryAll();

    public int insertRole(Role role);

    public List<Role> roleListByUid(Integer uid);

    int updateRolePowers(Integer rid, Integer[] pids);
}

package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qf.dao.RoleMapper;
import com.qf.dao.RolePowerMapper;
import com.qf.entity.Role;
import com.qf.entity.RolePowerTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    RolePowerMapper rolePowerMapper;
    @Override
    public List<Role> queryAll() {
        List<Role> roles = roleMapper.selectList(null);
        return roles;
    }
    @Override
    public int insertRole(Role role) {
        int insert = roleMapper.insert(role);
        return insert;
    }

    @Override
    public List<Role> roleListByUid(Integer uid) {
        return roleMapper.queryListByUid(uid);
    }

    @Override
    @Transactional
    public int updateRolePowers(Integer rid, Integer[] pids) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("rid", rid);
        rolePowerMapper.delete(queryWrapper);
        for (Integer pid : pids) {
            rolePowerMapper.insert(new RolePowerTable(rid, pid));
        }
        return 1;
    }

}

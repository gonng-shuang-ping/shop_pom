package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qf.dao.BackUserMapper;
import com.qf.dao.UserRoleMapper;
import com.qf.entity.BackUser;
import com.qf.entity.UserRoleTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class BackUserServiceImpl implements IBackUserService {
    @Autowired
    BackUserMapper backUserMapper;
    @Autowired
    UserRoleMapper  userRoleMapper;
    @Override
    public List<BackUser> queryAll() {
        List<BackUser> users = backUserMapper.selectList(null);
        return users;
    }

    @Override
    public int insertUser(BackUser backUser) {
        return backUserMapper.insert(backUser);
    }

    @Override
    @Transactional
    public int updateUserRoles(Integer uid, Integer[] rid) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("uid", uid);
        userRoleMapper.delete(queryWrapper);
        for (Integer roleid : rid) {
            UserRoleTable userRoleTable = new UserRoleTable(uid, roleid);
            userRoleMapper.insert(userRoleTable);
        }
        return 1;
    }

//    @Override
//    public BackUser login(String username, String password) {
//        BackUser backUser = backUserMapper.queryByUserName(username);
//
//        if(backUser != null && backUser.getPassword().equals(password)){
//            return backUser;
//        }
//        return null;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BackUser backUser = backUserMapper.queryByUserName(username);
        return backUser;
    }
}

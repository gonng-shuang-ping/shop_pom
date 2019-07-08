package com.qf.serviceimpl;

import com.qf.entity.BackUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IBackUserService extends UserDetailsService {

    public  List<BackUser> queryAll();

    public  int insertUser(BackUser backUser);

    public int updateUserRoles(Integer uid, Integer[] rid);

//    public BackUser login(String username, String password);
}

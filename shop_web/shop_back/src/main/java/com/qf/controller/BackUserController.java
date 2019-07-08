package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.BackUser;
import com.qf.serviceimpl.IBackUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class BackUserController {
    @Reference
    IBackUserService backUserService;
    @RequestMapping("/tobuserlist")
    public String tobuserlist(Model model){
        List<BackUser> users=backUserService.queryAll();
        model.addAttribute("users",users);
        return "backList";
    }
    @RequestMapping("/useradd")
    public String useradd(BackUser backUser){
        backUserService.insertUser(backUser);
        return "redirect:/user/tobuserlist";
    }
    @RequestMapping("/updaterole")
    public String updateUserRole(Integer uid, Integer[] rid){
        backUserService.updateUserRoles(uid, rid);
        return "redirect:/user/tobuserlist";
    }
}

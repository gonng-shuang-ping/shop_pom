package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.Role;
import com.qf.serviceimpl.IRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Reference
    IRoleService roleService;
    @RequestMapping("/torolelist")
    public  String toroleList(Model model){
        List<Role> roles=roleService.queryAll();
        model.addAttribute("roles",roles);
        return "roleList";
    }
    @RequestMapping("roleadd")
    public String roleadd(Role role){
        int i=roleService.insertRole(role);
        return "redirect:/role/torolelist";
    }

    @RequestMapping("roleselect")
    @ResponseBody
    public List<Role> roleselect(Integer uid){
        List<Role> roles = roleService.roleListByUid(uid);
        return roles;
    }

    @RequestMapping("/updatePower")
    @ResponseBody
    public String updatePower(Integer rid, @RequestParam("pids[]") Integer[] pids){
        roleService.updateRolePowers(rid, pids);
        return "succ";
    }
}

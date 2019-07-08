package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.serviceimpl.IBackUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("loginUser")
public class LoginController {

    @Reference
    private IBackUserService userService;
    @RequestMapping("/tologin")
    public String tologin(){
        return "login";
    }
//    @RequestMapping("/login")
//    public String login(String username, String password, Model model){
//        BackUser user = userService.login(username, password);
//
//        if(user != null){
//            model.addAttribute("loginUser", user);
//            return "index";
//        }
//        return "redirect:/tologin?error=1";
//    }
}

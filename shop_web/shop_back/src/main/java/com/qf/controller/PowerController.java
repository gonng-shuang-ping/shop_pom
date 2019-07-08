package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.Power;
import com.qf.serviceimpl.IPowerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/power")
public class PowerController {
    @Reference
    IPowerService powerService;
    @RequestMapping("/topowerlist")
    public String topowerlist(Model model){
        List<Power> powers =powerService.queryAll();
        model.addAttribute("powers",powers);
        return "powerlist";
    }
    @RequestMapping("/powerajax")
    @ResponseBody
    public List<Power> powerajax(Model model){
        List<Power> powers =powerService.queryAll();
        return powers;
    }
    @RequestMapping("/poweradd")
    public String poweradd(Power power){
        int i= powerService.insertPower(power);
        return "redirect:/power/topowerlist";
    }
    @RequestMapping("/queryPowersByRid")
    @ResponseBody
    public List<Power> queryPowersByRid(Integer rid){
        List<Power> powers = powerService.powerListByRid(rid);
        return powers;
    }
}

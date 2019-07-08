package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.Gtype;
import com.qf.serviceimpl.IGtypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/gtype")
public class GtypeController {
    @Reference
    IGtypeService gtypeService;
    @RequestMapping("/gtypelist")
    public String gtypeList(Model model){
        List<Gtype> gtypes=gtypeService.gtypelist();
        model.addAttribute("gtypes",gtypes);
        return "gtype";
    }
    @RequestMapping("/gtypeajax")
    @ResponseBody
    public List<Gtype> gtypeajax(){
        List<Gtype> gtypelist = gtypeService.queryAll();
        return gtypelist;
    }

    @RequestMapping("/gtypeAdd")
    public String gtypeAdd(Gtype gtype){
        int i=gtypeService.insertGtype(gtype);
        return "redirect:/gtype/gtypelist";
    }
}

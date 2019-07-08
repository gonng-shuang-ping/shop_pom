package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.Goods;
import com.qf.serviceimpl.IGoodsService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Reference
    IGoodsService goodsService;

    @RequestMapping("/goodslist")
    public String goodsList(Model model){
        List<Goods> goods=goodsService.queryAll();
        model.addAttribute("goods",goods);
        return "goods";
    }
    @RequestMapping("/goodsadd")
    public String goodsadd(Goods goods){
        goodsService.insert(goods);
        return "redirect:/goods/goodslist";
    }

    @Value("${upload.Path}")
   private String uploadPath;


    @RequestMapping("/uploadimg")
    @ResponseBody
    public String uploadimg(MultipartFile file ){
        String filename = file.getOriginalFilename();
//        int index = filename.lastIndexOf(".");
//        String substring = filename.substring(index);
          String uppath="";
//        String string = UUID.randomUUID().toString()+substring;
//          uppath=uploadPath+string;
        uppath=uploadPath+filename;
        try (
                InputStream inputStream = file.getInputStream();
                OutputStream outputStream=new FileOutputStream(uppath);
            ){
            IOUtils.copy(inputStream,outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "{\"filepath\":\"" + uppath + "\"}";
    }

    @RequestMapping("/getImg")
    public void getImg(String imgpath, HttpServletResponse response){
        //查询本地的文件
        File file = new File(imgpath);

        try (
                InputStream in = new FileInputStream(file);
                OutputStream out = response.getOutputStream();
        ){

            IOUtils.copy(in, out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

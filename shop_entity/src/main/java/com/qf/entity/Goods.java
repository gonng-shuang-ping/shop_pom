package com.qf.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods implements Serializable {
      @TableId(type = IdType.AUTO)
      private Integer id;
      //商品名
      private String gname;
      //商品描述
      private String ginfo;
      //商品图片
      private String  gimage;
      //商品价格
      private BigDecimal gprice;
      //商品类别id
      private Integer tid;
      //库存
      private Integer gsave;
      @TableField(exist = false)
      private String tname;
}

package com.qf.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gtype implements Serializable {
    //类别id
    @TableId(type = IdType.AUTO)
    private Integer id;
    //商品父类别id
    private Integer fid;
    //商品类别名称
    private String tname;
    @TableField(exist = false)
    private String pname;
}

package com.qf.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Power implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer pid;
    private String powername;
    private String powerpath;
    private Date createtime;
    private Integer status;
    @TableField(exist = false)
    private String pname;
}

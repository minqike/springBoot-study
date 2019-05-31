package com.min.mybatis.demo.easypoi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@ExcelTarget("Computer")
@NoArgsConstructor
@AllArgsConstructor
public class Computer implements Serializable {

    private Integer id;
    @Excel(name = "分行",width = 20)
    private String branch;
    @Excel(name = "部门",width = 20)
    private String department;
    @Excel(name = "团队",width = 20)
    private String tuandui;
    @Excel(name = "资产",width = 20)
    private String assect;
    @Excel(name = "电脑名",width = 20)
    private String computerName;
    @Excel(name = "序列号",width = 20)
    private String computerSerial;
    @Excel(name = "型号",width = 20)
    private String computerModel;
    @Excel(name = "电脑类型")
    private String computer_type;
    @Excel(name = "连接类型")
    private String connect_type;
    private String start_date;
    private String use_status;
    private String useage;
    private String useage_comment;
    private Date create_time;


}

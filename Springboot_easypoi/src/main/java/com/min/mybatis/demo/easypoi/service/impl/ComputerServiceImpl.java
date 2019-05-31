package com.min.mybatis.demo.easypoi.service.impl;

import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.min.mybatis.demo.easypoi.entity.Computer;
import com.min.mybatis.demo.easypoi.mapper.ComputerMapper;
import com.min.mybatis.demo.easypoi.service.ComputerService;
import com.min.mybatis.demo.easypoi.utils.ExcelUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ComputerServiceImpl implements ComputerService {
    @Autowired
    ComputerMapper computerMapper;


    @Override
    @Cacheable(cacheNames = "Computer", key = "'Computer:all'")
    public List<Computer> findAll() {
        return computerMapper.FindAll();
    }

    @Override
    @Cacheable(cacheNames = "Computer", key = "'Computer-'+#id")
    public Computer findById(Integer id) {
        return computerMapper.FindById(id);
    }

    @Override
    public Integer countAll() {
        return computerMapper.countAll();
    }

    @Override
    public void exportUseTemplate(HttpServletResponse response) throws Exception {
        List<Computer> list = new ArrayList<Computer>();
        list = computerMapper.FindAll();

        // 获取导出excel指定模版
        TemplateExportParams params = new TemplateExportParams();
//        // 标题开始行
//        params.setHeadingStartRow(0);
//        // 标题行数
//        params.setHeadingRows(2);
        // 设置sheetName，若不设置该参数，则使用得原本得sheet名称
        params.setSheetName("电脑信息");

//        params.setHeadingRows(2);
//        params.setHeadingStartRow(2);
//        params.setTempParams("t");

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("list", list);
        Workbook workbook = ExcelUtil.getWorkbook(params, data, "template/computer.xlsx");
        ExcelUtil.export(response, workbook, "电脑信息");

    }

    @Override
    public void export(HttpServletResponse response) throws IOException {
        List<Computer> list = computerMapper.FindAll();

        ExcelUtil.exportExcel(list, "电脑信息表", "电脑信息", Computer.class, "电脑信息", response);


    }


}

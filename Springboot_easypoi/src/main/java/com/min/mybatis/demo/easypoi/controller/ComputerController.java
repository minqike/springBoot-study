package com.min.mybatis.demo.easypoi.controller;

import com.min.mybatis.demo.easypoi.entity.Computer;
import com.min.mybatis.demo.easypoi.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class ComputerController {
    @Autowired
    ComputerService computerService ;

    @GetMapping("/computer/getall")
    public List<Computer> getAll() {
        return computerService.findAll();
    }

    @GetMapping("/computer/{id}")
    public Computer getById(@PathVariable("id") Integer id) {
        return computerService.findById(id);
    }

    @GetMapping("/computer/count")
    public Integer count() {
        return computerService.countAll();
    }

    /**
     * 不使用模板导出excel
     * @param response
     * @throws Exception
     */
    @GetMapping("/computer/export")
    public void export(HttpServletResponse response) throws IOException {
        computerService.export(response);
    }

    /**
     * 使用模板导出excel
     * @param response
     * @throws Exception
     */
    @GetMapping("/computer/export2")
    public void export2(HttpServletResponse response) throws Exception {
        computerService.exportUseTemplate(response);
    }
}

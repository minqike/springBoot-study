package com.min.mybatis.demo.easypoi.service;

import com.min.mybatis.demo.easypoi.entity.Computer;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
public interface ComputerService {

    public List<Computer> findAll();

    public Computer findById(Integer id);

    public Integer countAll();

    public void exportUseTemplate(HttpServletResponse response) throws Exception;
    public void export(HttpServletResponse response) throws IOException;
}

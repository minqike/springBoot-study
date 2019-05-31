package com.min.mybatis.demo.easypoi.mapper;

import com.min.mybatis.demo.easypoi.entity.Computer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ComputerMapper {
    @Select("select * from computer")
    public List<Computer> FindAll();

    @Select("select * from computer where id=#{id}")
    public Computer FindById(Integer id);

    public Integer countAll();
}

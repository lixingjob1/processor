package com.example.processor.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component("customerMapper")
public interface CustomerMapper {

    List<Map<String,Object>> selectCusList(@Param(value = "name") String name);

    void updateCus(Map<String,Object> map);

    void addCus(Map<String,Object> map);

    void remove(Integer id);
}

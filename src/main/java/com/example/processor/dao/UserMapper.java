package com.example.processor.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserMapper {

    Map<String,Object> selectLogin(Map<String,Object> map);
}

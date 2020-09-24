package com.example.processor.service;


import com.example.processor.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public Map<String,Object> selectLogin(Map<String,Object> map){
        return userMapper.selectLogin(map);
    }



}

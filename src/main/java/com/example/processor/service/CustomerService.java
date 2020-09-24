package com.example.processor.service;


import com.example.processor.dao.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    public List<Map<String,Object>> selectCusList(String name){
        return customerMapper.selectCusList(name);
    }


    public void updateCus(Map<String,Object> map){
        customerMapper.updateCus(map);
    }

    public void addCus(Map<String,Object> map){
        customerMapper.addCus(map);
    }

    public void remove(Integer id){
        customerMapper.remove(id);
    }

}

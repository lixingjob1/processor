package com.example.processor.controller;

import com.example.processor.core.common.Result;
import com.example.processor.service.CustomerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;


/**
 * 客户
 *
 * @author: lx
 * @date: 2019/4/21
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    private Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;


    @RequestMapping("/list")
    public Map<String,Object> selectCusList(Integer pageNumber,Integer pageSize,String name){
        if(pageNumber != null){
            PageHelper.startPage(pageNumber,pageSize);
        }
        List<Map<String, Object>> adinList = customerService.selectCusList(name);
        //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        if(pageNumber != null){
            //pageINfo封装了分页的详细信息，也可以指定连续显示的页数
            PageInfo pageInfo = new PageInfo<>(adinList);
            return Result.success(pageInfo);
        }else{
            return Result.success(adinList);
        }
    }

    @RequestMapping("/update")
    public Map<String,Object> updateCus(@RequestBody Map<String,Object> map){
        customerService.updateCus(map);
        return Result.success();
    }

    @RequestMapping("/add")
    public Map<String,Object> addCus(@RequestBody Map<String,Object> map){
        customerService.addCus(map);
        return Result.success();
    }

    @RequestMapping("/remove")
    public Map<String,Object> remove(Integer id){
        customerService.remove(id);
        return Result.success();
    }



}

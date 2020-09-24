package com.example.processor.controller;

import com.example.processor.core.common.Result;
import com.example.processor.service.UserService;
//import io.micrometer.core.instrument.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * user用户
 *
 * @author: lx
 * @date: 2019/4/21
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private Logger loginLogger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    @RequestMapping("/login")
    public Map<String,Object> login(@RequestBody Map<String,Object> map, HttpServletRequest request){
        String userName = String.valueOf(map.get("userName"));
        String passWord = String.valueOf(map.get("passWord"));
        //Assert.isTrue(StringUtils.isNotBlank(userName), "用户名不能为空");
        //Assert.isTrue(StringUtils.isNotBlank(passWord), "密码不能为空");
        String passWrd = DigestUtils.md5DigestAsHex(passWord.getBytes());
        Map<String,Object> userMap = userService.selectLogin(map);
        if (userMap != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("userId", userMap.get("id"));
            session.setAttribute("userName", userName);
            loginLogger.info("[" + userName + "]登录成功");
            return Result.success(userMap);
        } else {
            return Result.error("用户名或密码不正确!");
        }
    }


    /**
     * 用户退出
     * @param request
     * @return
     */
    @GetMapping("/exit")
    public Map<String,Object> login(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session != null) {
            session.invalidate();
        }
        return Result.success();
    }

}

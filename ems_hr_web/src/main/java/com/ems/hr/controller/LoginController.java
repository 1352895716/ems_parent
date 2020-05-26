package com.ems.hr.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: LoginController
 * @Description: TODO
 * @Autor:13528
 * @Date: 2020/3/21 16:11
 * @Version 1.0
 **/
@RestController
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/name")
    public Map<String, String> name(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Map <String,String>map = new HashMap<>();
        map.put("loginName",name);
        return map;
    }
}

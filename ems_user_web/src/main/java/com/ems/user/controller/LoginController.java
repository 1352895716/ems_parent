package com.ems.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ems.pojo.Staff;
import com.ems.service.StaffService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: LoginController
 * @Description: TODO
 * @Autor:13528
 * @Date: 2020/3/17 20:30
 * @Version 1.0
 **/
@RestController
@RequestMapping("/login")
public class LoginController {

    @Reference
    StaffService staffService;
    @RequestMapping("/findEntity")
    public Staff findEntity(){
        //获取员工编号
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        //从编号中获取id
        Integer id = Integer.valueOf(username.substring(6));
        return staffService.findOne(id);
    }
}

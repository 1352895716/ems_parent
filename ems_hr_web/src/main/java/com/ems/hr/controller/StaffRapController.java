package com.ems.hr.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ems.pojo.StaffRap;
import com.ems.service.StaffRapService;
import entity.PageResult;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: StaffRapController
 * @Description: TODO
 * @Autor:13528
 * @Date: 2020/3/25 11:10
 * @Version 1.0
 **/
@RestController
@RequestMapping("/staffRap")
public class StaffRapController {

    @Reference
    StaffRapService staffRapService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody StaffRap staffRap,int page,int rows){
        return staffRapService.search(staffRap,page,rows);
    }

    @RequestMapping("/findOne")
    public StaffRap findOne(Integer id){
        return staffRapService.findOne(id);
    }

    @RequestMapping("/add")
    public Result add(@RequestBody StaffRap staffRap){
        try {
            staffRapService.add(staffRap);
            return new Result(true,"插入成功！");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"新增失败！");
        }
    }
    @RequestMapping("/update")
    public Result update(@RequestBody StaffRap staffRap){
        try {
            staffRapService.update(staffRap);
            return new Result(true,"修改成功！");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"修改失败！");
        }
    }

    @RequestMapping("/delete")
    public Result delete(Integer[] ids){
        try {
            staffRapService.dele(ids);
            return new Result(true,"删除成功！");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"删除失败！");
        }
    }
}

package com.ems.hr.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ems.pojo.Section;
import com.ems.service.SectionService;
import entity.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: SectionController
 * @Description: TODO
 * @Autor:13528
 * @Date: 2020/3/15 16:42
 * @Version 1.0
 **/
@RestController
@RequestMapping("/section")
public class SectionController {

   @Reference
   SectionService sectionService;

   @RequestMapping("/findAll")
   public List<Section> finaAll(){
      return sectionService.findAll();
   }
   @RequestMapping("/findOne")
   public Section findOne(Integer id){
      return  sectionService.findOne(id);
   }

   @RequestMapping("/updateSection")
   public Result updateSection(@RequestBody Section section){
      try {
         sectionService.updateSection(section);
         return new Result(true,"修改成功！");
      }catch (Exception e){
         e.printStackTrace();
         return new Result(false,"修改失败！");
      }
   }
   @RequestMapping("/addSection")
   public Result addSection(@RequestBody Section section){
      try {
         sectionService.addSection(section);
         return new Result(true,"新建成功！");
      }catch (Exception e){
         return new Result(false,"新建失败！");
      }
   }
   @RequestMapping("/dele")
   public Result dele(Integer[] ids){
      try {
         sectionService.deleteSection(ids);
         return new Result(true,"删除成功！");
      }catch (Exception e){
         return new Result(false,"删除失败！");
      }
   }

   @RequestMapping("/selectSectionList")
   public List<Map> selectSectionList(){
      return sectionService.selectSectionList();
   }

}

package com.ems.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ems.pojo.Section;
import com.ems.service.SectionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}

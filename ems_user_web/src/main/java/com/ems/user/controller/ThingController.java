package com.ems.user.controller;
import java.util.List;

import com.ems.pojo.Thing;
import com.ems.service.ThingService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/thing")
public class ThingController {

	@Reference
	private ThingService thingService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<Thing> findAll(Integer id){
		return thingService.findAll(id);
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return thingService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param thing
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody Thing thing){
		try {
			thingService.add(thing);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param thing
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody Thing thing){
		try {
			thingService.update(thing);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public Thing findOne(Integer id){

		return thingService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Integer [] ids){
		try {
			thingService.delete(ids);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody Thing thing, int page, int rows  ){
		return thingService.findPage(thing, page, rows);		
	}
	
}

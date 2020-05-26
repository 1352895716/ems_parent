package com.ems.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ems.pojo.Sat;
import com.ems.service.SatService;
import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/sat")
public class SatController {

	@Reference
	private SatService satService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<Sat> findAll(){
		return satService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return satService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param sat
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody Sat sat){
		try {
			int flag = satService.add(sat);
			if(flag==0){
				return new Result(false, "不能重复报名");
			}
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param sat
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody Sat sat){
		try {
			satService.update(sat);
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
	public Sat findOne(Integer id){
		return satService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Integer [] ids){
		try {
			satService.delete(ids);
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
	public PageResult search(@RequestBody Sat sat, int page, int rows  ){
		return satService.findPage(sat, page, rows);		
	}
	
}

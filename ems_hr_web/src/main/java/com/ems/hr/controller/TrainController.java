package com.ems.hr.controller;
import java.util.List;

import com.ems.pojo.Train;
import com.ems.service.TrainService;
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
@RequestMapping("/train")
public class TrainController {

	@Reference
	private TrainService trainService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<Train> findAll(){
		return trainService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return trainService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param train
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody Train train){
		try {
			trainService.add(train);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param train
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody Train train){
		try {
			trainService.update(train);
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
	public Train findOne(Integer id){
		return trainService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Integer[] ids){
		try {
			trainService.delete(ids);
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
	public PageResult search(@RequestBody Train train, int page, int rows  ){
		return trainService.findPage(train, page, rows);		
	}
	
}

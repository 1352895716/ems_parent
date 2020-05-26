package com.ems.user.controller;
import java.util.List;

import com.ems.pojo.Conclusion;
import com.ems.service.ConclusionService;
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
@RequestMapping("/conclusion")
public class ConclusionController {

	@Reference
	private ConclusionService conclusionService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<Conclusion> findAll(){
		return conclusionService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return conclusionService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param conclusion
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody Conclusion conclusion){
		try {
			int flag = conclusionService.add(conclusion);
			if(flag==0){
				return new Result(false, "该培训总结已存在");
			}
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param conclusion
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody Conclusion conclusion){
		try {
			conclusionService.update(conclusion);
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
	public Conclusion findOne(Integer id){
		return conclusionService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Integer [] ids){
		try {
			conclusionService.delete(ids);
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
	public PageResult search(@RequestBody Conclusion conclusion, int page, int rows  ){
		return conclusionService.findPage(conclusion, page, rows);		
	}
	
}

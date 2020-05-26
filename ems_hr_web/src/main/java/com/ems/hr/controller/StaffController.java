package com.ems.hr.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ems.pojo.Staff;
import com.ems.service.StaffService;
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
@RequestMapping("/staff")
public class StaffController {

	@Reference
	private StaffService staffService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<Staff> findAll(){
		return staffService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 * 当使用search方法时，该方法就被舍弃了，因为search中的对象没有内容时就等同于该方法
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return staffService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param staff
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody Staff staff){
		try {
			staffService.add(staff);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param staff
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody Staff staff){
		try {
			staffService.update(staff);
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
	public Staff findOne(Integer id){
		return staffService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Integer [] ids){
		try {
			staffService.delete(ids);
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
	public PageResult search(@RequestBody Staff staff, int page, int rows  ){
		return staffService.findPage(staff, page, rows);		
	}
	
}

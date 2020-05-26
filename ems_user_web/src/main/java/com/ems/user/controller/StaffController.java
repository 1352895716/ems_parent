package com.ems.user.controller;
import java.util.List;

import entity.PhoneFormatCheckUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.ems.pojo.Staff;
import com.ems.service.StaffService;

import entity.PageResult;
import entity.Result;
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
			if(!PhoneFormatCheckUtils.isPhoneLegal(staff.getPhone())){
				return new Result(false,"手机号格式不正确！");
			}
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


	//判断手机号和编号是否存在
	@RequestMapping("/checked")
	public Result checked(String phone,String number){
		System.out.println(phone);
		if(!PhoneFormatCheckUtils.isPhoneLegal(phone)){
			return new Result(false,"手机号格式不正确！");
		}
		try {
			int flag = staffService.checked(phone,number);
			if(flag==1){
				return new Result(true,"验证码发送成功");
			}
			return new Result(false,"编号或手机号错误");
		}catch (Exception e){
			e.printStackTrace();
			return new Result(false,"验证码发送失败");
		}
	}
	//校验验证码是否正确
	@RequestMapping("/checkCode")
	public Result checkCode(String phone,String code){
		try {
			int flag = staffService.checkedCode(phone,code);
			if(flag==0){
				return new Result(false,"验证码错误或失效");
			}
			return new Result(true,"验证成功！");
		}catch (Exception e){
			return new Result(false,"服务器错误，请稍后再试");
		}
	}
	//修改密码
	@RequestMapping("/updPwd")
	public Result updPwd(String number,String password){
		try {
			staffService.updPwd(number,password);
			return new Result(true,"修改成功！");
		}catch (Exception e){
			e.printStackTrace();
			return new Result(false,"服务器错误，请稍后再试");
		}
	}
}

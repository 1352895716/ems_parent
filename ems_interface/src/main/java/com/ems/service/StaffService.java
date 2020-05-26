package com.ems.service;
import java.util.List;
import com.ems.pojo.Staff;

import entity.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface StaffService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<Staff> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(Staff staff);
	
	
	/**
	 * 修改
	 */
	public void update(Staff staff);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public Staff findOne(Integer id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(Integer[] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(Staff staff, int pageNum, int pageSize);

    int checked(String phone, String number);

    int checkedCode(String phone,String code);

    void updPwd(String number, String password);
}

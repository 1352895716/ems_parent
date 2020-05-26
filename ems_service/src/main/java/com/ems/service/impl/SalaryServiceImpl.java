package com.ems.service.impl;
import java.util.Date;
import java.util.List;

import com.ems.mapper.SalaryMapper;
import com.ems.pojo.Salary;
import com.ems.pojo.SalaryExample;
import com.ems.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class SalaryServiceImpl implements SalaryService {

	@Autowired
	private SalaryMapper salaryMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Salary> findAll() {
		return salaryMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<Salary> page=   (Page<Salary>) salaryMapper.selectByExample(null);
		return new PageResult((int) page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Salary salary) {
		salary.setCreateTime(new Date());
		Float total = salary.getBasic()+salary.getEat()+salary.getHouse()+salary.getDuty()+salary.getAdditionalBenefits()-salary.getScot();
		salary.setTotal(total);
		salaryMapper.insert(salary);
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(Salary salary){
		Float total = salary.getBasic()+salary.getEat()+salary.getHouse()+salary.getDuty()+salary.getAdditionalBenefits()-salary.getScot();
		salary.setTotal(total);
		salaryMapper.updateByPrimaryKey(salary);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Salary findOne(Integer id){
		return salaryMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			salaryMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
	@Override
	public PageResult findPage(Salary salary, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		SalaryExample example=new SalaryExample();
		SalaryExample.Criteria criteria = example.createCriteria();
		
		if(salary!=null){			
				if(salary.getStaffId()!=null){
					criteria.andStaffIdEqualTo(salary.getStaffId());
				}
		}
		
		Page<Salary> page= (Page<Salary>)salaryMapper.selectByExample(example);
		return new PageResult((int) page.getTotal(), page.getResult());
	}
	
}

package com.ems.service.impl;
import java.util.Date;
import java.util.List;

import com.ems.mapper.RecruitMapper;
import com.ems.pojo.Recruit;
import com.ems.pojo.RecruitExample;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.ems.service.RecruitService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class RecruitServiceImpl implements RecruitService {

	@Autowired
	private RecruitMapper recruitMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Recruit> findAll() {
		return recruitMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<Recruit> page=   (Page<Recruit>) recruitMapper.selectByExample(null);
		return new PageResult((int) page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Recruit recruit) {
		recruit.setCreateTime(new Date());
		recruit.setIsStop(false);
		recruitMapper.insert(recruit);
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(Recruit recruit){
		recruitMapper.updateByPrimaryKey(recruit);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Recruit findOne(Integer id){
		return recruitMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			recruitMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(Recruit recruit, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		RecruitExample example=new RecruitExample();
		RecruitExample.Criteria criteria = example.createCriteria();
		
		if(recruit!=null){			
			if(recruit.getName()!=null && recruit.getName().length()>0){
				criteria.andNameLike("%"+recruit.getName()+"%");
			}
			if(recruit.getJop()!=null && recruit.getJop().length()>0){
				criteria.andJopLike("%"+recruit.getJop()+"%");
			}
			if(recruit.getMajor()!=null && recruit.getMajor().length()>0){
				criteria.andMajorLike("%"+recruit.getMajor()+"%");
			}
			if(recruit.getSchool()!=null && recruit.getSchool().length()>0){
				criteria.andSchoolLike("%"+recruit.getSchool()+"%");
			}
			if(recruit.getPhone()!=null && recruit.getPhone().length()>0){
				criteria.andPhoneLike("%"+recruit.getPhone()+"%");
			}
			if(recruit.getEmail()!=null && recruit.getEmail().length()>0){
				criteria.andEmailLike("%"+recruit.getEmail()+"%");
			}

	
		}
		
		Page<Recruit> page= (Page<Recruit>)recruitMapper.selectByExample(example);
		return new PageResult((int) page.getTotal(), page.getResult());
	}
	
}

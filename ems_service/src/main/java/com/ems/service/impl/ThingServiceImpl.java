package com.ems.service.impl;
import java.util.List;

import com.ems.mapper.ThingMapper;
import com.ems.pojo.Thing;
import com.ems.pojo.ThingExample;
import com.ems.service.ThingService;
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
public class ThingServiceImpl implements ThingService {

	@Autowired
	private ThingMapper thingMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Thing> findAll(Integer staffId) {
		System.out.println("staff: "+staffId);
		ThingExample example = new ThingExample();
		ThingExample.Criteria criteria = example.createCriteria();
		criteria.andStaffIdEqualTo(staffId);
		return thingMapper.selectByExample(example);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<Thing> page=   (Page<Thing>) thingMapper.selectByExample(null);
		return new PageResult((int) page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Thing thing) {
		thingMapper.insert(thing);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(Thing thing){
		thingMapper.updateByPrimaryKey(thing);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Thing findOne(Integer id){
		return thingMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			thingMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(Thing thing, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		ThingExample example=new ThingExample();
		ThingExample.Criteria criteria = example.createCriteria();
		
		if(thing!=null){			
						if(thing.getBody()!=null && thing.getBody().length()>0){
				criteria.andBodyLike("%"+thing.getBody()+"%");
			}
	
		}
		
		Page<Thing> page= (Page<Thing>)thingMapper.selectByExample(example);
		return new PageResult((int) page.getTotal(), page.getResult());
	}
	
}

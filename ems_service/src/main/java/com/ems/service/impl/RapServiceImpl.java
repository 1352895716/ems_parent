package com.ems.service.impl;
import java.util.Date;
import java.util.List;

import com.ems.pojo.RapExample;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ems.mapper.RapMapper;
import com.ems.pojo.Rap;
import com.ems.service.RapService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class RapServiceImpl implements RapService {

	@Autowired
	private RapMapper rapMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Rap> findAll() {
		return rapMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<Rap> page=   (Page<Rap>) rapMapper.selectByExample(null);
		return new PageResult((int) page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Rap rap) {
		rap.setCreateTime(new Date());
		rapMapper.insert(rap);
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(Rap rap){
		rapMapper.updateByPrimaryKey(rap);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Rap findOne(Integer id){
		return rapMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			rapMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
	@Override
	public PageResult findPage(Rap rap, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		RapExample example=new RapExample();
		RapExample.Criteria criteria = example.createCriteria();
		
		if(rap!=null){			
				
		}
		
		Page<Rap> page= (Page<Rap>)rapMapper.selectByExample(example);
		return new PageResult((int) page.getTotal(), page.getResult());
	}
	
}

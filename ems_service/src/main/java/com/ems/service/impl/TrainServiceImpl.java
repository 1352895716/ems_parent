package com.ems.service.impl;
import java.util.List;

import com.ems.mapper.TrainMapper;
import com.ems.pojo.Train;
import com.ems.pojo.TrainExample;
import com.ems.service.TrainService;
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
public class TrainServiceImpl implements TrainService {

	@Autowired
	private TrainMapper trainMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Train> findAll() {
		return trainMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<Train> page=   (Page<Train>) trainMapper.selectByExample(null);
		return new PageResult((int) page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Train train) {
		train.setCurrentCount(0);
		train.setStatus("1");
		trainMapper.insert(train);
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(Train train){
		trainMapper.updateByPrimaryKey(train);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Train findOne(Integer id){
		return trainMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			trainMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(Train train, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TrainExample example=new TrainExample();
		TrainExample.Criteria criteria = example.createCriteria();
		
		if(train!=null){			
			if(train.getName()!=null && train.getName().length()>0){
				criteria.andNameLike("%"+train.getName()+"%");
			}
			if(train.getTime()!=null && train.getTime().length()>0){
				criteria.andTimeLike("%"+train.getTime()+"%");
			}
			if(train.getPurpose()!=null && train.getPurpose().length()>0){
				criteria.andPurposeLike("%"+train.getPurpose()+"%");
			}
			if(train.getAddress()!=null && train.getAddress().length()>0){
				criteria.andAddressLike("%"+train.getAddress()+"%");
			}
			if(train.getStatus()!=null && train.getStatus().length()>0){
				criteria.andStatusLike("%"+train.getStatus()+"%");
			}
		}
		
		Page<Train> page= (Page<Train>)trainMapper.selectByExample(example);
		return new PageResult((int) page.getTotal(), page.getResult());
	}
	
}

package com.ems.service.impl;
import java.util.Date;
import java.util.List;

import com.ems.mapper.SatMapper;
import com.ems.mapper.TrainMapper;
import com.ems.pojo.Sat;
import com.ems.pojo.SatExample;
import com.ems.pojo.Train;
import com.ems.service.SatService;
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
public class SatServiceImpl implements SatService {

	@Autowired
	private SatMapper satMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Sat> findAll() {
		return satMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<Sat> page=   (Page<Sat>) satMapper.selectByExample(null);
		return new PageResult((int) page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public int add(Sat sat) {
		SatExample example = new SatExample();
		SatExample.Criteria criteria = example.createCriteria();
		criteria.andStaffIdEqualTo(sat.getStaffId());
		criteria.andTrainIdEqualTo(sat.getTrainId());
		List<Sat> sats = satMapper.selectByExample(example);
		if(sats.size()>0){//不能重复报名
			return 0;
		}
		sat.setStatus("0");
		sat.setCreateTime(new Date());
		satMapper.insert(sat);
		return 1;//报名成功
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(Sat sat){
		satMapper.updateByPrimaryKey(sat);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Sat findOne(Integer id){
		return satMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			satMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(Sat sat, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		SatExample example=new SatExample();
		SatExample.Criteria criteria = example.createCriteria();
		
		if(sat!=null) {
			if (sat.getStaffId() != null) {
				criteria.andStaffIdEqualTo(sat.getStaffId());
			}
			if (sat.getTrainId() != null) {
				criteria.andTrainIdEqualTo(sat.getTrainId());
			}
			if (sat.getStatus() != null && sat.getStatus().length() > 0) {
				if (sat.getStatus().equals("3")) {
					criteria.andStatusIsNotNull();
				} else {
					criteria.andStatusEqualTo(sat.getStatus());
				}
			}else{
				criteria.andStatusEqualTo("0");
			}

		}
		
		Page<Sat> page= (Page<Sat>)satMapper.selectByExample(example);
		return new PageResult((int) page.getTotal(), page.getResult());
	}

	@Autowired
	TrainMapper trainMapper;
	@Override
	public int updatStatus(Integer[] ids,String status) {
		//从数据库中查询出来再更改
		for (Integer id:ids){
			Sat sat = satMapper.selectByPrimaryKey(id);
			if(status.equals("1")){
				Train train = trainMapper.selectByPrimaryKey(sat.getTrainId());
				if(train.getCurrentCount()==train.getCount()){
					return 0;
				}
			}
			sat.setStatus(status);
			satMapper.updateByPrimaryKey(sat);
		}
		return 1;
	}

}

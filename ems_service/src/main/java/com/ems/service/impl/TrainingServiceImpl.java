package com.ems.service.impl;
import java.util.List;

import com.ems.mapper.TrainingMapper;
import com.ems.pojo.Training;
import com.ems.pojo.TrainingExample;
import com.ems.service.TrainingService;
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
public class TrainingServiceImpl implements TrainingService {

	@Autowired
	private TrainingMapper trainingMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Training> findAll() {
		return trainingMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<Training> page=   (Page<Training>) trainingMapper.selectByExample(null);
		return new PageResult((int) page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Training training) {
		trainingMapper.insert(training);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(Training training){
		trainingMapper.updateByPrimaryKey(training);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Training findOne(Integer id){
		return trainingMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			trainingMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(Training training, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TrainingExample example=new TrainingExample();
		TrainingExample.Criteria criteria = example.createCriteria();
		
		if(training!=null){			
						if(training.getNumber()!=null && training.getNumber().length()>0){
				criteria.andNumberLike("%"+training.getNumber()+"%");
			}
			if(training.getTitle()!=null && training.getTitle().length()>0){
				criteria.andTitleLike("%"+training.getTitle()+"%");
			}
			if(training.getContent()!=null && training.getContent().length()>0){
				criteria.andContentLike("%"+training.getContent()+"%");
			}
			if(training.getPurpose()!=null && training.getPurpose().length()>0){
				criteria.andPurposeLike("%"+training.getPurpose()+"%");
			}
			if(training.getMethod()!=null && training.getMethod().length()>0){
				criteria.andMethodLike("%"+training.getMethod()+"%");
			}
			if(training.getReleasePeople()!=null && training.getReleasePeople().length()>0){
				criteria.andReleasePeopleLike("%"+training.getReleasePeople()+"%");
			}
			if(training.getAppraisal()!=null && training.getAppraisal().length()>0){
				criteria.andAppraisalLike("%"+training.getAppraisal()+"%");
			}
	
		}
		
		Page<Training> page= (Page<Training>)trainingMapper.selectByExample(example);
		return new PageResult((int) page.getTotal(), page.getResult());
	}
	
}

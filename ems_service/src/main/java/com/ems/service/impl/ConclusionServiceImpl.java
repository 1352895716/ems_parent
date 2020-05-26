package com.ems.service.impl;
import java.util.Date;
import java.util.List;

import com.ems.mapper.ConclusionMapper;
import com.ems.pojo.Conclusion;
import com.ems.pojo.ConclusionExample;
import com.ems.service.ConclusionService;
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
public class ConclusionServiceImpl implements ConclusionService {

	@Autowired
	private ConclusionMapper conclusionMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Conclusion> findAll() {
		return conclusionMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<Conclusion> page=   (Page<Conclusion>) conclusionMapper.selectByExample(null);
		return new PageResult((int) page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public int  add(Conclusion conclusion) {
		ConclusionExample example = new ConclusionExample();
		ConclusionExample.Criteria criteria = example.createCriteria();
		criteria.andStaffIdEqualTo(conclusion.getStaffId());
		criteria.andTrainIdEqualTo(conclusion.getTrainId());
		List<Conclusion> list = conclusionMapper.selectByExample(example);
		if(list.size()>0){
			return 0;
		}
		conclusion.setCreateTime(new Date());
		conclusionMapper.insert(conclusion);
		return 1;
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(Conclusion conclusion){
		conclusion.setUpdateTime(new Date());
		conclusionMapper.updateByPrimaryKey(conclusion);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Conclusion findOne(Integer id){
		return conclusionMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			conclusionMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(Conclusion conclusion, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		ConclusionExample example=new ConclusionExample();
		ConclusionExample.Criteria criteria = example.createCriteria();
		
		if(conclusion!=null){			
						if(conclusion.getTitle()!=null && conclusion.getTitle().length()>0){
				criteria.andTitleLike("%"+conclusion.getTitle()+"%");
			}
			if(conclusion.getContent()!=null && conclusion.getContent().length()>0){
				criteria.andContentLike("%"+conclusion.getContent()+"%");
			}
	
		}
		
		Page<Conclusion> page= (Page<Conclusion>)conclusionMapper.selectByExample(example);
		return new PageResult((int) page.getTotal(), page.getResult());
	}
	
}

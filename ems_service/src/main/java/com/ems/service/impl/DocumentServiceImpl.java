package com.ems.service.impl;
import java.util.List;

import com.ems.mapper.DocumentMapper;
import com.ems.pojo.Document;
import com.ems.pojo.DocumentExample;
import com.ems.service.DocumentService;
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
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentMapper documentMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Document> findAll() {
		DocumentExample example = new DocumentExample();
		example.setOrderByClause("time DESC");
		return documentMapper.selectByExample(example);

	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<Document> page=   (Page<Document>) documentMapper.selectByExample(null);
		return new PageResult((int) page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Document document) {
		documentMapper.insert(document);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(Document document){
		documentMapper.updateByPrimaryKey(document);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Document findOne(Integer id){
		return documentMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			documentMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(Document document, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		DocumentExample example=new DocumentExample();
		DocumentExample.Criteria criteria = example.createCriteria();
		
		if(document!=null){			
						if(document.getTitle()!=null && document.getTitle().length()>0){
				criteria.andTitleLike("%"+document.getTitle()+"%");
			}
			if(document.getReceive()!=null && document.getReceive().length()>0){
				criteria.andReceiveLike("%"+document.getReceive()+"%");
			}
			if(document.getBody()!=null && document.getBody().length()>0){
				criteria.andBodyLike("%"+document.getBody()+"%");
			}
			if(document.getUnits()!=null && document.getUnits().length()>0){
				criteria.andUnitsLike("%"+document.getUnits()+"%");
			}
	
		}
		
		Page<Document> page= (Page<Document>)documentMapper.selectByExample(example);
		return new PageResult((int) page.getTotal(), page.getResult());
	}
	
}

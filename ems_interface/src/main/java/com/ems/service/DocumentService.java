package com.ems.service;
import java.util.List;

import com.ems.pojo.Document;

import entity.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface DocumentService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<Document> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(Document document);
	
	
	/**
	 * 修改
	 */
	public void update(Document document);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public Document findOne(Integer id);
	
	
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
	public PageResult findPage(Document document, int pageNum, int pageSize);
	
}

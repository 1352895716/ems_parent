package com.ems.user.controller;
import java.util.List;

import com.ems.pojo.Document;
import com.ems.service.DocumentService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/document")
public class DocumentController {

	@Reference
	private DocumentService documentService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<Document> findAll(){
		List<Document> list = documentService.findAll();
		return list.size()>=6?list.subList(0,6):list.subList(0,list.size());
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return documentService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param document
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody Document document){
		try {
			documentService.add(document);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param document
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody Document document){
		try {
			documentService.update(document);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public Document findOne(Integer id){
		return documentService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Integer [] ids){
		try {
			documentService.delete(ids);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody Document document, int page, int rows  ){
		return documentService.findPage(document, page, rows);		
	}
	
}

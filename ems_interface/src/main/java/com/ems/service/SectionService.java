package com.ems.service;

import com.ems.pojo.Section;

import java.util.List;
import java.util.Map;

/**
 * @InterfaceName: SectionService
 * @Description: TODO
 * @Autor:13528
 * @Date: 2020/3/15 16:43
 * @Version 1.0
 **/
public interface SectionService {
    //查询全部部门信息
    public List<Section> findAll();
    //查询单个部门信息
    public Section findOne(Integer id);
    //更改部门信息
    public void updateSection(Section section);
    //新建部门信息
    public void addSection(Section section);
    //删除部门信息
    public void deleteSection(Integer[] ids);
    //下拉框数据
    List<Map> selectSectionList();
}

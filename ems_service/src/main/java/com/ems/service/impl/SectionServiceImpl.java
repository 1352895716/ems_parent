package com.ems.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ems.mapper.SectionMapper;
import com.ems.pojo.Section;
import com.ems.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: SectionService
 * @Description: TODO
 * @Autor:13528
 * @Date: 2020/3/15 16:42
 * @Version 1.0
 **/
@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    SectionMapper sectionMapper;


    @Override
    public List<Section> findAll() {
        return sectionMapper.selectByExample(null);
    }

    @Override
    public Section findOne(Integer id) {
        return sectionMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateSection(Section section) {
        sectionMapper.updateByPrimaryKey(section);
    }

    @Override
    public void addSection(Section section) {
        sectionMapper.insert(section);
    }

    @Override
    public void deleteSection(Integer[] ids) {
        for (Integer id:ids){
            sectionMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public List<Map> selectSectionList() {
        return sectionMapper.selectSectionList();
    }
}

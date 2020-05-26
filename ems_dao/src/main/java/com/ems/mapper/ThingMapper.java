package com.ems.mapper;

import com.ems.pojo.Thing;
import com.ems.pojo.ThingExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ThingMapper {
    int countByExample(ThingExample example);

    int deleteByExample(ThingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Thing record);

    int insertSelective(Thing record);

    List<Thing> selectByExample(ThingExample example);

    Thing selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Thing record, @Param("example") ThingExample example);

    int updateByExample(@Param("record") Thing record, @Param("example") ThingExample example);

    int updateByPrimaryKeySelective(Thing record);

    int updateByPrimaryKey(Thing record);
}
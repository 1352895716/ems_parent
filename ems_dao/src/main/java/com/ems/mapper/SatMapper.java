package com.ems.mapper;

import com.ems.pojo.Sat;
import com.ems.pojo.SatExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SatMapper {
    int countByExample(SatExample example);

    int deleteByExample(SatExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Sat record);

    int insertSelective(Sat record);

    List<Sat> selectByExample(SatExample example);

    Sat selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Sat record, @Param("example") SatExample example);

    int updateByExample(@Param("record") Sat record, @Param("example") SatExample example);

    int updateByPrimaryKeySelective(Sat record);

    int updateByPrimaryKey(Sat record);
}
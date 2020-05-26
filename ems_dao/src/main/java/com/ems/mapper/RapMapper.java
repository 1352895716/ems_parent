package com.ems.mapper;

import com.ems.pojo.Rap;
import com.ems.pojo.RapExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RapMapper {
    int countByExample(RapExample example);

    int deleteByExample(RapExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Rap record);

    int insertSelective(Rap record);

    List<Rap> selectByExample(RapExample example);

    Rap selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Rap record, @Param("example") RapExample example);

    int updateByExample(@Param("record") Rap record, @Param("example") RapExample example);

    int updateByPrimaryKeySelective(Rap record);

    int updateByPrimaryKey(Rap record);
}
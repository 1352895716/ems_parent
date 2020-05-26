package com.ems.mapper;

import com.ems.pojo.StaffRap;
import com.ems.pojo.StaffRapExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StaffRapMapper {
    int countByExample(StaffRapExample example);

    int deleteByExample(StaffRapExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StaffRap record);

    int insertSelective(StaffRap record);

    List<StaffRap> selectByExample(StaffRapExample example);

    StaffRap selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StaffRap record, @Param("example") StaffRapExample example);

    int updateByExample(@Param("record") StaffRap record, @Param("example") StaffRapExample example);

    int updateByPrimaryKeySelective(StaffRap record);

    int updateByPrimaryKey(StaffRap record);
}
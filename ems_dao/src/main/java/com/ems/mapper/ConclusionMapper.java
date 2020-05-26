package com.ems.mapper;

import com.ems.pojo.Conclusion;
import com.ems.pojo.ConclusionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ConclusionMapper {
    int countByExample(ConclusionExample example);

    int deleteByExample(ConclusionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Conclusion record);

    int insertSelective(Conclusion record);

    List<Conclusion> selectByExample(ConclusionExample example);

    Conclusion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Conclusion record, @Param("example") ConclusionExample example);

    int updateByExample(@Param("record") Conclusion record, @Param("example") ConclusionExample example);

    int updateByPrimaryKeySelective(Conclusion record);

    int updateByPrimaryKey(Conclusion record);
}
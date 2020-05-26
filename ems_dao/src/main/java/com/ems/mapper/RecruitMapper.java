package com.ems.mapper;

import com.ems.pojo.Recruit;
import com.ems.pojo.RecruitExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecruitMapper {
    int countByExample(RecruitExample example);

    int deleteByExample(RecruitExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Recruit record);

    int insertSelective(Recruit record);

    List<Recruit> selectByExampleWithBLOBs(RecruitExample example);

    List<Recruit> selectByExample(RecruitExample example);

    Recruit selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Recruit record, @Param("example") RecruitExample example);

    int updateByExampleWithBLOBs(@Param("record") Recruit record, @Param("example") RecruitExample example);

    int updateByExample(@Param("record") Recruit record, @Param("example") RecruitExample example);

    int updateByPrimaryKeySelective(Recruit record);

    int updateByPrimaryKeyWithBLOBs(Recruit record);

    int updateByPrimaryKey(Recruit record);
}
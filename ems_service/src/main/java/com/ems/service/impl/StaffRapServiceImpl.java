package com.ems.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ems.mapper.StaffRapMapper;
import com.ems.pojo.StaffRap;
import com.ems.pojo.StaffRapExample;
import com.ems.service.StaffRapService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: StaffRapServiceImpl
 * @Description: TODO
 * @Autor:13528
 * @Date: 2020/3/25 10:58
 * @Version 1.0
 **/
@Service
public class StaffRapServiceImpl implements StaffRapService {

    @Autowired
    StaffRapMapper staffRapMapper;
    @Override
    public PageResult search(StaffRap staffRap, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        StaffRapExample example = new StaffRapExample();
        StaffRapExample.Criteria criteria = example.createCriteria();

        if(staffRap!=null){
            if(staffRap.getStaffId()!=null){
                criteria.andStaffIdEqualTo(staffRap.getStaffId());
            }
            if(staffRap.getRapId()!=null){
                criteria.andRapIdEqualTo(staffRap.getRapId());
            }
        }
        Page<StaffRap> page = (Page<StaffRap>) staffRapMapper.selectByExample(example);
        return new PageResult((int) page.getTotal(),page.getResult());
    }

    @Override
    public StaffRap findOne(Integer id) {
        return staffRapMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(StaffRap staffRap) {
        staffRap.setCareateTime(new Date());
        staffRapMapper.insert(staffRap);
    }

    @Override
    public void update(StaffRap staffRap) {
        staffRapMapper.updateByPrimaryKey(staffRap);
    }

    @Override
    public void dele(Integer[] ids) {
        for (Integer id:ids){
            staffRapMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public List<StaffRap> findById(Integer id) {
        StaffRapExample example = new StaffRapExample();
        StaffRapExample.Criteria criteria = example.createCriteria();
        criteria.andStaffIdEqualTo(id);
        return staffRapMapper.selectByExample(example);
    }
}

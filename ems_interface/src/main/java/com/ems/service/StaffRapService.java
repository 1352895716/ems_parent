package com.ems.service;

import com.ems.pojo.StaffRap;
import entity.PageResult;

import java.util.List;

/**
 * @InterfaceName: StaffRapService
 * @Description: TODO
 * @Autor:13528
 * @Date: 2020/3/25 10:57
 * @Version 1.0
 **/
public interface StaffRapService {

    public PageResult search(StaffRap staffRap, int page, int rows);

    public StaffRap findOne(Integer id);

    public void add(StaffRap staffRap);

    public void update(StaffRap staffRap);

    public void dele(Integer[] ids);

    public List<StaffRap> findById(Integer id);
}

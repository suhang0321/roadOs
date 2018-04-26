package com.suhang.road.service;

import com.suhang.road.po.YongDao;

import java.util.List;

public interface YongDaoService {

    public List<YongDao> findYongDaosByBlock(String block ,int pc,int ps)throws Exception;

    public void updateYongDaoList(List<YongDao> yongDaoList)throws Exception;

    public List<YongDao> getYongDaosAll()throws Exception;

    public List<YongDao> getYongDaosByBlock(String block)throws Exception;

    public YongDao findYongDaoById(int yd_id)throws Exception;

    public Integer findCountAll()throws Exception;

    public  Integer findCountByBlock(String block)throws Exception;

    public void deleteYongDaosByIds(String[] yd_ids)throws Exception;

    public void insertYongDao(YongDao yongDao)throws Exception;
}

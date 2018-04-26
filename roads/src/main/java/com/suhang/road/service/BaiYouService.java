package com.suhang.road.service;

import com.suhang.road.po.BaiYou;

import java.util.List;

public interface BaiYouService {
    public List<BaiYou> findBaiYousByBlock(String block ,int pc,int ps)throws Exception;

    public void updateBaiYouList(List<BaiYou> baiYouList)throws Exception;

    public List<BaiYou> findBaiYousAll1()throws Exception;

    public BaiYou findBaiYouById(int by_id)throws Exception;

    public List<BaiYou> findBaiYousByBlock1(String block)throws Exception;

    public Integer findCountAll()throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void deleteBaiYouByIds(String[] by_ids)throws Exception;

    public void insertBaiYou(BaiYou baiYou)throws Exception;
}

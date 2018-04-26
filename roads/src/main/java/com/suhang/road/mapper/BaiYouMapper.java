package com.suhang.road.mapper;

import com.suhang.road.po.BaiYou;
import com.suhang.road.povo.BaiYouVo;

import java.util.List;

public interface BaiYouMapper {
    public List<BaiYou> findBaiYousByBlock(BaiYouVo baiYouVo)throws Exception;

    public List<BaiYou> findBaiYousAll(BaiYouVo baiYouVo)throws Exception;

    public BaiYou findBaiYouById(int id)throws Exception;

    public List<BaiYou> findBaiYousAll1()throws Exception;

    public List<BaiYou> findBaiYousByBlock1(String block)throws Exception;

    public Integer findCountAll()throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void updateBaiYouList(List<BaiYou> baiYouList)throws Exception;

    public void deleteBaiYousByIds(String[] by_ids)throws Exception;

    public void insertBaiYou(BaiYou baiYou)throws Exception;
}

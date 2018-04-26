package com.suhang.road.mapper;

import com.suhang.road.po.YongDao;
import com.suhang.road.povo.YongDaoVo;

import java.util.List;

public interface YongDaoMapper {
    public List<YongDao> findYongDaosByBlock(YongDaoVo yongDaoVo)throws Exception;

    public List<YongDao> findYongDaosAll(YongDaoVo yongDaoVo)throws Exception;

    public List<YongDao> getYongDaosAll()throws Exception;

    public YongDao findYongDaoById(int id)throws Exception;

    public List<YongDao> getYongDaosByBlock(String block)throws Exception;

    public Integer findCountAll()throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void updateYongDaoList(List<YongDao> yongDaoList)throws Exception;

    public void deleteYongDaosByIds(String[] yd_ids)throws Exception;

    public void insertYongDao(YongDao yongDao)throws Exception;
}

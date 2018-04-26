package com.suhang.road.mapper;

import com.suhang.road.po.ShuiXi;
import com.suhang.road.povo.ShuiXiVo;

import java.util.List;

public interface ShuiXiMapper {
    public List<ShuiXi> findShuiXisByBlock(ShuiXiVo shuiXiVo)throws Exception;

    public List<ShuiXi> findShuiXisAll(ShuiXiVo shuiXiVo)throws Exception;

    public Integer findCountAll()throws Exception;

    public ShuiXi findShuiXiById(int id)throws Exception;

    public List<ShuiXi> getShuiXisAll()throws Exception;

    public List<ShuiXi> getShuiXisByBlock(String block)throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void updateShuiXiList(List<ShuiXi> shuiXis)throws Exception;

    public void deleteShuiXisByIds(String[] sx_ids)throws Exception;

    public void insertShuiXi(ShuiXi shuiXi)throws Exception;
}

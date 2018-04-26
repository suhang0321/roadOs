package com.suhang.road.service;

import com.suhang.road.po.ShuiXi;

import java.util.List;

public interface ShuiXiService {
    public List<ShuiXi> findShuiXisByBlock(String block, int pc, int ps)throws Exception;

    public void updateShuiXiList(List<ShuiXi> shuiXis)throws Exception;

    public Integer findCountAll()throws Exception;

    public ShuiXi findShuiXiById(int sx_id)throws Exception;

    public List<ShuiXi> getShuiXisAll()throws Exception;

    public List<ShuiXi> getShuiXisByBlock(String block)throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void deleteShuiXisByIds(String[] sx_ids)throws Exception;

    public void insertShuiXi(ShuiXi shuiXi)throws Exception;
}

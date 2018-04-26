package com.suhang.road.service;

import com.suhang.road.po.LvDi;

import java.util.List;

public interface LvDiService {
    public List<LvDi> findLvDisByBlock(String block ,int pc,int ps)throws Exception;

    public void updateLvDiList(List<LvDi> lvDiList)throws Exception;

    public Integer findCountAll()throws Exception;

    public List<LvDi> getLvDisAll()throws Exception;

    public LvDi findLvDiById(int ld_id)throws Exception;

    public List<LvDi> getLvDisByBlock(String block)throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void deleteLvDisByIds(String[] ld_ids)throws Exception;

    public void insertLvDi(LvDi lvDi)throws Exception;
}

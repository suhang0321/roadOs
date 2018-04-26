package com.suhang.road.service;

import com.suhang.road.po.LvLi;

import java.util.List;

public interface LvLiService {

    public List<LvLi> findLvLisByBlock(String block, int pc, int ps)throws Exception;

    public void updateLvLiList(List<LvLi> lvLis)throws Exception;

    public Integer findCountAll()throws Exception;

    public List<LvLi> getLvLisAll()throws Exception;

    public LvLi findLvLiById(int ll_id)throws Exception;

    public List<LvLi> getLvLisByBlock(String block)throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void deleteLvLisByIds(String[] ll_ids)throws Exception;

    public void insertLvLi(LvLi lvLi)throws Exception;

}

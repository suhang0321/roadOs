package com.suhang.road.mapper;

import com.suhang.road.po.LvDi;
import com.suhang.road.povo.LvDiVo;

import java.util.List;

public interface LvDiMapper {
    public List<LvDi> findLvDisByBlock(LvDiVo lvDiVo)throws Exception;

    public List<LvDi> findLvDisAll(LvDiVo lvDiVo)throws Exception;

    public Integer findCountAll()throws Exception;

    public LvDi findLvDiById(int id)throws Exception;

    public List<LvDi> getLvDisAll()throws Exception;

    public List<LvDi> getLvDisByBlock(String block)throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void updateLvDiList(List<LvDi> lvDiList)throws Exception;

    public void deleteLvDisByIds(String[] ld_ids)throws Exception;

    public void insertLvDi(LvDi lvDi)throws Exception;
}

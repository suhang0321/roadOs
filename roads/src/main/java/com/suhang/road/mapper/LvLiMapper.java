package com.suhang.road.mapper;

import com.suhang.road.po.LvLi;
import com.suhang.road.povo.LvLiVo;

import java.util.List;

public interface LvLiMapper {
    public List<LvLi> findLvLisByBlock(LvLiVo lvLiVo)throws Exception;

    public List<LvLi> findLvLisAll( LvLiVo lvLiVo)throws Exception;

    public Integer findCountAll ()throws Exception;

    public List<LvLi> getLvLisAll()throws Exception;

    public LvLi findLvLiById(int id)throws Exception;

    public List<LvLi> getLvLisByBlock(String block)throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void updateLvLiList(List<LvLi> lvLis)throws Exception;

    public void deleteLvLisByIds(String[] ll_ids)throws Exception;

    public void insertLvLi(LvLi lvLi)throws Exception;
}

package com.suhang.road.mapper;

import com.suhang.road.po.GuoPiXiang;
import com.suhang.road.po.LaJi;
import com.suhang.road.povo.LaJiVo;

import java.util.List;

public interface LaJiMapper {
    public List<LaJi> findLaJisByBlock(LaJiVo laJiVo)throws Exception;

    public List<LaJi> findLaJisAll(LaJiVo laJiVo)throws Exception;

    public Integer findCountAll()throws Exception;

    public List<LaJi> getLaJisAll()throws Exception;

    public LaJi findLaJiById(int id)throws Exception;

    public List<LaJi>  getLaJisByBlock(String block)throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void updateLaJiList(List<LaJi> laJis)throws Exception;

    public void deleteLaJisByIds(String[] lj_ids)throws Exception;

    public void insertLaJi(LaJi laJi)throws Exception;
}

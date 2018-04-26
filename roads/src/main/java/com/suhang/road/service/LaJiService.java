package com.suhang.road.service;

import com.suhang.road.po.LaJi;

import java.util.List;

public interface LaJiService {
    public List<LaJi>findLaJisByBlock(String block,int pc,int ps)throws Exception;

    public void updateLaJiList(List<LaJi> laJis)throws Exception;

    public Integer findCountAll()throws Exception;

    public LaJi findLaJiById(int lj_id)throws Exception;

    public List<LaJi> getLaJisAll()throws Exception;

    public List<LaJi> getLaJisByBlock(String block)throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void deleteLaJisByIds(String[] lj_ids)throws Exception;

    public void insertLaJi(LaJi laJi)throws Exception;
}

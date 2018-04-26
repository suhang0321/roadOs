package com.suhang.road.service;

import com.suhang.road.po.ZiXingJia;

import java.util.List;

public interface ZiXingJiaService {
    public List<ZiXingJia>findZiXingJiasByBlock(String block,int pc,int ps)throws Exception;

    public void updateZiXingJiaList(List<ZiXingJia> ziXingJias)throws Exception;

    public Integer findCountAll()throws Exception;

    public ZiXingJia findZiXingById(int cj_id) throws Exception;

    public List<ZiXingJia> getZiXingJiasAll()throws Exception;

    public List<ZiXingJia> getZiXingJiasByBlock(String block)throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void deleteZiXingJiasByIds(String[] cj_ids)throws Exception;

    public void insertZiXingJia(ZiXingJia ziXingJia)throws Exception;
}

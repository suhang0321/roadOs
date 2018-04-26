package com.suhang.road.service;

import com.suhang.road.po.TingChe;
import com.suhang.road.po.TingLang;

import java.util.List;

public interface TingCheService {
    public List<TingChe> findTingChesByBlock(String block, int pc, int ps)throws Exception;

    public void updateTingCheList(List<TingChe> tingChes)throws Exception;

    public Integer findCountAll()throws Exception;


    public TingChe findTingCheById(int tc_id)throws Exception;

    public List<TingChe> getTingChesAll()throws Exception;

    public List<TingChe> getTingChesByBlock(String block)throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void deleteTingChesByIds(String[] tc_ids)throws Exception;

    public void insertTingChe( TingChe tingChe)throws Exception;
}

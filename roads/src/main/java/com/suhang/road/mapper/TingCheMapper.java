package com.suhang.road.mapper;

import com.suhang.road.po.TingChe;
import com.suhang.road.povo.TingCheVo;

import java.util.List;

public interface TingCheMapper {
    public List<TingChe>findTingChesByBlock(TingCheVo tingCheVo)throws Exception;

    public List<TingChe> findTingChesAll( TingCheVo tingCheVo)throws Exception;

    public Integer findCountAll ()throws Exception;

    public TingChe findTingCheById(int id)throws Exception;

    public List<TingChe> getTingChesAll()throws Exception;

    public List<TingChe> getTingChesByBlock(String block)throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void updateTingCheList(List<TingChe> tingChes)throws Exception;

    public void deleteTingChesByIds(String[] tc_ids)throws Exception;

    public void insertTingChe( TingChe tingChe)throws Exception;

}

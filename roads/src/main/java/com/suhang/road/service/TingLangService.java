package com.suhang.road.service;

import com.suhang.road.po.TingLang;

import java.util.List;

public interface TingLangService {
    public List<TingLang> findTingLangsByBlock(String block, int pc, int ps)throws Exception;

    public void updateTingLangList(List<TingLang> tingLangs)throws Exception;

    public Integer findCountAll()throws Exception;

    public TingLang findTingLangById(int lt_id)throws Exception;

    public List<TingLang> getTingLangsAll()throws Exception;

    public List<TingLang> getTingLangsByBlock(String block)throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void deleteTingLangsByIds(String[] lt_ids)throws Exception;

    public void insertTingLang(TingLang tingLang)throws Exception;
}

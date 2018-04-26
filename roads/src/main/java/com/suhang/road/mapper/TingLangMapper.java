package com.suhang.road.mapper;

import com.suhang.road.po.TingLang;
import com.suhang.road.povo.TingLangVo;

import java.util.List;

public interface TingLangMapper {
    public List<TingLang>findTingLangsByBlock(TingLangVo tingLangVo)throws Exception;

    public List<TingLang> findTingLangsAll(TingLangVo tingLangVo)throws Exception;

    public Integer findCountAll()throws Exception;

    public TingLang findTingLangById(int id)throws Exception;

    public List<TingLang> getTingLangsAll()throws Exception;

    public List<TingLang> getTingLangsByBlock(String block)throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void updateTingLangList(List<TingLang> tingLangs)throws Exception;

    public void deleteTingLangsByIds(String[] lt_ids)throws Exception;

    public void insertTingLang(TingLang tingLang)throws Exception;
}

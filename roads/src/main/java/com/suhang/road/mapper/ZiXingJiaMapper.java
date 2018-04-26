package com.suhang.road.mapper;

import com.suhang.road.po.ZiXingJia;
import com.suhang.road.povo.ZiXingJiaVo;

import java.util.List;

public interface ZiXingJiaMapper {
    public List<ZiXingJia> findZiXingJiasByBlock(ZiXingJiaVo ziXingJiaVo)throws Exception;

    public List<ZiXingJia> findZiXingJiasAll(ZiXingJiaVo ziXingJiaVo)throws Exception;

    public Integer findCountAll ()throws Exception;

    public ZiXingJia findZiXingById(int id)throws Exception;

    public List<ZiXingJia> getZiXingJiasAll()throws Exception;

    public List<ZiXingJia> getZiXingJiasByBlock(String block)throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void updateZiXingJiaList(List<ZiXingJia> ziXingJias)throws Exception;

    public void deleteZiXingJiasByIds(String[] cj_ids)throws Exception;

    public void insertZiXingJia(ZiXingJia ziXingJia)throws Exception;
}

package com.suhang.road.mapper;

import com.suhang.road.po.QiTa;
import com.suhang.road.povo.QiTaVo;

import java.util.List;

public interface QiTaMapper {
    public List<QiTa> findQiTasByBlock(QiTaVo qiTaVo)throws Exception;

    public List<QiTa> findQiTasAll(QiTaVo qiTaVo)throws Exception;

    public Integer findCountAll ()throws Exception;

    public QiTa findQiTaById(int id)throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void updateQiTaList(List<QiTa> qiTas)throws Exception;

    public void deleteQiTasByIds(String[] qt_ids)throws Exception;

    public void insertQiTa(QiTa qiTa)throws Exception;
}

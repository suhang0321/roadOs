package com.suhang.road.service;

import com.suhang.road.po.QiTa;

import java.util.List;

public interface QiTaService {
    public List<QiTa> findQiTasByBlock(String block, int pc, int ps)throws Exception;

    public void updateQiTaList(List<QiTa> qiTas)throws Exception;

    public Integer findCountAll()throws Exception;

    public QiTa findQiTaById(int qt_id)throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void deleteQiTasByIds(String[] qt_ids)throws Exception;

    public void insertQiTa(QiTa qiTa)throws Exception;
}

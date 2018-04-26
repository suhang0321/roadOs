package com.suhang.road.mapper;

import com.suhang.road.po.QiaoMu;
import com.suhang.road.povo.QiaoMuVo;

import java.util.List;

public interface QiaoMuMapper {
    public List<QiaoMu> findQiaoMusByBlock(QiaoMuVo qiaoMuVo)throws Exception;

    public List<QiaoMu> findQiaoMusAll(QiaoMuVo qiaoMuVo)throws Exception;

    public Integer findCountAll()throws Exception;

    public QiaoMu findQiaoMuById(int id)throws Exception;

    public List<QiaoMu> getQiaoMusAll()throws Exception;

    public List<QiaoMu> getQiaoMusByBlock(String block)throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void updateQiaoMuList(List<QiaoMu> qiaoMus)throws Exception;

    public void deleteQiaoMusByIds(String[] ls_ids)throws Exception;

    public void insertQiaoMu(QiaoMu qiaoMu)throws Exception;
}

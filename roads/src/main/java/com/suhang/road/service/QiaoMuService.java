package com.suhang.road.service;

import com.suhang.road.po.QiaoMu;

import java.util.List;

public interface QiaoMuService {
    public List<QiaoMu> findQiaoMusByBlock(String block,int pc,int ps)throws Exception;

    public void updateQiaoMuList(List<QiaoMu> qiaoMus)throws Exception;

    public Integer findCountAll()throws Exception;

    public QiaoMu findQiaoMuById(int ls_id)throws Exception;

    public List<QiaoMu> getQiaoMusAll()throws Exception;

    public List<QiaoMu> getQiaoMuByBlock(String bloock)throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void deleteQiaoMusByIds(String[] ls_ids)throws Exception;

    public void insertQiaoMu(QiaoMu qiaoMu)throws Exception;
}

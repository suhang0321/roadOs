package com.suhang.road.service;

import com.suhang.road.po.YunDong;

import java.util.List;

public interface YunDongService {
    public List<YunDong> findYunDongsByBlock(String block, int pc, int ps)throws Exception;

    public void updateYunDongList(List<YunDong> yunDongs)throws Exception;

    public Integer findCountAll()throws Exception;

    public List<YunDong> getYunDongsAll()throws Exception;

    public YunDong findYunDongById(int yd_id)throws Exception;

    public List<YunDong> getYunDongsByBlock(String block)throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void deleteYunDongsByIds(String[] yd_ids)throws Exception;

    public void insertYunDong(YunDong yunDong)throws Exception;
}

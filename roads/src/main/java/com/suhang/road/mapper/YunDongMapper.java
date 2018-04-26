package com.suhang.road.mapper;

import com.suhang.road.po.YunDong;
import com.suhang.road.povo.YunDongVo;

import java.util.List;

public interface YunDongMapper {
    public List<YunDong> findYunDongsByBlock(YunDongVo yunDongVo)throws Exception;

    public List<YunDong> findYunDongsAll(YunDongVo yunDongVo)throws Exception;

    public Integer findCountAll ()throws Exception;

    public List<YunDong> getYunDongsAll()throws Exception;

    public YunDong findYunDongById(int id)throws Exception;

    public List<YunDong> getYunDongsByBlock(String block)throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void updateYunDongList(List<YunDong> yunDongs)throws Exception;

    public void deleteYunDongsByIds(String[] yd_ids)throws Exception;

    public void insertYunDong(YunDong yunDong)throws Exception;
}

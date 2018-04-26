package com.suhang.road.service;

import com.suhang.road.po.ZhenGui;

import java.util.List;

public interface ZhenGuiService {
    public List<ZhenGui> findZhenGuisByBlock(String block, int pc, int ps)throws Exception;

    public void updateZhenGuiList(List<ZhenGui> zhenGuis)throws Exception;

    public Integer findCountAll()throws Exception;

    public List<ZhenGui> getZhenGuisAll()throws Exception;

    public ZhenGui findZhenGuiById(int zg_id)throws Exception;

    public List<ZhenGui> getZhenGuisByBlock(String block)throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void deleteZhenGuisByIds(String[] zg_ids)throws Exception;

    public void insertZhenGui(ZhenGui zhenGui)throws Exception;
}

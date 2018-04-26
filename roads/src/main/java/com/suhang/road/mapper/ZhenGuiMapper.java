package com.suhang.road.mapper;

import com.suhang.road.po.ZhenGui;
import com.suhang.road.povo.ZhenGuiVo;

import java.util.List;

public interface ZhenGuiMapper {
    public List<ZhenGui> findZhenGuisByBlock(ZhenGuiVo zhenGuiVo)throws Exception;

    public List<ZhenGui> findZhenGuisAll(ZhenGuiVo zhenGuiVo)throws Exception;

    public Integer findCountAll()throws Exception;

    public ZhenGui findZhenGuiById(int id)throws Exception;

    public List<ZhenGui> getZhenGuisAll()throws Exception;

    public List<ZhenGui> getZhenGuisByBlock(String block)throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void updateZhenGuiList(List<ZhenGui> zhenGuis)throws Exception;

    public void deleteZhenGuisByIds(String[] zg_ids)throws Exception;

    public void insertZhenGui(ZhenGui zhenGui)throws Exception;
}

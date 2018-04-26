package com.suhang.road.serviceImp;

import com.suhang.road.mapper.ZhenGuiMapper;
import com.suhang.road.po.ZhenGui;
import com.suhang.road.povo.ZhenGuiVo;
import com.suhang.road.service.ZhenGuiService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ZhenGuiServiceImp implements ZhenGuiService {
    @Autowired
    private ZhenGuiMapper zhenGuiMapper;
    @Override
    public List<ZhenGui> findZhenGuisByBlock(String block, int pc, int ps) throws Exception {
        int snep = (pc - 1) * ps;
        ZhenGuiVo zhenGuiVoall = new ZhenGuiVo();
        zhenGuiVoall.setSnep(snep);
        zhenGuiVoall.setPs(ps);
        ZhenGuiVo zhenGuiVo = new ZhenGuiVo();
        zhenGuiVo.setSnep(snep);
        zhenGuiVo.setPs(ps);
        zhenGuiVo.setBlock(block);
        if (block.equals("admin")||block.equals("admin2")) {
            return zhenGuiMapper.findZhenGuisAll(zhenGuiVoall);
        } else {
            return zhenGuiMapper.findZhenGuisByBlock(zhenGuiVo);
        }
    }

    @Override
    public void updateZhenGuiList(List<ZhenGui> zhenGuis) throws Exception {
        zhenGuiMapper.updateZhenGuiList(zhenGuis);
    }

    @Override
    public Integer findCountAll() throws Exception {
        return zhenGuiMapper.findCountAll();
    }

    @Override
    public List<ZhenGui> getZhenGuisAll() throws Exception {
        return zhenGuiMapper.getZhenGuisAll();
    }

    @Override
    public ZhenGui findZhenGuiById(int zg_id) throws Exception {
        return zhenGuiMapper.findZhenGuiById(zg_id);
    }

    @Override
    public List<ZhenGui> getZhenGuisByBlock(String block) throws Exception {
        return zhenGuiMapper.getZhenGuisByBlock(block);
    }

    @Override
    public Integer findCountByBlock(String block) throws Exception {
        return zhenGuiMapper.findCountByBlock(block);
    }

    @Override
    public void deleteZhenGuisByIds(String[] zg_ids) throws Exception {
        zhenGuiMapper.deleteZhenGuisByIds(zg_ids);
    }

    @Override
    public void insertZhenGui(ZhenGui zhenGui) throws Exception {
        zhenGuiMapper.insertZhenGui(zhenGui);
    }
}

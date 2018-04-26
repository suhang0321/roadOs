package com.suhang.road.serviceImp;

import com.suhang.road.mapper.HuaHuiMapper;
import com.suhang.road.po.HuaHui;
import com.suhang.road.povo.HuaHuiVo;
import com.suhang.road.service.HuaHuiService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HuaHuiServiceImp implements HuaHuiService {
    @Autowired
    private HuaHuiMapper huaHuiMapper;


    @Override
    public List<HuaHui> findHuaHuisByBlock(String block, int pc, int ps) throws Exception {
        int snep = (pc-1) *ps;
        HuaHuiVo huaHuiVoall = new HuaHuiVo();
        huaHuiVoall.setSnep(snep);
        huaHuiVoall.setPs(ps);
        HuaHuiVo huaHuiVo =new HuaHuiVo();
        huaHuiVo.setSnep(snep);
        huaHuiVo.setPs(ps);
        huaHuiVo.setBlock(block);
        if (block.equals("admin")||block.equals("admin2")){
            return huaHuiMapper.findHuaHuisAll(huaHuiVoall);
        }else {
            return huaHuiMapper.findHuaHuisByBlock(huaHuiVo);
        }
    }

    @Override
    public void updateHuaHuiList(List<HuaHui> huaHuis) throws Exception {
        huaHuiMapper.updateHuaHuiList(huaHuis);
    }

    @Override
    public Integer findCountAll() throws Exception {
        return huaHuiMapper.findCountAll();
    }

    @Override
    public HuaHui findHuaHuiById(int hh_id) throws Exception {
        return huaHuiMapper.findHuaHuiById(hh_id);
    }

    @Override
    public List<HuaHui> getHuaHuisAll() throws Exception {
        return huaHuiMapper.getHuaHuisAll();
    }

    @Override
    public List<HuaHui> getHuaHuisByBlock(String block) throws Exception {
        return huaHuiMapper.getHuaHuisByBlock(block);
    }

    @Override
    public Integer findCountByBlock(String block) throws Exception {
        return huaHuiMapper.findCountByBlock(block);
    }

    @Override
    public void deleteHuaHuisByIds(String[] hh_ids) throws Exception {
        huaHuiMapper.deleteHuaHuisByIds(hh_ids);
    }

    @Override
    public void insertHuaHui(HuaHui huaHui) throws Exception {
        huaHuiMapper.insertHuaHui(huaHui);
    }
}

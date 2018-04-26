package com.suhang.road.serviceImp;

import com.suhang.road.mapper.GuanMuMapper;
import com.suhang.road.po.GuanMu;
import com.suhang.road.povo.GuanMuVo;
import com.suhang.road.service.GuanMuService;
import net.sf.ehcache.transaction.xa.EhcacheXAException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GuanMuServiceImp implements GuanMuService {
    @Autowired
    private GuanMuMapper guanMuMapper;


    @Override
    public List<GuanMu> findGuanMusByBlock(String block, int pc, int ps) throws Exception {
        int snep = (pc-1) *ps;
        GuanMuVo guanMuVoall = new GuanMuVo();
        guanMuVoall.setSnep(snep);
        guanMuVoall.setPs(ps);
        GuanMuVo guanMuVo = new GuanMuVo();
        guanMuVo.setSnep(snep);
        guanMuVo.setPs(ps);
        guanMuVo.setBlock(block);
        if (block.equals("admin")||block.equals("admin2")){
            return guanMuMapper.findGuanMusAll(guanMuVoall);
        }else {
            return guanMuMapper.findGuanMusByBlock(guanMuVo);
        }
    }

    @Override
    public void updateGuanMuList(List<GuanMu> guanMus) throws Exception {
        guanMuMapper.updateGuanMuList(guanMus);
    }

    @Override
    public Integer findCountAll() throws Exception {
        return guanMuMapper.findCountAll();
    }

    @Override
    public GuanMu findGuanMuById(int gm_id) throws Exception {
        return guanMuMapper.findGuanMuById(gm_id);
    }

    @Override
    public List<GuanMu> getGuanMusALL() throws Exception {
        return guanMuMapper.getGuanMusAll();
    }

    @Override
    public List<GuanMu> getGuanMusByBlock(String block) throws Exception {
        return guanMuMapper.getGuanMusByBlock(block);
    }

    @Override
    public Integer findCountByBlock(String block) throws Exception {
        return guanMuMapper.findCountByBlock(block);
    }

    @Override
    public void deleteGuanMusByIds(String[] gm_ids) throws Exception {
        guanMuMapper.deleteGuanMusByIds(gm_ids);
    }

    @Override
    public void insertGuanMu(GuanMu guanMu) throws Exception {
        guanMuMapper.insertGuanMu(guanMu);
    }
}

package com.suhang.road.serviceImp;

import com.suhang.road.mapper.LuoYeQiaoMuMapper;
import com.suhang.road.po.LuoYeQiaoMu;
import com.suhang.road.povo.LuoYeQiaoMuVo;
import com.suhang.road.service.LuoYeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LuoYeServiceImp implements LuoYeService {
    @Autowired
    private LuoYeQiaoMuMapper luoYeQiaoMuMapper;


    @Override
    public List<LuoYeQiaoMu> findLuoYesByBlock(String block, int pc, int ps) throws Exception {
        int snep = (pc-1) *ps;
        LuoYeQiaoMuVo luoYeQiaoMuVoall = new LuoYeQiaoMuVo();
        luoYeQiaoMuVoall.setSnep(snep);
        luoYeQiaoMuVoall.setPs(ps);
        LuoYeQiaoMuVo luoYeQiaoMuVo = new LuoYeQiaoMuVo();
        luoYeQiaoMuVo.setSnep(snep);
        luoYeQiaoMuVo.setPs(ps);
        luoYeQiaoMuVo.setBlock(block);
        if (block.equals("admin")||block.equals("admin2")){
            return luoYeQiaoMuMapper.findLuoYeQiaoMusAll(luoYeQiaoMuVoall);
        }else {
            return luoYeQiaoMuMapper.findLuoYeQiaoMusByBlock(luoYeQiaoMuVo);
        }
    }

    @Override
    public void updateLuoYeList(List<LuoYeQiaoMu> luoYeQiaoMus) throws Exception {
        luoYeQiaoMuMapper.updateLuoYeQiaoMuList(luoYeQiaoMus);
    }

    @Override
    public Integer findCountAll() throws Exception {
        return luoYeQiaoMuMapper.findCountAll();
    }

    @Override
    public List<LuoYeQiaoMu> getLuoYesAll() throws Exception {
        return luoYeQiaoMuMapper.getLuoYesAll();
    }

    @Override
    public LuoYeQiaoMu findLuoYeById(int qm_id) throws Exception {
        return luoYeQiaoMuMapper.findLuoYeById(qm_id);
    }

    @Override
    public List<LuoYeQiaoMu> getLuoYesByBlock(String block) throws Exception {
        return luoYeQiaoMuMapper.getLuoYesByBlock(block);
    }

    @Override
    public Integer findCountByBlock(String block) throws Exception {
        return luoYeQiaoMuMapper.findCountByBlock(block);
    }

    @Override
    public void deleteLuoYesByIds(String[] qm_ids) throws Exception {
        luoYeQiaoMuMapper.deleteLuoYeQiaoMusByIds(qm_ids);
    }

    @Override
    public void insertLuoYe(LuoYeQiaoMu luoYeQiaoMu) throws Exception {
        luoYeQiaoMuMapper.insertLuoYeQiaoMu(luoYeQiaoMu);
    }
}

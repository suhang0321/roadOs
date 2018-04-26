package com.suhang.road.serviceImp;

import com.suhang.road.mapper.LuDengMapper;
import com.suhang.road.po.LuDeng;
import com.suhang.road.povo.LuDengVo;
import com.suhang.road.service.LuDengService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LuDengServiceImp implements LuDengService {
    @Autowired
    private LuDengMapper luDengMapper;


    @Override
    public List<LuDeng> findLuDengsByBlock(String block, int pc, int ps) throws Exception {
        int snep = (pc - 1) * ps;
        LuDengVo luDengVoall = new LuDengVo();
        luDengVoall.setSnep(snep);
        luDengVoall.setPs(ps);
        LuDengVo luDengVo = new LuDengVo();
        luDengVo.setSnep(snep);
        luDengVo.setPs(ps);
        luDengVo.setBlock(block);
        if (block.equals("admin")||block.equals("admin2")) {
            return luDengMapper.findLuDengsAll(luDengVoall);
        } else {
            return luDengMapper.findLuDengsByBlock(luDengVo);
        }
    }

    @Override
    public void updateLuDengList(List<LuDeng> luDengs) throws Exception {
        luDengMapper.updateLuDengList(luDengs);
    }

    @Override
    public Integer findCountAll() throws Exception {
        return luDengMapper.findCountAll();
    }

    @Override
    public LuDeng findLuDengById(int ld_id) throws Exception {
        return luDengMapper.findLuDengById(ld_id);
    }

    @Override
    public Integer findCountByBlock(String block) throws Exception {
        return luDengMapper.findCountByBlock(block);
    }

    @Override
    public void deleteLuDengsByIds(String[] ld_ids) throws Exception {
        luDengMapper.deleteLuDengsByIds(ld_ids);
    }

    @Override
    public void insertLuDeng(LuDeng luDeng) throws Exception {
        luDengMapper.insertLuDeng(luDeng);
    }
}

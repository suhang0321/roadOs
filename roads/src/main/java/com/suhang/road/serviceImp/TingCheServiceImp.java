package com.suhang.road.serviceImp;

import com.suhang.road.mapper.TingCheMapper;
import com.suhang.road.mapper.TingLangMapper;
import com.suhang.road.po.TingChe;
import com.suhang.road.po.TingLang;
import com.suhang.road.povo.TingCheVo;
import com.suhang.road.service.TingCheService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TingCheServiceImp implements TingCheService{
    @Autowired
    private TingCheMapper tingCheMapper;

    @Override
    public List<TingChe> findTingChesByBlock(String block, int pc, int ps) throws Exception {
        int snep = (pc - 1) * ps;
        TingCheVo tingCheVoall = new TingCheVo();
        tingCheVoall.setSnep(snep);
        tingCheVoall.setPs(ps);
        TingCheVo tingCheVo = new TingCheVo();
        tingCheVo.setSnep(snep);
        tingCheVo.setPs(ps);
        tingCheVo.setBlock(block);
        if (block.equals("admin")||block.equals("admin2")) {
            return tingCheMapper.findTingChesAll(tingCheVoall);
        } else {
            return tingCheMapper.findTingChesByBlock(tingCheVo);
        }
    }

    @Override
    public void updateTingCheList(List<TingChe> tingChes) throws Exception {
        tingCheMapper.updateTingCheList(tingChes);
    }

    @Override
    public Integer findCountAll() throws Exception {
        return tingCheMapper.findCountAll();
    }



    @Override
    public TingChe findTingCheById(int tc_id) throws Exception {
        return tingCheMapper.findTingCheById(tc_id);
    }

    @Override
    public List<TingChe> getTingChesAll() throws Exception {
        return tingCheMapper.getTingChesAll();
    }

    @Override
    public List<TingChe> getTingChesByBlock(String block) throws Exception {
        return tingCheMapper.getTingChesByBlock(block);
    }

    @Override
    public Integer findCountByBlock(String block) throws Exception {
        return tingCheMapper.findCountByBlock(block);
    }

    @Override
    public void deleteTingChesByIds(String[] tc_ids) throws Exception {
        tingCheMapper.deleteTingChesByIds(tc_ids);
    }

    @Override
    public void insertTingChe(TingChe tingChe) throws Exception {
        tingCheMapper.insertTingChe(tingChe);
    }
}

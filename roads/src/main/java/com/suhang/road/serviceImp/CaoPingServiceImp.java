package com.suhang.road.serviceImp;

import com.suhang.road.mapper.CaoPingMapper;
import com.suhang.road.po.CaoPing;
import com.suhang.road.povo.CaoPingVo;
import com.suhang.road.service.CaoPingService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CaoPingServiceImp implements CaoPingService {
    @Autowired
    private CaoPingMapper caoPingMapper;
    @Override
    public List<CaoPing> findCaoPingsByBlock(String block,int pc,int ps) throws Exception {
        int snep = (pc-1) *ps;
        CaoPingVo caoPingVoall = new CaoPingVo();
        caoPingVoall.setSnep(snep);
        caoPingVoall.setPs(ps);
        CaoPingVo caoPingVo = new CaoPingVo();
        caoPingVo.setSnep(snep);
        caoPingVo.setPs(ps);
        caoPingVo.setBlock(block);
        if (block.equals("admin")||block.equals("admin2")){
            return caoPingMapper.findCaoPingsAll(caoPingVoall);

        }else {
            return caoPingMapper.findCaoPingsByBlock(caoPingVo);
        }

    }

    @Override
    public void updateCaoPingList(List<CaoPing> caoPingList) throws Exception {
        caoPingMapper.updateCaoPingList(caoPingList);
    }

    @Override
    public Integer findCountAll() throws Exception {
        return caoPingMapper.findCountAll();
    }

    @Override
    public CaoPing findCaoPingById(int cp_id) throws Exception {
        return caoPingMapper.findCaoPingById(cp_id);
    }

    @Override
    public List<CaoPing> getCaoPingsAll() throws Exception {
        return caoPingMapper.getCaoPingsAll();
    }

    @Override
    public List<CaoPing> getCaoPingsByBlock(String block) throws Exception {
        return caoPingMapper.getCaoPingsByBlock(block);
    }

    @Override
    public Integer findCountByBlock(String block) throws Exception {
        return caoPingMapper.findCountByBlock(block);
    }

    @Override
    public void deleteCaoPingsByIds(String[] cp_ids) throws Exception {
        caoPingMapper.deleteCaoPingsByIds(cp_ids);
    }

    @Override
    public void insertCaoPing(CaoPing caoPing) throws Exception {
        caoPingMapper.insertCaoPing(caoPing);
    }
}

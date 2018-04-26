package com.suhang.road.serviceImp;

import com.suhang.road.mapper.TingLangMapper;
import com.suhang.road.po.TingLang;
import com.suhang.road.povo.TingLangVo;
import com.suhang.road.service.TingLangService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TingLangServiceImp implements TingLangService {
    @Autowired
    private TingLangMapper tingLangMapper;
    @Override
    public List<TingLang> findTingLangsByBlock(String block, int pc, int ps) throws Exception {
        int snep = (pc - 1) * ps;
        TingLangVo tingLangVoall = new TingLangVo();
        tingLangVoall.setSnep(snep);
        tingLangVoall.setPs(ps);
        TingLangVo tingLangVo = new TingLangVo();
        tingLangVo.setSnep(snep);
        tingLangVo.setPs(ps);
        tingLangVo.setBlock(block);
        if (block.equals("admin")||block.equals("admin2")) {
            return tingLangMapper.findTingLangsAll(tingLangVoall);
        } else {
            return tingLangMapper.findTingLangsByBlock(tingLangVo);
        }
    }

    @Override
    public void updateTingLangList(List<TingLang> tingLangs) throws Exception {
        tingLangMapper.updateTingLangList(tingLangs);
    }

    @Override
    public Integer findCountAll() throws Exception {
        return tingLangMapper.findCountAll();
    }

    @Override
    public TingLang findTingLangById(int lt_id) throws Exception {
        return tingLangMapper.findTingLangById(lt_id);
    }

    @Override
    public List<TingLang> getTingLangsAll() throws Exception {
        return tingLangMapper.getTingLangsAll();
    }

    @Override
    public List<TingLang> getTingLangsByBlock(String block) throws Exception {
        return tingLangMapper.getTingLangsByBlock(block);
    }

    @Override
    public Integer findCountByBlock(String block) throws Exception {
        return tingLangMapper.findCountByBlock(block);
    }

    @Override
    public void deleteTingLangsByIds(String[] lt_ids) throws Exception {
        tingLangMapper.deleteTingLangsByIds(lt_ids);
    }

    @Override
    public void insertTingLang(TingLang tingLang) throws Exception {
        tingLangMapper.insertTingLang(tingLang);
    }
}

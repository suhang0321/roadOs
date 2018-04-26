package com.suhang.road.serviceImp;

import com.suhang.road.mapper.FangZhuanMapper;
import com.suhang.road.po.FangZhuan;
import com.suhang.road.povo.FangZhuanVo;
import com.suhang.road.service.FangZhuanService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FangZhuanServiceImp implements FangZhuanService {
    @Autowired
    private FangZhuanMapper fangZhuanMapper;
    @Override
    public List<FangZhuan> findFangZhuansByBlock(String block,int pc ,int ps) throws Exception {
        int snep = (pc-1) *ps;
        FangZhuanVo fangZhuanVoall = new FangZhuanVo();
        fangZhuanVoall.setSnep(snep);
        fangZhuanVoall.setPs(ps);
        FangZhuanVo fangZhuanVo = new FangZhuanVo();
        fangZhuanVo.setSnep(snep);
        fangZhuanVo.setPs(ps);
        fangZhuanVo.setBlock(block);
        if (block.equals("admin")||block.equals("admin2")){
            return fangZhuanMapper.findFangZhuansAll(fangZhuanVoall);

        }else {
           return fangZhuanMapper.findFangZhuansByBlock(fangZhuanVo);
        }

    }

    @Override
    public void updateFangZhuanList(List<FangZhuan> fangZhuanList) throws Exception {
        fangZhuanMapper.updateFangZhuanList(fangZhuanList);

    }

    @Override
    public List<FangZhuan> findFangZhuansAllNoFenye() throws Exception {
        return fangZhuanMapper.findFangZhuansAllNoFenye();
    }

    @Override
    public FangZhuan findFangZhuanById(int fz_id) throws Exception {
        return fangZhuanMapper.findFangZhuanById(fz_id);
    }

    @Override
    public List<FangZhuan> findFangZhuansByBlockNoFenye(String block) throws Exception {
        return fangZhuanMapper.findFangZhuanByBlockNoFenye(block);
    }

    @Override
    public Integer findCountAll() throws Exception {
        return fangZhuanMapper.findCountAll();
    }

    @Override
    public Integer findCountByBlock(String block) throws Exception {
        return fangZhuanMapper.findCountByBlock(block);
    }

    @Override
    public void deleteFangZhuanByIds(String[] fz_ids) throws Exception {
        fangZhuanMapper.deleteFangZhuansByIds(fz_ids);
    }

    @Override
    public void insertFangZhuan(FangZhuan fangZhuan) throws Exception {
        fangZhuanMapper.insertFangZhuan(fangZhuan);
    }
}

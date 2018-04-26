package com.suhang.road.serviceImp;

import com.suhang.road.mapper.QiaoMuMapper;
import com.suhang.road.po.QiaoMu;
import com.suhang.road.povo.QiaoMuVo;
import com.suhang.road.service.QiaoMuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QiaoMuServiceImp implements QiaoMuService {
    @Autowired
    private QiaoMuMapper qiaoMuMapper;


    @Override
    public List<QiaoMu> findQiaoMusByBlock(String block, int pc, int ps) throws Exception {
        int snep = (pc-1) *ps;
        QiaoMuVo qiaoMuVoall = new QiaoMuVo();
        qiaoMuVoall.setSnep(snep);
        qiaoMuVoall.setPs(ps);
        QiaoMuVo qiaoMuVo = new QiaoMuVo();
        qiaoMuVo.setSnep(snep);
        qiaoMuVo.setPs(ps);
        qiaoMuVo.setBlock(block);
        if (block.equals("admin")||block.equals("admin2")){
            return qiaoMuMapper.findQiaoMusAll(qiaoMuVoall);
        }else {
            return qiaoMuMapper.findQiaoMusByBlock(qiaoMuVo);
        }
    }

    @Override
    public void updateQiaoMuList(List<QiaoMu> qiaoMus) throws Exception {
        qiaoMuMapper.updateQiaoMuList(qiaoMus);
    }

    @Override
    public Integer findCountAll() throws Exception {
        return qiaoMuMapper.findCountAll();
    }

    @Override
    public QiaoMu findQiaoMuById(int ls_id) throws Exception {
        return qiaoMuMapper.findQiaoMuById(ls_id);
    }

    @Override
    public List<QiaoMu> getQiaoMusAll() throws Exception {
        return qiaoMuMapper.getQiaoMusAll();
    }

    @Override
    public List<QiaoMu> getQiaoMuByBlock(String bloock) throws Exception {
        return qiaoMuMapper.getQiaoMusByBlock(bloock);
    }

    @Override
    public Integer findCountByBlock(String block) throws Exception {
        return qiaoMuMapper.findCountByBlock(block);
    }

    @Override
    public void deleteQiaoMusByIds(String[] ls_ids) throws Exception {
        qiaoMuMapper.deleteQiaoMusByIds(ls_ids);
    }

    @Override
    public void insertQiaoMu(QiaoMu qiaoMu) throws Exception {
        qiaoMuMapper.insertQiaoMu(qiaoMu);
    }
}

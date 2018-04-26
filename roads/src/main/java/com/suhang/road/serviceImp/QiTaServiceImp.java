package com.suhang.road.serviceImp;

import com.suhang.road.mapper.QiTaMapper;
import com.suhang.road.po.QiTa;
import com.suhang.road.povo.QiTaVo;
import com.suhang.road.service.QiTaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QiTaServiceImp implements QiTaService {
    @Autowired
    private QiTaMapper qiTaMapper;
    @Override
    public List<QiTa> findQiTasByBlock(String block, int pc, int ps) throws Exception {
        int snep = (pc - 1) * ps;
        QiTaVo qiTaVoall = new QiTaVo();
        qiTaVoall.setSnep(snep);
        qiTaVoall.setPs(ps);
        QiTaVo qiTaVo = new QiTaVo();
        qiTaVo.setSnep(snep);
        qiTaVo.setPs(ps);
        qiTaVo.setBlock(block);
        if (block.equals("admin")||block.equals("admin2")) {
            return qiTaMapper.findQiTasAll(qiTaVoall);
        } else {
            return qiTaMapper.findQiTasByBlock(qiTaVo);
        }
    }

    @Override
    public void updateQiTaList(List<QiTa> qiTas) throws Exception {
        qiTaMapper.updateQiTaList(qiTas);
    }

    @Override
    public Integer findCountAll() throws Exception {
        return qiTaMapper.findCountAll();
    }

    @Override
    public QiTa findQiTaById(int qt_id) throws Exception {
        return qiTaMapper.findQiTaById(qt_id);
    }

    @Override
    public Integer findCountByBlock(String block) throws Exception {
        return qiTaMapper.findCountByBlock(block);
    }

    @Override
    public void deleteQiTasByIds(String[] qt_ids) throws Exception {
        qiTaMapper.deleteQiTasByIds(qt_ids);
    }

    @Override
    public void insertQiTa(QiTa qiTa) throws Exception {
        qiTaMapper.insertQiTa(qiTa);
    }
}

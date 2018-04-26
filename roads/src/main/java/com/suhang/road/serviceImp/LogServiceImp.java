package com.suhang.road.serviceImp;

import com.suhang.road.mapper.LogMapper;
import com.suhang.road.po.Log;
import com.suhang.road.povo.LogVo;
import com.suhang.road.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class LogServiceImp implements LogService {
    @Autowired
    private LogMapper logMapper;

    @Override
    public void insertLog(String operation, String block, String table, String content) throws Exception {
        Log log = new Log();
        String nowtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        log.setL_time(nowtime);
        log.setL_operation(operation);
        log.setL_block(block);
        log.setL_table(table);
        log.setL_content(content);
        logMapper.insertLog(log);
    }

    @Override
    public List<Log> findLogsAll(int pc, int ps) throws Exception {
        int snep = (pc-1) *ps;
        LogVo logVo = new LogVo();
        logVo.setSnep(snep);
        logVo.setPs(ps);
        return logMapper.findLogsAll(logVo);
    }

    @Override
    public int findLogCountAll() throws Exception {
        return logMapper.findLogCountAll();
    }

    @Override
    public List<Log> findLogsByOperation(String l_opertaion, int pc, int ps) throws Exception {
        int snep = (pc-1) *ps;
        LogVo logVo = new LogVo();
        logVo.setSnep(snep);
        logVo.setPs(ps);
        logVo.setL_operation(l_opertaion);
        return logMapper.findLogsByOperation(logVo);
    }

    @Override
    public Integer findCountByOperation(String l_operation) throws Exception {
        LogVo logVo = new LogVo();
        logVo.setL_operation(l_operation);
        return logMapper.findCountByOperation(logVo);
    }

    @Override
    public List<Log> findLogsByMulty(String l_operation, String l_block, String l_table, int pc, int ps) throws Exception {
        int snep = (pc-1) *ps;
        LogVo logVo = new LogVo();
        logVo.setSnep(snep);
        logVo.setPs(ps);
        logVo.setL_operation(l_operation);
        logVo.setL_block(l_block);
        logVo.setL_table(l_table);
        return logMapper.findLogsByMulty(logVo);
    }

    @Override
    public Integer findCountByMulty(String l_operation, String l_block, String l_table) throws Exception {
        LogVo logVo = new LogVo();
        logVo.setL_operation(l_operation);
        logVo.setL_table(l_table);
        logVo.setL_block(l_block);
        Integer num =  logMapper.findCountByMulty(logVo);
        return num;
    }
}

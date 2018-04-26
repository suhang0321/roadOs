package com.suhang.road.service;


import com.suhang.road.po.Log;

import java.util.List;

public interface LogService {
    public void insertLog(String operation,String block,String table,String content)throws Exception;

    public List<Log> findLogsAll(int pc,int ps)throws Exception;

    public int findLogCountAll()throws Exception;

    public List<Log> findLogsByOperation(String l_opertaion,int pc,int ps)throws Exception;

    public Integer findCountByOperation(String l_operation)throws Exception;

    public List<Log> findLogsByMulty(String l_operation,String l_block,String l_table,int pc,int ps)throws Exception;

    public Integer findCountByMulty(String l_operation,String l_block,String l_table)throws Exception;
}

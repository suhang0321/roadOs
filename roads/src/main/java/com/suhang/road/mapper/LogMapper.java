package com.suhang.road.mapper;

import com.suhang.road.po.Log;
import com.suhang.road.povo.LogVo;

import java.util.List;

public interface LogMapper {
  public void insertLog(Log log)throws Exception;

  public List<Log> findLogsAll(LogVo logVo)throws Exception;

  public int findLogCountAll()throws Exception;

  public List<Log> findLogsByOperation(LogVo logVo)throws Exception;

  public Integer findCountByOperation(LogVo logVo)throws Exception;

  public  List<Log> findLogsByMulty(LogVo logVo)throws Exception;

  public Integer findCountByMulty(LogVo logVo)throws Exception;
}

package com.suhang.road.mapper;

import com.suhang.road.po.Log;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;


public class LogMapperTest {
    private ClassPathXmlApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
    }

    @Test
    public void insertLogTest()throws Exception {
        LogMapper logMapper = (LogMapper)applicationContext.getBean("logMapper");
        Log log = new Log();
        Date date = new Date();
        String nowtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        log.setL_time(nowtime);
        log.setL_operation("添加");
        log.setL_block("中心校区");
        log.setL_table("柏油马路");
        log.setL_content("content");
        logMapper.insertLog(log);
    }
}

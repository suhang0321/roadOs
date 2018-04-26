package com.suhang.road.mapper;

import com.suhang.road.po.LuDeng;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class LuDengMapperTest {
    private ClassPathXmlApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
    }

//    @Test
//    public void findLudengTest()throws Exception {
//        LuDengMapper luDengMapper = (LuDengMapper) applicationContext.getBean("luDengMapper");
//        System.out.println(luDengMapper.findLuDengsAll());
//        System.out.println(luDengMapper.findLuDengsByBlock("center"));
//    }

    @Test
    public void insertLuDengTest() throws Exception{
        LuDengMapper luDengMapper = (LuDengMapper) applicationContext.getBean("luDengMapper");
        LuDeng luDeng = new LuDeng();
        luDeng.setLd_logo("ld");
        luDeng.setLd_name("草坪灯");
        luDeng.setLd_location("自由大陆");
        luDeng.setLd_distance("50m");
        luDeng.setLd_type("低杆");
        luDeng.setLd_num("50个");
        luDeng.setLd_year("2年");
        luDeng.setLd_block("center");
        luDengMapper.insertLuDeng(luDeng);
    }

    @Test
    public void updateludengtest()throws Exception {
        LuDengMapper luDengMapper = (LuDengMapper) applicationContext.getBean("luDengMapper");
        LuDeng luDeng = new LuDeng();
        luDeng.setLd_id(1);
        luDeng.setLd_logo("ld");
        luDeng.setLd_name("草坪灯");
        luDeng.setLd_location("自由大陆");
        luDeng.setLd_distance("50m");
        luDeng.setLd_type("低杆");
        luDeng.setLd_num("20个");
        luDeng.setLd_year("5年");
        luDeng.setLd_block("center");
        LuDeng luDeng1 = new LuDeng();
        luDeng1.setLd_id(2);
        luDeng1.setLd_logo("ld");
        luDeng1.setLd_name("草坪灯");
        luDeng1.setLd_location("自由大陆");
        luDeng1.setLd_distance("50m");
        luDeng1.setLd_type("低杆");
        luDeng1.setLd_num("20个");
        luDeng1.setLd_year("8年");
        luDeng1.setLd_block("center");
        List<LuDeng> luDengs = new ArrayList<LuDeng>();
        luDengs.add(luDeng);
        luDengs.add(luDeng1);
        luDengMapper.updateLuDengList(luDengs);
    }

    @Test
    public void deleteTest()throws Exception {
        LuDengMapper luDengMapper = (LuDengMapper) applicationContext.getBean("luDengMapper");
        String[] ld_ids = {"1","2"};
        luDengMapper.deleteLuDengsByIds(ld_ids);
    }
}

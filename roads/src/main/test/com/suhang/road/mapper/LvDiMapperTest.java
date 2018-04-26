package com.suhang.road.mapper;

import com.suhang.road.po.LvDi;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class LvDiMapperTest {
    private ClassPathXmlApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
    }

//    @Test
//    public void findLvDiByBlockTest()throws Exception {
//        LvDiMapper lvDiMapper = (LvDiMapper) applicationContext.getBean("lvDiMapper");
//        System.out.println(lvDiMapper.findLvDisByBlock("center"));
//    }

//    @Test
//    public void findLvDisAllTest()throws Exception {
//        LvDiMapper lvDiMapper = (LvDiMapper) applicationContext.getBean("lvDiMapper");
//        System.out.println(lvDiMapper.findLvDisAll());
//    }

    @Test
    public void insertLvDiTest()throws Exception {
        LvDiMapper lvDiMapper = (LvDiMapper) applicationContext.getBean("lvDiMapper");
        LvDi lvDi = new LvDi();
        lvDi.setLd_logo("ld");
        lvDi.setLd_name("绿地");
        lvDi.setLd_location("教学楼周边");
        lvDi.setLd_direction("南北");
        lvDi.setLd_length("50m");
        lvDi.setLd_width("50m");
        lvDi.setLd_area("2500平方米");
        lvDi.setLd_block("center");
        lvDiMapper.insertLvDi(lvDi);
    }

    @Test
    public void updateLvDiSTest()throws Exception {
        LvDiMapper lvDiMapper = (LvDiMapper) applicationContext.getBean("lvDiMapper");
        List<LvDi>lvDis = new ArrayList<LvDi>();
        LvDi lvDi = new LvDi();
        lvDi.setLd_id(1);
        lvDi.setLd_logo("ld");
        lvDi.setLd_name("绿地");
        lvDi.setLd_location("教学楼周边");
        lvDi.setLd_direction("南北");
        lvDi.setLd_length("50m");
        lvDi.setLd_width("50m");
        lvDi.setLd_area("2500平方米");
        lvDi.setLd_block("center");
        LvDi lvDi1 = new LvDi();
        lvDi1.setLd_id(2);
        lvDi1.setLd_logo("ld");
        lvDi1.setLd_name("绿地");
        lvDi1.setLd_location("教学楼周边");
        lvDi1.setLd_direction("南北");
        lvDi1.setLd_length("60m");
        lvDi1.setLd_width("60m");
        lvDi1.setLd_area("3600平方米");
        lvDi1.setLd_block("center");
        lvDis.add(lvDi);
        lvDis.add(lvDi1);
        lvDiMapper.updateLvDiList(lvDis);
    }

    @Test
    public void deleteLvDiSByIdsTest()throws Exception {
        LvDiMapper lvDiMapper = (LvDiMapper) applicationContext.getBean("lvDiMapper");
        String[] ld_ids = {"1","2"};
        lvDiMapper.deleteLvDisByIds(ld_ids);
    }
}

package com.suhang.road.mapper;

import com.suhang.road.po.CaoPing;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class CaoPingMapperTest {
    private ClassPathXmlApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
    }

//    @Test
//    public void findCaoPingsByBlockTest()throws Exception {
//        CaoPingMapper caoPingMapper = (CaoPingMapper) applicationContext.getBean("caoPingMapper");
//        System.out.println(caoPingMapper.findCaoPingsByBlock("center"));
//    }

//    @Test
//    public void findCaoPingsAllTest()throws Exception {
//        CaoPingMapper caoPingMapper = (CaoPingMapper) applicationContext.getBean("caoPingMapper");
//        System.out.println(caoPingMapper.findCaoPingsAll());
//    }

    @Test
    public void insertCaoPing()throws Exception {
        CaoPingMapper caoPingMapper = (CaoPingMapper) applicationContext.getBean("caoPingMapper");
        CaoPing caoPing = new CaoPing();
        caoPing.setCp_logo("CP");
        caoPing.setCp_name("草坪");
        caoPing.setCp_location("行政楼周边");
        caoPing.setCp_direction("南北");
        caoPing.setCp_length("40m");
        caoPing.setCp_width("20m");
        caoPing.setCp_area("800平方米");
        caoPing.setCp_block("center");
        caoPingMapper.insertCaoPing(caoPing);
    }

    @Test
    public void updateCaoPingListTest()throws Exception {
        CaoPingMapper caoPingMapper = (CaoPingMapper) applicationContext.getBean("caoPingMapper");
        List<CaoPing> caoPings =new ArrayList<CaoPing>();
        CaoPing caoPing = new CaoPing();
        caoPing.setCp_id(3);
        caoPing.setCp_logo("CP");
        caoPing.setCp_name("草坪");
        caoPing.setCp_location("行政楼周边");
        caoPing.setCp_direction("南北");
        caoPing.setCp_length("40m");
        caoPing.setCp_width("20m");
        caoPing.setCp_area("800平方米");
        caoPing.setCp_block("center");

        CaoPing caoPing2 = new CaoPing();
        caoPing2.setCp_id(4);
        caoPing2.setCp_logo("CP");
        caoPing2.setCp_name("草坪");
        caoPing2.setCp_location("行政楼周边");
        caoPing2.setCp_direction("南北");
        caoPing2.setCp_length("50m");
        caoPing2.setCp_width("20m");
        caoPing2.setCp_area("1000平方米");
        caoPing2.setCp_block("center");
        caoPings.add(caoPing);
        caoPings.add(caoPing2);
        caoPingMapper.updateCaoPingList(caoPings);
    }

    @Test
    public void deleteCaoPingsByIdsTest()throws Exception {
        CaoPingMapper caoPingMapper = (CaoPingMapper) applicationContext.getBean("caoPingMapper");
        String[] cp_ids = {"1","2"};
        caoPingMapper.deleteCaoPingsByIds(cp_ids);
    }
}

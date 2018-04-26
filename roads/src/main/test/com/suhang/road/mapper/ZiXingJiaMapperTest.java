package com.suhang.road.mapper;

import com.suhang.road.po.ZiXingJia;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class ZiXingJiaMapperTest {
    private ClassPathXmlApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
    }

//    @Test
//    public void findZiXingJiasByBlockTest()throws Exception {
//        ZiXingJiaMapper ziXingJiaMapper = (ZiXingJiaMapper) applicationContext.getBean("ziXingJiaMapper");
//        System.out.println(ziXingJiaMapper.findZiXingJiasByBlock("center"));
//    }
//
//    @Test
//    public void findZiXingJiasAllTest()throws Exception {
//        ZiXingJiaMapper ziXingJiaMapper = (ZiXingJiaMapper) applicationContext.getBean("ziXingJiaMapper");
//        System.out.println(ziXingJiaMapper.findZiXingJiasAll());
//    }

    @Test
    public void insertZiXingJiaTest()throws Exception {
        ZiXingJiaMapper ziXingJiaMapper = (ZiXingJiaMapper) applicationContext.getBean("ziXingJiaMapper");
        ZiXingJia ziXingJia = new ZiXingJia();
        ziXingJia.setCj_logo("cj");
        ziXingJia.setCj_name("自行车架");
        ziXingJia.setCj_location("前进大街");
        ziXingJia.setCj_size("6米长");
        ziXingJia.setCj_kind("槽钢");
        ziXingJia.setCj_num("20个");
        ziXingJia.setCj_capacity("300个");
        ziXingJia.setCj_block("center");
        ziXingJiaMapper.insertZiXingJia(ziXingJia);
    }

    @Test
    public void updateZiXingJiaListTest()throws Exception {
        ZiXingJiaMapper ziXingJiaMapper = (ZiXingJiaMapper) applicationContext.getBean("ziXingJiaMapper");
        List<ZiXingJia>ziXingJias = new ArrayList<ZiXingJia>();
        ZiXingJia ziXingJia = new ZiXingJia();
        ziXingJia.setCj_id(1);
        ziXingJia.setCj_logo("cj");
        ziXingJia.setCj_name("自行车架");
        ziXingJia.setCj_location("前进大街");
        ziXingJia.setCj_size("3米长");
        ziXingJia.setCj_kind("槽钢");
        ziXingJia.setCj_num("20个");
        ziXingJia.setCj_capacity("300个");
        ziXingJia.setCj_block("center");
        ZiXingJia ziXingJia1 = new ZiXingJia();
        ziXingJia1.setCj_id(2);
        ziXingJia1.setCj_logo("cj");
        ziXingJia1.setCj_name("自行车架");
        ziXingJia1.setCj_location("前进大街");
        ziXingJia1.setCj_size("3米长");
        ziXingJia1.setCj_kind("槽钢");
        ziXingJia1.setCj_num("20个");
        ziXingJia1.setCj_capacity("250个");
        ziXingJia1.setCj_block("center");
        ziXingJias.add(ziXingJia);
        ziXingJias.add(ziXingJia1);
        ziXingJiaMapper.updateZiXingJiaList(ziXingJias);
    }

    @Test
    public void deleteZiXingJiasTest()throws Exception {
        ZiXingJiaMapper ziXingJiaMapper = (ZiXingJiaMapper) applicationContext.getBean("ziXingJiaMapper");
        String[] cj_ids = {"1","2"};
        ziXingJiaMapper.deleteZiXingJiasByIds(cj_ids);
    }
}

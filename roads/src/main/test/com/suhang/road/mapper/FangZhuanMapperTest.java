package com.suhang.road.mapper;

import com.suhang.road.po.FangZhuan;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class FangZhuanMapperTest {
    private ClassPathXmlApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
    }

//    @Test
//    public void findFangZhuanByBlockTest()throws Exception {
//        FangZhuanMapper fangZhuanMapper = (FangZhuanMapper) applicationContext.getBean("fangZhuanMapper");
//        List<FangZhuan> fangZhuans = fangZhuanMapper.findFangZhuansByBlock("block");
//        System.out.println(fangZhuans);
//    }

//    @Test
//    public void findFangZhuanALLtEST()throws Exception {
//        FangZhuanMapper fangZhuanMapper = (FangZhuanMapper) applicationContext.getBean("fangZhuanMapper");
//        System.out.println(fangZhuanMapper.findFangZhuansAll());
//    }

    @Test
    public void updateFangZhuanListTest()throws Exception {
        FangZhuanMapper fangZhuanMapper = (FangZhuanMapper) applicationContext.getBean("fangZhuanMapper");
        List<FangZhuan> fangZhuanList = new ArrayList<FangZhuan>();
        FangZhuan fz1 = new FangZhuan();
        fz1.setFz_id(1);
        fz1.setFz_logo("FZ");
        fz1.setFz_name("人民大街");
        fz1.setFz_location("人民大街旁");
        fz1.setFz_direction("东西");
        fz1.setFz_length("500m");
        fz1.setFz_width("5m");
        fz1.setFz_area("2500平方米");
        fz1.setFz_block("block");
        FangZhuan fz2 = new FangZhuan();
        fz2.setFz_id(2);
        fz2.setFz_logo("FZ");
        fz2.setFz_name("人民大街");
        fz2.setFz_location("人民大街左侧");
        fz2.setFz_direction("其他");
        fz2.setFz_length("500m");
        fz2.setFz_width("2m");
        fz2.setFz_area("1000平方米");
        fz2.setFz_block("block");
        fangZhuanList.add(fz1);
        fangZhuanList.add(fz2);
        fangZhuanMapper.updateFangZhuanList(fangZhuanList);
    }

    @Test
    public void deleteFangZhuansTest()throws Exception {
        FangZhuanMapper fangZhuanMapper = (FangZhuanMapper) applicationContext.getBean("fangZhuanMapper");
        String[] fz_ids = {"1","2"};
        fangZhuanMapper.deleteFangZhuansByIds(fz_ids);
    }

    @Test
    public void insertFangZhuanTest()throws Exception {
        FangZhuanMapper fangZhuanMapper = (FangZhuanMapper) applicationContext.getBean("fangZhuanMapper");
        FangZhuan fangZhuan = new FangZhuan();
        fangZhuan.setFz_logo("FZ");
        fangZhuan.setFz_name("中央大道");
        fangZhuan.setFz_location("南侧");
        fangZhuan.setFz_direction("其他");
        fangZhuan.setFz_length("520M");
        fangZhuan.setFz_width("1.8M");
        fangZhuan.setFz_area("936平方米");
        fangZhuan.setFz_block("block");
        fangZhuanMapper.insertFangZhuan(fangZhuan);
    }
}

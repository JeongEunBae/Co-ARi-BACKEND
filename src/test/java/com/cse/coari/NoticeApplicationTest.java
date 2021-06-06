//package com.cse.coari;
//
//import com.cse.coari.domain.notices.Notices;
//import com.cse.coari.mapper.NoticesMapper;
//import com.cse.coari.web.dto.notices.NoticesSaveRequestDto;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//@SpringJUnitConfig
//@SpringBootTest(classes = Application.class)
//@WebAppConfiguration
//public class NoticeApplicationTest {
//
//    @Autowired
//    private NoticesMapper noticesMapper;
//
//    @Test
//    public void contextLoads() {
//
//    }
//
//    @Test
//    public void testMapper() throws Exception {
//        Notices notices = new Notices();
//        try {
//            notices.setAuthor("1");
//            notices.setTitle("2");
//            notices.setDate("3");
//            notices.setUrl("4");
//            noticesMapper.NoticeInsert(notices);
//        }catch(NullPointerException npe) {
//            System.out.println("NULL!!");
//        }
//
//    }
//}

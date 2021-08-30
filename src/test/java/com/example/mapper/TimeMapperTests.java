package com.example.mapper;

import com.example.jex00.config.RootConfig;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
// 밑에 두개는 test에서만 사용하는 것
@ExtendWith(SpringExtension.class) //해당코드가 스프링실행을 한다고 알려주는 역할
@ContextConfiguration( classes = {RootConfig.class}) //지정된 클래스나 문자열을 이용해서 필요한 객체를 등록 : 클래스패스나 파일을 이용해서 경로지정

public class TimeMapperTests {

    @Autowired //테스트코드는 자동주입 X ->Autowired를 기본으로 사용
    TimeMapper timeMapper; //TimeMapper.java자체는 문제없는데 mybatis가 인식을 못해서 오류가 뜬다.

    @Test
    public void testGetTime1(){

        log.info(timeMapper);
        log.info(timeMapper.getTime());
    }

}

package com.example.jex00;


import com.example.jex00.config.RootConfig;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.ArrayList;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration( classes = {RootConfig.class}) //어떤 설정파일을 사용할지
public class ApplicationContextTests { // ApplicationContext 생성확인

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    ArrayList<String> names;

    @Autowired
    DataSource dataSource;

    @Test
    public void testConnection() throws Exception{

        Connection con = dataSource.getConnection();
        log.info(con);
        con.close();
    }

    @Test
    public void test1() {
        log.info("-----------------------------");
        log.info("-----------------------------");
        log.info("applicationContext");
        log.info("names");
        log.info("-----------------------------");
        log.info("-----------------------------");
    }
}

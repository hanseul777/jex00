package com.example.jex00.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.ArrayList;

//내부적인 부분 : Component / 외부적인 부분 : Configuration
@Configuration //걸자마자 옆에 bean표시가 생김, 자바소스를 빈으로 만들어주는 태그
@ComponentScan(basePackages = {"com.example.service"})//이설정을 읽어들이면 이 패키지를 컴포넌트스캔(조사)해줘
@MapperScan(basePackages = {"com.example.mapper"})
public class RootConfig {

    @Bean //mybatis 연결
    public SqlSessionFactory sqlSessionFactory() throws Exception{ // mybatis세팅
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        return sqlSessionFactoryBean.getObject();
    }// p.92참고해서 테스트진행

    @Bean //mybatis연결
    public DataSource dataSource(){
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/springdb");
        config.setUsername("springuser");
        config.setPassword("springuser");

        HikariDataSource dataSource = new HikariDataSource(config);

        return dataSource;
    }

    @Bean(name = "names")
    public ArrayList<String> names(){ // 예전에 xml로 설정했던 것을 메서드로 만들고 @Bean을 걸어서 객체로 생성해줌

        ArrayList<String> list = new ArrayList<>();
        list.add("AAA");
        list.add("BBB");
        list.add("CCC");
        return list;

    }
}

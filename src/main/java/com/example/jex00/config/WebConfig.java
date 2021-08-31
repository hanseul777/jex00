package com.example.jex00.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Log4j2
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {//루트설정

        log.info("1-----------------------");
        log.info("1-----------------------");

        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {//서블릿설정

        log.info("2-----------------------");
        log.info("2-----------------------");//정상적으로 설정이 완료되면 로그가 찍히는 것.

        return new Class[]{ServletConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"}; //FrontController를 통해 다른 Controller로 들어갈 수 있게 하는 메서드 : 아직 경로 미완성
    }
}

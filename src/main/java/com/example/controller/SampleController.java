package com.example.controller;


import com.example.dto.BoardDTO;
import com.example.service.Hello;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;

@Controller
@Log4j2
public class SampleController {

    @Autowired
    private Hello hello;

    @GetMapping("/doA")
    public void doA(String name, int age){ //파리미터주입 ( web의 주소창에서 쿼리문을 이용해 파라미터를 주입하면 그 값이 로그로 출력)
        log.info("doA..................");
        log.info(name);
        log.info(age);
    }

    @GetMapping("/doB")
    public void doB(String name, int[] arr){
        log.info("doA..................");
        log.info(name);
        log.info(Arrays.toString(arr));
    }

    @GetMapping("/doC")
    //jsp를 사용해야할 경우에는 Model을 파라미터로 던져준다
    public void doC(BoardDTO boardDTO, Model model){ //파라미터만 던져도 스프링이 알아서 수집해준다

        log.info("doC..................");
        log.info(boardDTO);
        model.addAttribute("bno", 32L);//request.setAttribute의 역할을 해줌
    }

    @GetMapping("/doD")
    public String doD(RedirectAttributes redirectAttributes){ //redirect할 때 속성을 지정
        //hello 페이지에 redirect사용
        log.info("----------------doD------------------");
        log.info("----------------doD------------------");
        log.info("----------------doD------------------");
        redirectAttributes.addFlashAttribute("bno",321); //addFlashAttribute일회성으로 사용할 때
        return "redirect:/hello"; //redirect:로 시작해서 뒤에 url을 붙여준다. -> doD를 호출하면 redirect해서 hello가 호출
    }

    @GetMapping("/hello")
    public void hello(){

        log.info("hello................................");
        log.info("hello................................");
        log.info(hello);
        log.info("hello................................");
        log.info("hello................................");

    }
}

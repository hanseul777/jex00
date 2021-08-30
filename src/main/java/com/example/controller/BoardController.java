package com.example.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/*") //board로 시작하는 모든 request는 이 controller를 거친다
@Log4j2
public class BoardController {

    @GetMapping("/list")//get방식으로 들어오면 동작  -> 이 메서드의 경로는 : board/list
    public void list(){ //void를 사용하면 자동으로 해당 URL의 jsp파일을 찾아감 (list.jsp를 찾아간다.) 따로 설정해줄 필요 없음
        log.info("list...........................");
        log.info("list...........................");
        log.info("list...........................");
        log.info("list...........................");
    }
}

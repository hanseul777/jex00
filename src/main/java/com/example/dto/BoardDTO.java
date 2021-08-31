package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data //getter,setter,toString다 생성해주는 어노테이션
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {

    private Long bno;
    private String title;
    private String content;
    private String writer;

//    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") //MM : Month , mm : minute
    //LocalDateTime은 피할 수 있으면 피하는게 좋다. 현재시간 같은 경우는 now()사용해서 db로 받아올 수 있음.
    //시간값의 파라미터 수집은 일반적인 파라미터 수집과 달라서 어렵다. form태그로 한 번에 묶을 수 없다.
    private LocalDateTime regDate;
    private LocalDateTime modDate;
}

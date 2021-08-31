package com.example.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

    @Select("select now()")
    String getTime(); // getTime()을 실행하면서 select문을 실행하는 것
}

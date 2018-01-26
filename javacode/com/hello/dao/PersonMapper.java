package com.hello.dao;

import com.hello.domain.Person;

import java.util.List;

public interface PersonMapper {
    int insert(Person record);
    int insertSelective(Person record);
    List queryAll();
    void set();
}
package com.hello.service;

import com.hello.domain.Person;

import java.util.List;

/**
 * Created by lenovo on 2017/4/3.
 */
public interface PersonService {
    public List geAllPerson();
    public void addPerson(Person p1, Person p2);
}

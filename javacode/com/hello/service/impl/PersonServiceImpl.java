package com.hello.service.impl;

import com.hello.dao.PersonMapper;
import com.hello.domain.Person;
import com.hello.service.PersonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2017/4/3.
 */
@Transactional
@Service("personService")
public class PersonServiceImpl  implements PersonService{

   @Resource
    private PersonMapper pm;
    public List geAllPerson(){
        return pm.queryAll();

    }

    public void addPerson(Person p1, Person p2){
        pm.insert(p1);
        pm.insert(p2);
    }
}

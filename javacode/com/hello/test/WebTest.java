package com.hello.test;

import com.hello.service.PersonService;
import com.wuhy.basedao.AbstractDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by lenovo on 2017/4/3.
/* */
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:app-context.xml"})
public class WebTest {
   @Resource
    private PersonService personService = null;
    private ClassPathXmlApplicationContext ApplicationContextac;
    @Resource
    private AbstractDao absDao;

   /* @Before
  public void before() {
        ApplicationContextac = new ClassPathXmlApplicationContext("applicationContext.xml");
      userService = (IUserService) ac.getBean("userService");
  }*/

    @Test
    public void test1() {
       // ApplicationContextac = new ClassPathXmlApplicationContext("app-context.xml");
      //  personService= (PersonService) ApplicationContextac.getBean("personService");
     //  List user = personService.geAllPerson();

       /* Person p1=new Person(8,"11","waw");
        Person p2=new Person(9,"11","waw");
        personService.addPerson(p1,p2);*/
        absDao.getTotal("");
    }
    }

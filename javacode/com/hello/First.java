package com.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lenovo on 2017/3/31.
 */
public class First extends Zroe{

    private String name;
    public void setName(String name){
        this.name = name;
    }

    public void hello(){
        System.out.print(name+"say hello");
    }

}

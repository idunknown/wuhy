package com.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lenovo on 2017/3/31.
 */
public class Test {

    public static void main(String[] args) {

        //1.创建spring的IOC容器对象，Application会调用无参构造器来初始化并且调用set方法来赋值。
        //ClassPathXmlApplicationContext是Application的接口的实现。从类路径下读取配置文件。
        ApplicationContext acx = new ClassPathXmlApplicationContext("app-context.xml");
        //2.从IOC容器中获取bean。
        //利用Id定位到IOC容器中的Bean
        Second  second = (Second) acx.getBean("second");
        //HelloWorld hellSoworld = acx.getBean(HelloWorld.class);
        //利用类型返回IOC容器中的bean，但要求是在IOC容器中只有一个该类型的bean。
        //3.调用方法。
       // ((First)second.get()).hello();
    }
}

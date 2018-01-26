package com.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2017/3/31.
 */
@Controller
@RequestMapping("/h")
public class HelloWorld {
    @RequestMapping("/hello")
    public String test() {
        Map m=new HashMap<>();
        m.put("nihao","nihao");
        m.put("hh",new Date());
       // return "hello, world! This com from spring!";
        return "/a";
    }
}

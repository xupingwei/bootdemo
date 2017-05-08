package com.xaaolaf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xupingwei on 2017/5/3.
 */
@RestController
public class HelloController {

//    @RequestMapping(name = "index")
//    public String index() {
//        return "Hello world!";
//    }


    @RequestMapping(name = "/say")
    public String say() {

        return ("Say xHello world!");
    }

}

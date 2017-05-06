package com.xaaolaf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xupingwei on 2017/5/3.
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @RequestMapping(value = "/index")
    public String index() {
        return "Hello world!";
    }


    @RequestMapping(value = "/say")
    public String say() {

        return new String("say Hello world!");
    }

}

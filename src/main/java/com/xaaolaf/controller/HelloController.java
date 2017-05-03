package com.xaaolaf.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by xupingwei on 2017/5/3.
 */
@Controller
public class HelloController {

//    @RequestMapping(name = "index")
//    public String index() {
//        return "Hello world!";
//    }


    @RequestMapping(name = "/say")
    public ModelAndView say() {

        return new ModelAndView("Hello world!");
    }

}

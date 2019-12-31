package com.exbyte.mvcboard.tutorial.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StringController {

    private static final Logger logger = LoggerFactory.getLogger(StringController.class);

    @RequestMapping("/doB")
    public String doC(@ModelAttribute("msg") String msg){
        logger.info("/doB called...");
        msg = "Msg test";
        return "tutorial/doB";
    }
}

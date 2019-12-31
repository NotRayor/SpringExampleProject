package com.exbyte.mvcboard.tutorial.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VoidController {
    private static final Logger logger = LoggerFactory.getLogger(VoidController.class);

    @RequestMapping("/doVoid")
    public void doVoid(){
        logger.warn("/doVoid called..");
        logger.warn("정상적으로 동작.");
    }

}

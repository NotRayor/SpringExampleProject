package com.exbyte.mvcboard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String managerBoard(){

        return "";
    }
}

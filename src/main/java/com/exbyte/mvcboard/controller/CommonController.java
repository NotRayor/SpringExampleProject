package com.exbyte.mvcboard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommonController {
    private static Logger logger = LoggerFactory.getLogger(CommonController.class);

    @RequestMapping({"/index", "/"})
    String indexGET(){
        logger.info("indexGET... ");
        return "/commons/index";
    }

    @RequestMapping(value = "/sample", method = RequestMethod.GET)
    public String sampleGET(){
        logger.info("sample GET...");
        return "/commons/sample";
    }

}

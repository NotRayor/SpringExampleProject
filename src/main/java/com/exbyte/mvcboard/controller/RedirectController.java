package com.exbyte.mvcboard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {

    private static final Logger logger = LoggerFactory.getLogger(VoidController.class);

    @RequestMapping("/doD")
    public String doD(RedirectAttributes redirectAttributes){
        logger.info("/doD called..");
        redirectAttributes.addAttribute("msg", "working redirect...");

        return "redirect:/doE";
    }

    @RequestMapping("/doE")
    public void doE(@ModelAttribute String msg ){
        logger.info("/doE called.." + msg);
    }

}

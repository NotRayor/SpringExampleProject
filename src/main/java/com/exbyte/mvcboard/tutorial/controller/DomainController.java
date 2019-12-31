package com.exbyte.mvcboard.tutorial.controller;

import com.exbyte.mvcboard.tutorial.domain.ProductVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DomainController {

    private static final Logger logger = LoggerFactory.getLogger(VoidController.class);

    @RequestMapping("/doC")
    public String doC(Model model){
        logger.info("/doC called..");

        ProductVO product = new ProductVO("computer", 2000);
        logger.info("/doC called");
        model.addAttribute(product);

        return "/tutorial/product_detail";
    }

}

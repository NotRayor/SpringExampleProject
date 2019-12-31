package com.exbyte.mvcboard.tutorial.controller;

import com.exbyte.mvcboard.tutorial.domain.ProductVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonController {

    @RequestMapping("/doF")
    @ResponseBody
    public ProductVO doJson(){
        ProductVO productVO = new ProductVO("laptop", 300000);
        return productVO;
    }

}

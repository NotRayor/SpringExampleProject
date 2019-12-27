package com.exbyte.mvcboard.controller;

import com.exbyte.mvcboard.domain.ProductVO;
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
package com.exbyte.mvcboard.tutorial.controller;


import com.exbyte.mvcboard.tutorial.domain.SampleVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/ajax/test")
public class AjaxController {

    @RequestMapping("/hello")
    String sayHello(){
        return "hello";
    }

    @RequestMapping("/sendVO")
    public SampleVO sendVO(){

        SampleVO sample = new SampleVO();
        sample.setSampleNo(1);
        sample.setFirstName("더블");
        sample.setLastName("이지");

        return sample; // 객체는 JSON 데이터로 전달된다.
    }

    @RequestMapping("/sendVOList")
    public ResponseEntity<List<SampleVO>> sendListNot(){

        List<SampleVO> samples = new ArrayList<SampleVO>();

        for(int i = 0; i < 10; i++){
            SampleVO sampleVO = new SampleVO();
            sampleVO.setSampleNo(i);
            sampleVO.setFirstName("더블");
            sampleVO.setLastName("이지");
            samples.add(sampleVO);
        }

        return new ResponseEntity<>(samples, HttpStatus.NOT_FOUND);
    }
}

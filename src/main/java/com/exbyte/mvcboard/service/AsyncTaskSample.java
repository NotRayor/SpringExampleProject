package com.exbyte.mvcboard.service;

import com.exbyte.mvcboard.domain.ArticleVO;
import com.exbyte.mvcboard.persistence.ArticleDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service("asyncTaskSample")
public class AsyncTaskSample {
    Logger logger = LoggerFactory.getLogger(AsyncTaskSample.class);

    @Inject
    ArticleDAO articleDAO;

    @Async("executorSample")
    public void executorSample(String str) throws Exception{
        logger.info(">>> THREAD START");
        // 내용
        ArticleVO articleVO = new ArticleVO();
        articleVO.setTitle("번째 글 제목");
        articleVO.setContent("번째 글 내용");
        articleVO.setWriter("번째 글 작성자");
        articleDAO.create(articleVO);
        logger.info(">>> THREAD END");

    }

    @Async("executorSample")
    public void executorSample2(String str){
        logger.info(">>> THREAD START");
        // 내용
        logger.info(">>> THREAD END");

    }
}

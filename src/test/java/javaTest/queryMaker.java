package javaTest;


import jdbcTest.ArticleDAOTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/webapp/WEB-INF/spring-config/applicationContext.xml")
public class queryMaker {

    private static final Logger logger = LoggerFactory.getLogger(ArticleDAOTest.class);

    @Test
    public void queryMakerTest1(){
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .path("/article/read")
                .queryParam("articleNo", 100)
                .queryParam("perPageNum", 30)
                .build();

        logger.info(uriComponents.toString());
    }

    @Test
    public void queryMakerTest2(){
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .path("/{module}/{page1}/{page2}")
                .queryParam("articleNo", 100)
                .queryParam("perPageNum", 30)
                .build()
                .expand("article","read","loading")
                .encode();

        logger.info(uriComponents.toString());
    }
}

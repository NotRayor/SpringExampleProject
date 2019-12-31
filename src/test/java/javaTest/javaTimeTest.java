package javaTest;

import com.exbyte.mvcboard.article.domain.ArticleVO;
import com.exbyte.mvcboard.article.persistence.ArticleDAO;
import jdbcTest.ArticleDAOTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/webapp/WEB-INF/spring-config/applicationContext.xml")
public class javaTimeTest {

    private static final Logger logger = LoggerFactory.getLogger(ArticleDAOTest.class);

    @Inject
    private ArticleDAO articleDAO;

    @Test
    public void testRead() throws Exception{
        ArticleVO article = articleDAO.read(18);
        Date date = article.getRegDate();
        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat ( "yyyy.MM.dd HH:mm:ss", Locale.KOREA );
        Date currentTime = new Date ( );
        String dTime = formatter.format ( currentTime );

        logger.info("currentTime : " + currentTime + " " + dTime + " " + date);
        logger.info(articleDAO.read(18).toString());
    }


}

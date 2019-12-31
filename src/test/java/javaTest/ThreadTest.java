package jdbcTest;

import com.exbyte.mvcboard.article.commons.thread.AsyncConfig;
import com.exbyte.mvcboard.article.persistence.ArticleDAO;
import com.exbyte.mvcboard.tutorial.service.AsyncTaskSample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.task.TaskRejectedException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/webapp/WEB-INF/spring-config/applicationContext.xml")
public class ThreadTest {

    private static final Logger logger = LoggerFactory.getLogger(ArticleDAOTest.class);

    @Inject
    private ArticleDAO articleDAO;

    @Resource(name = "asyncTaskSample")
    private AsyncTaskSample asyncTaskSample;

    /** AsyncConfig */
    @Resource(name = "asyncConfig")
    private AsyncConfig asyncConfig;


    @Test
    public void testCreate() throws Exception{

        try {
            // 등록 가능 여부 체크
            if (asyncConfig.isSampleTaskExecute()) {
                // task 사용
                asyncTaskSample.executorSample("start");
            } else {
                System.out.println("==============>>>>>>>>>>>> THREAD 개수 초과");
            }
        } catch (TaskRejectedException e) {
            // TaskRejectedException : 개수 초과시 발생
            System.out.println("==============>>>>>>>>>>>> THREAD ERROR");
            System.out.println("TaskRejectedException : 등록 개수 초과");
            System.out.println("==============>>>>>>>>>>>> THREAD END");
        }


    }

    /* CRUD 동작 테스트
    @Test
    public void testCase() throws Exception{
        ArticleVO articleVO = new ArticleVO();
        articleVO.setTitle("새로운 글 작성 테스트 제목");
        articleVO.setContent("새로운 글 작성 테스트 내용");
        articleVO.setWriter("새로운 글 작성 작성자 이름");
        articleDAO.create(articleVO);
    }

    @Test
    public void testRead() throws Exception{
        ArticleVO article = articleDAO.read(2);
        Date date = article.getRegDate();


        logger.info(Instant.now().toString());
        logger.info(articleDAO.read(18).toString());
    }

    @Test
    public void testUpdate() throws Exception{
        ArticleVO articleVO = new ArticleVO();
        articleVO.setArticleNo(2);
        articleVO.setTitle("글 수정 텍스트 제목");
        articleVO.setContent("글 수정 텍스트 내용");
        articleDAO.update(articleVO);
    }

    @Test
    public void testDelete() throws Exception{
        articleDAO.delete(1);
    }

    */

}

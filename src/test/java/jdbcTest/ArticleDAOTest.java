package jdbcTest;

import com.exbyte.mvcboard.article.commons.paging.Criteria;
import com.exbyte.mvcboard.article.commons.paging.SearchCriteria;
import com.exbyte.mvcboard.article.domain.ArticleVO;
import com.exbyte.mvcboard.article.persistence.ArticleDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/webapp/WEB-INF/spring-config/applicationContext.xml")
public class ArticleDAOTest {

    private static final Logger logger = LoggerFactory.getLogger(ArticleDAOTest.class);

    @Inject
    private ArticleDAO articleDAO;

    @Test
    public void testDynamic1() throws Exception{
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setPage(1);
        searchCriteria.setKeyword("999");
        searchCriteria.setSearchType("t");

        logger.info("searched articles Count : " + articleDAO.countSearchedArticles(searchCriteria));


        List<ArticleVO> articleVOList = articleDAO.listSearch(searchCriteria);

        for(ArticleVO articleVO : articleVOList){
            logger.info(articleVO.getArticleNo() + ":" + articleVO.getTitle());
            logger.info(articleVO.toString());
        }
    }

    @Test
    public void testPaging() throws Exception{
        Criteria criteria = new Criteria();
        criteria.setPage(3);
        criteria.setPerPageNum(20);

        List<ArticleVO> articleVOList = articleDAO.listCriteria(criteria);

        for(ArticleVO article : articleVOList){
            logger.info(article.toString());
        }


    }

    @Test
    public void testCount() throws Exception{
        logger.info("totalPageNum = " + articleDAO.countArticle());
    }
    /* 더미 데이터 생성
    @Test
    public void testCreate() throws Exception{

        for(int i = 1; i <= 100; i++){
            ArticleVO articleVO = new ArticleVO();
            articleVO.setTitle(i + "번째 글 제목");
            articleVO.setContent(i + "번째 글 내용");
            articleVO.setWriter(i + "번째 글 작성자");
            articleDAO.create(articleVO);
        }

    }

    */

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

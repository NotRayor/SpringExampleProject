package jdbcTest;

import com.exbyte.mvcboard.article.commons.paging.Criteria;
import com.exbyte.mvcboard.reply.domain.ReplyVO;
import com.exbyte.mvcboard.reply.persistence.ReplyDAO;
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
public class ReplyDAOTest {
    private static final Logger logger = LoggerFactory.getLogger(ReplyDAOTest.class);

    @Inject
    private ReplyDAO replyDAO;

    @Test
    public void ReplyDAOCreateTest() throws Exception{
        for(int i = 1; i <= 10; i++){
            ReplyVO replyVO = new ReplyVO();
            replyVO.setArticleNo(45);
            replyVO.setReplyText(i+"번째 댓글");
            replyVO.setReplyWriter(i+"번째 사람");
            replyDAO.create(replyVO);
        }
    }

    @Test
    public void ReplyDAOListTest() throws Exception{
        logger.info(replyDAO.list(45).toString());

    }

    @Test
    public void ReplyDAOUpdate() throws Exception{
        ReplyVO replyVO = new ReplyVO();
        replyVO.setReplyNo(2);
        replyVO.setReplyText("수정된 내용2");
        replyDAO.update(replyVO);
    }

    @Test
    public void ReplyDAODelete() throws Exception{
        replyDAO.delete(3);
    }

    @Test
    public void ReplyDAOPaging() throws Exception{
        Criteria criteria = new Criteria();
        criteria.setPage(1);
        criteria.setPerPageNum(10);
        List<ReplyVO> list = replyDAO.listPaging(45, criteria);
        for(ReplyVO reply : list){
            logger.info(reply.toString());
        }
    }

    @Test
    public void ReplyDAOCount() throws Exception{
        logger.info("countReply : " + replyDAO.countReply(45));
    }
}

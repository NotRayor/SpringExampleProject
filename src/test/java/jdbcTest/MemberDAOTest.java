package jdbcTest;

import com.exbyte.mvcboard.tutorial.domain.MemberVO;
import com.exbyte.mvcboard.tutorial.persistence.MemberDAO;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/webapp/WEB-INF/spring-config/applicationContext.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberDAOTest {

    private static final Logger logger = LoggerFactory.getLogger(ArticleDAOTest.class);

    @Inject
    private MemberDAO memberDAO;

    @Test
    public void testA() throws Exception{
        MemberVO memberVO = new MemberVO();
        memberVO.setUserid("새로운 아이디");
        memberVO.setUserpw("새로운 비밀번호");
        memberVO.setUsername("새로운 이름");
        memberVO.setEmail("새로운 이메일");
        memberDAO.create(memberVO);
    }

    @Test
    public void testB() throws Exception{
        logger.info(memberDAO.read("새로운 아이디").toString());
    }

    @Test
    public void testC() throws Exception{
        logger.info(memberDAO.readWithPassword("새로운 아이디", "새로운 비밀번호").toString());
    }

    @Test
    public void testD() throws Exception{
        MemberVO memberVO = new MemberVO();

        memberVO.setUserid("새로운 아이디");
        memberVO.setUserpw("변경된 비밀번호");
        memberVO.setUsername("변경된 이름");
        memberVO.setEmail("변경된 이메일");
        memberDAO.update(memberVO);
    }

    @Test
    public void testE() throws Exception{
        memberDAO.delete("새로운 아이디");
    }
}

package jdbcTest;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "file:src/webapp/WEB-INF/spring-config/**/*.xml")
public class MyBatisConnectorTest {

    private Logger logger = LoggerFactory.getLogger(MyBatisConnectorTest.class);

    @Inject
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void testFactory(){
        System.out.println(sqlSessionFactory);
    }

    @Test
    public void testSession() throws Exception {
        try(SqlSession session = sqlSessionFactory.openSession()){
            System.out.println(session);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

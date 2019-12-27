import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import javax.sql.DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
public class DataSourceTest {


    @Test
    public void test() {
        try{
            System.out.println("hi");
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}

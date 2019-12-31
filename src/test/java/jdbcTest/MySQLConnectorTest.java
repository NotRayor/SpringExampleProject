package jdbcTest;

import com.exbyte.mvcboard.tutorial.domain.ManagerVO;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;


public class MySQLConnectorTest {
    private final String URL = "jdbc:mysql://127.0.0.1:3306/project?useSSL=false&serverTimezone=UTC";
    private final String USER = "RAYOR";
    private final String PASSWORD = "1";

    @Test
    public void testConnection() throws Exception {
        Connection conn = null;
        PreparedStatement pstmt;
        ResultSet rs;

        ArrayList<ManagerVO> list = new ArrayList<ManagerVO>();

        try{
            conn = DriverManager.getConnection(URL, USER, PASSWORD);;
            assertNotNull(conn);
            System.out.println(conn);

            String sql = "SELECT * FROM manager";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()){
                ManagerVO manager = new ManagerVO();
                manager.setId(rs.getString(1));
                manager.setName(rs.getString(2));
                list.add(manager);
            }

            for(ManagerVO manager : list){
                System.out.println(manager.getId());
                System.out.println(manager.getName());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            conn.close();
        }

    }


}

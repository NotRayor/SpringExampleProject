import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.inject.Inject;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/webapp/WEB-INF/spring-config/**/*.xml"})
public class ControllerTest {

    private Logger logger = LoggerFactory.getLogger(ControllerTest.class);


    @Inject
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build(); //
        logger.info("setup...");
    }

    @Test
    public void testDoA() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/doVoid"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testDoB() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/doB?msg=testDoBTestString"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testDoC() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/doC"))
                .andDo(print()).andExpect(status().isOk()).andExpect(model().attributeExists("productVO"));
    }

    @Test
    public void testDoD() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/doD"))
                .andDo(print()).andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("/doE?msg=working+redirect..."));
    }

    @Test
    public void testDoF() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/do"))
                .andDo(print()).andExpect(status().isOk()).andExpect(content().contentType("application/json;charset=UTF-8"));
    }
}

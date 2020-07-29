package demo;

import demo.domain.DemoProperties;
import demo.web.HelloController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
@AutoConfigureMockMvc
public class Chapter1ApplicationTests {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testGetHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello World!"));
        HelloController helloController=new HelloController();
        helloController.index();
        DemoProperties dp=new DemoProperties();
        dp.setAuthor("mark");
        dp.getAuthor();
        System.out.println("helloController");
    }

    @Autowired
    private DemoProperties properties;

    @Test
    public void testDemoProperties() throws Exception{
        Assert.assertEquals(properties.getAuthor(), "Manulife Chengdu");
        Assert.assertEquals(properties.getTitle(), "SpringBoot QuickStart Demo");
        Assert.assertEquals(properties.getDesc(), properties.getAuthor() + " is writting " + properties.getTitle());
    }
}

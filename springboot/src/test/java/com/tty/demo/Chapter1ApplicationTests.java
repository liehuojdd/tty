package com.tty.demo;

import com.tty.demo.domain.DemoProperties;
import com.tty.demo.web.HelloController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.reactive.server.StatusAssertions;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import org.springframework.boot.test.SpringApplicationConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class Chapter1ApplicationTests {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testGetHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello World!"));
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

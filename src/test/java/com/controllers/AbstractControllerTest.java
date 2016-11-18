package com.controllers;

import com.TestConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Created by Oleksandr on 11/10/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ControllerConfig.class, TestConfig.class})
@WebAppConfiguration
public abstract class AbstractControllerTest {

    protected MockMvc mockMvc;

    protected void initBaseController(Object controller) {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
}

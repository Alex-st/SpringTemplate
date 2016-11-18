package com;

import com.services.UserService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Oleksandr on 11/14/2016.
 */
@Configuration
public class TestConfig {

    @Bean
    public UserService mockedService() {
        return Mockito.mock(UserService.class);
    }
}

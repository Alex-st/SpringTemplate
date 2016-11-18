package com.controllers;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Oleksandr on 11/14/2016.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.controllers")
public class ControllerConfig {

}

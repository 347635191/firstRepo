package com.example.learn_nacos.nacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lufei
 */
@Controller
@RequestMapping("config")
public class ConfigController {

    @Value("${server.port}")
    String port;

    @Value("${app.name}")
    String name;

    private final ConfigurableApplicationContext applicationContext;

    public ConfigController(ConfigurableApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public String get() {
        System.out.println(applicationContext.getEnvironment().getProperty("test.method"));
        System.out.println(applicationContext.getEnvironment().getProperty("test.server"));
        System.out.println(applicationContext.getEnvironment().getProperty("test.language"));
        return applicationContext.getEnvironment().getProperty("app.name");
    }
}

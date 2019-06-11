package com.daelly.sample.eureka.producer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${server.node.name:none}")
    private String node;

    @RequestMapping("/hello")
    public String hello(@RequestParam String name) {
        return "hello " + name + ", this is first message from " + node;
    }
}

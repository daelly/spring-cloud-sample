package com.daelly.sample.eureka.consumer.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/ribbon")
public class HelloRibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        return restTemplate.getForObject("http://spring-cloud-producer/hello?name={1}", String.class, name);
    }
}

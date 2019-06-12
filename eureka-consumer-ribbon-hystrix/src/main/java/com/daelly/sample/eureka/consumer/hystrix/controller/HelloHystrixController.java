package com.daelly.sample.eureka.consumer.hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/hystrix")
public class HelloHystrixController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hello/{name}")
    @HystrixCommand(fallbackMethod = "helloFallback")
    public String hello(@PathVariable("name") String name) {
        return restTemplate.getForObject("http://spring-cloud-producer/hello?name={1}", String.class, name);
    }

    public String helloFallback(String name) {
        return "error";
    }
}

package com.daelly.sample.eureka.consumer.controller;

import com.daelly.sample.eureka.consumer.client.HelloFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
public class HelloFeignController {

    @Autowired
    private HelloFeignClient helloFeignClient;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        return helloFeignClient.hello(name);
    }
}

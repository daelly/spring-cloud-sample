package com.daelly.sample.eureka.consumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("spring-cloud-producer")
public interface HelloFeignClient {

    @GetMapping("/hello")
    String hello(@RequestParam String name);
}

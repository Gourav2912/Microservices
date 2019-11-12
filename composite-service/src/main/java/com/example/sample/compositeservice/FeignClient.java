package com.example.sample.compositeservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@org.springframework.cloud.openfeign.FeignClient(name="core-service")
public interface FeignClient {

    @GetMapping("/users/{userId}")
    public String getUser(@PathVariable String userId);


}

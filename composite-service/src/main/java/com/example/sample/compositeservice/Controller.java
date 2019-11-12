package com.example.sample.compositeservice;



import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@RestController
@RequestMapping("/composite")
public class Controller {

    @Autowired
    public Controller(FeignClient feignClient) {
        this.feignClient = feignClient;
    }

    /* @Autowired
        private RestTemplate  restTemplate;*/
   private FeignClient feignClient;




   @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping(path = "/{UserId}",produces = APPLICATION_JSON_VALUE)
    public String getUser(@PathVariable String UserId){

       //String result= restTemplate.getForObject("http://CORE-SERVICE/users/"+UserId,String.class);
       String result = feignClient.getUser(UserId);

        return  result;
    }
    public String fallback(String UserId){

        return "This is fall back";
    }
}




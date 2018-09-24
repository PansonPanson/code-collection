package com.panson.springcloud.weather.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.panson.springcloud.weather.service.CityClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Package: com.panson.springcloud.weather.controller
 * Description：
 * Author: Panson
 */
@RestController
@EnableFeignClients
public class CityController {

    @Autowired
    private CityClient cityClient;

    @GetMapping("/cities")
    @HystrixCommand(fallbackMethod = "defaultCities")
    public String listCity() {
        // 通过feign客户端来查找
        String body = cityClient.listCity();
        return body;
    }

    public String defaultCities() {
        return "City Data Server is down!";
    }

}

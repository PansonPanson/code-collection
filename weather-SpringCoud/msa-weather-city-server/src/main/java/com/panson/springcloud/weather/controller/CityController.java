package com.panson.springcloud.weather.controller;

import com.panson.springcloud.weather.Service.CityDataService;
import com.panson.springcloud.weather.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Package: com.panson.springcloud.weather.controller
 * Description：
 * Author: Panson
 */
@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityDataService cityDataService;

    @GetMapping
    public List<City> listCity() throws Exception{
        return cityDataService.listCity();
    }
}

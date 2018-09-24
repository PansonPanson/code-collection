package com.panson.springcloud.weather.Service;

import com.panson.springcloud.weather.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Package: com.panson.springcloud.weather.Service
 * Description：
 * Author: Panson
 */
@FeignClient("msa-weather-city-eureka")
public interface CityClient {

    @GetMapping("/cities")
    List<City> listCity() throws Exception;
}

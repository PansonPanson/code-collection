package com.panson.springcloud.weather.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.panson.springcloud.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * Package: com.panson.springcloud.weather.Service
 * Description：
 * Author: Panson
 */
@Service

public class WeatherDataServiceImpl implements WeatherDataService {

    private static final String WHEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WHEATHER_URI + "citykey=" + cityId;
        return this.doGetWeather(uri);

    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WHEATHER_URI + "city=" + cityName;
        return this.doGetWeather(uri);
    }

    private WeatherResponse doGetWeather(String uri) {
        WeatherResponse resp = null;
        ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);
        // 使用jackson
        ObjectMapper mapper = new ObjectMapper();
        String strBody = null;
        if (respString.getStatusCodeValue() == 200) {
            strBody = respString.getBody();
        }
        try {
            resp = mapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resp;

    }
}

package com.panson.springcloud.weather.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.panson.springcloud.weather.vo.WeatherResponse;
import org.omg.CORBA.TIMEOUT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Package: com.panson.springcloud.weather.Service
 * Description：
 * Author: Panson
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    private final static Logger logger = LoggerFactory.getLogger(WeatherDataService.class);
    private static final String WHEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
    private static final long TIME_OUT = 1800L;// 半小时刷新一次

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

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

        String key = uri;
        String strBody = null;
        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse resp = null;
        ValueOperations<String,String> ops = stringRedisTemplate.opsForValue();
        // 先查缓存，缓存有的取缓存中的数据
        if (stringRedisTemplate.hasKey(key)) {
            logger.info("Redis has data");
            strBody = ops.get(key);
        } else {
            logger.info("Redis doesn't have data");
            // 缓存没有，再调用服务接口来获取
            ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);
            // 使用jackson
            if (respString.getStatusCodeValue() == 200) {
                strBody = respString.getBody();
            }
            // 把数据写入缓存
            ops.set(key, strBody, TIME_OUT, TimeUnit.SECONDS );
        }

        try {
            resp = mapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            logger.error("Error!",e);
        }
        return resp;

    }
}

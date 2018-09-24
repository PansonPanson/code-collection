package com.panson.springcloud.weather.Service;

import com.panson.springcloud.weather.vo.Weather;
import com.panson.springcloud.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Package: com.panson.springcloud.weather.Service
 * Description：
 * Author: Panson
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private DataClient dataClient;

    @Override
    public Weather getDataByCityId(String cityId) {
        // 由天气数据API微服务来提供
        WeatherResponse response = dataClient.getDataByCityId(cityId);
        Weather data = response.getData();
        return data;
    }

}

package com.panson.springcloud.weather.Service;

import com.panson.springcloud.weather.vo.Weather;

/**
 * Package: com.panson.springcloud.weather.Service
 * Description：
 * Author: Panson
 */
public interface WeatherReportService {

    Weather getDataByCityId(String cityId);
}

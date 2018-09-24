package com.panson.springcloud.weather.Service;

/**
 * Package: com.panson.springcloud.weather.Service
 * Description：
 * Author: Panson
 */
public interface WeatherDataCollectionService {

    /**
     * 根据城市ID同步天气
     * @param CityId
     */
    void syncDateByCityId(String CityId);
}

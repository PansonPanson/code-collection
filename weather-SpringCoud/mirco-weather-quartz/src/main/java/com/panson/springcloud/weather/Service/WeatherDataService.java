package com.panson.springcloud.weather.Service;

import com.panson.springcloud.weather.vo.WeatherResponse;

/**
 * Package: com.panson.springcloud.weather.Service
 * Description：天气数据接口
 * Author: Panson
 */
public interface WeatherDataService {
    /**
     * 根据城市ID查询天气数据
     *
     * @param cityId
     * @return
     */
    WeatherResponse getDataByCityId(String cityId);

    /**
     * 根据城市名称查询天气数据
     *
     * @param cityName
     * @return
     */
    WeatherResponse getDataByCityName(String cityName);

    /**
     * 根据城市ID来同步天气
     * @param cityId
     */
    void syncDateByCityId(String cityId);

}

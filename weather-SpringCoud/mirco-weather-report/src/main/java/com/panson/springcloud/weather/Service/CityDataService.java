package com.panson.springcloud.weather.Service;


import com.panson.springcloud.weather.vo.City;

import java.util.List;

/**
 * Package: com.panson.springcloud.weather.Service
 * Description：
 * Author: Panson
 */



public interface CityDataService {

    /**
     * 获取City列表
     * @return
     * @throws Exception
     */
    List<City> listCity() throws Exception;
}

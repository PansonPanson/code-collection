package com.panson.springcloud.weather.job;

import com.panson.springcloud.weather.Service.CityClient;
import com.panson.springcloud.weather.Service.WeatherDataCollectionService;
import com.panson.springcloud.weather.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Package: com.panson.springcloud.weather.job
 * Description：同步天气数据
 * Author: Panson
 */
public class WeatherDataSyncJob extends QuartzJobBean {

    private final static Logger logger = LoggerFactory.getLogger(WeatherDataCollectionService.class);

    @Autowired
    private WeatherDataCollectionService  weatherDataCollectionService;

    @Autowired
    private CityClient cityClient;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        logger.info("Weather Data Sync Job Start");
        // 获取城市ID列表
        // TODO 改为由城市数据API微服务来提供数据
        List<City> cityList = null;
        try {
            // TODO 改为由城市数据API微服务来提供数据
            cityList = new ArrayList<>();
            City city = new City();
            city.setCityId("101280601");
            cityList.add(city);
        } catch (Exception e) {
            logger.error("Exception!", e);
        }
        // 遍历城市ID获取天气
        for (City city : cityList) {
            String cityId = city.getCityId();
            logger.info("Weather Data Sync Job, cityId: " + cityId);
            weatherDataCollectionService.syncDateByCityId(cityId);
        }
        logger.info("Weather Data Sync Job End!");

    }
}

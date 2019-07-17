package com.waylau.spring.cloud.weather.job;

import com.netflix.discovery.converters.Auto;
import com.waylau.spring.cloud.weather.service.CityClient;
import com.waylau.spring.cloud.weather.service.WeatherDataCollectionService;
import com.waylau.spring.cloud.weather.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *  同步天气数据Job
 */
public class WeatherDataSyncJob extends QuartzJobBean {
    private final static Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);


    @Autowired
    private WeatherDataCollectionService weatherDataCollectionService;

    @Autowired
    private CityClient cityClient;

    @Override
    protected void executeInternal(JobExecutionContext context) {
        logger.info("WeatherDataSyncJob start.....");

        // 城市数据API
        List<City> cities = null;
        try {
            cities = cityClient.listCity();
        } catch (Exception e) {
            logger.error("Exception!", e);
        }

        // 遍历cities得到cityId
        for (City city : cities) {
            String cityId = city.getCityId();
            // 打印日志
            logger.info("Weather Data Sync：" + cityId);
            weatherDataCollectionService.syncDataByCityId(cityId);
        }
        logger.info("WeatherDataSyncJob end!!!!");
    }
}

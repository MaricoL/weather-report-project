package com.waylau.spring.cloud.weather.service;

public interface WeatherDataCollectionService {

    // 天气数据同步
    void syncDataByCityId(String cityId);
}

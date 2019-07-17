package com.waylau.spring.cloud.weather.service;

import com.waylau.spring.cloud.weather.vo.WeatherResponse;

public interface WeatherDataService {
    WeatherResponse getDataByCityId(String cityId);

    WeatherResponse getDataByCityName(String cityName);

}

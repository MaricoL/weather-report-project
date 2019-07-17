package com.waylau.spring.cloud.weather.service;

import com.waylau.spring.cloud.weather.vo.Weather;

public interface WeatherReportService {

    Weather getDataByCityId(String cityId);
}

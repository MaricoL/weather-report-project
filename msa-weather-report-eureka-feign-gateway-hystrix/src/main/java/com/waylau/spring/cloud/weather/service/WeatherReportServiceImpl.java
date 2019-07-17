package com.waylau.spring.cloud.weather.service;

import com.waylau.spring.cloud.weather.vo.Weather;
import com.waylau.spring.cloud.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private DataClient dataClient;

    @Override
    public Weather getDataByCityId(String cityId) {
        // 改为由天气数据API微服务来提供
        WeatherResponse response = dataClient.getWeatherByCityId(cityId);
        return response == null ? null : response.getData();
    }
}

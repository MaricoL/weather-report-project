package com.waylau.spring.cloud.weather.service;

import com.waylau.spring.cloud.weather.vo.City;
import com.waylau.spring.cloud.weather.vo.WeatherResponse;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataClientFallBack implements DataClient{
    @Override
    public List<City> listCity() throws Exception {
        City city1 = new City();
        city1.setCityId("101280101");
        city1.setCityName("广州");
        city1.setCityCode("guangzhou");
        city1.setProvine("广东");
        City city2 = new City();
        city2.setCityId("101280102");
        city2.setCityName("番禺");
        city2.setCityCode("panyu");
        city2.setProvine("广东");
        return Arrays.asList(city1, city2);
    }

    @Override
    public WeatherResponse getWeatherByCityId(String cityId) {
        return null;
    }
}

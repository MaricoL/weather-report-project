package com.waylau.spring.cloud.weather.service;

import com.waylau.spring.cloud.weather.vo.City;
import com.waylau.spring.cloud.weather.vo.WeatherResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msa-weather-eureka-client-zuul",fallback = DataClientFallBack.class)
public interface DataClient {

    @GetMapping("/city/cities")
    List<City> listCity() throws Exception;

    @GetMapping("/data/weather/cityId/{cityId}")
    WeatherResponse getWeatherByCityId(@PathVariable("cityId") String cityId);
}

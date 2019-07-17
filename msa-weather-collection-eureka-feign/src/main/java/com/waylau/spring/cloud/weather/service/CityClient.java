package com.waylau.spring.cloud.weather.service;

import com.waylau.spring.cloud.weather.vo.City;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("msa-weather-city-eureka")
public interface CityClient {

    @GetMapping("/cities")
    List<City> listCity() throws Exception;
}

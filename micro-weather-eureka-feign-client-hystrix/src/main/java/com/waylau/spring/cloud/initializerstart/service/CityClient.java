package com.waylau.spring.cloud.initializerstart.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("msa-weather-city-eureka")
public interface CityClient {


    @GetMapping("/cities")
    String listCity();
}

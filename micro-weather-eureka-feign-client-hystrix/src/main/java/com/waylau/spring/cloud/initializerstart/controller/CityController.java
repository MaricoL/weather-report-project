package com.waylau.spring.cloud.initializerstart.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.waylau.spring.cloud.initializerstart.service.CityClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    @Autowired
    private CityClient cityClient;

    @GetMapping("/cities")
    @HystrixCommand(fallbackMethod = "defaultCities")
    public String cityList() {
        return cityClient.listCity();
    }

    public String defaultCities(){
        return "City Client Server is down!!!!";
    }
}

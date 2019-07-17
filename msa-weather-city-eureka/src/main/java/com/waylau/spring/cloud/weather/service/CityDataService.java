package com.waylau.spring.cloud.weather.service;

import com.waylau.spring.cloud.weather.vo.City;

import java.util.List;

public interface CityDataService {

    List<City> listCity() throws Exception;
}

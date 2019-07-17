package com.waylau.spring.cloud.weather.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.waylau.spring.cloud.weather.vo.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Service
public class WeatherDataServiceImpl implements WeatherDataService {
    private final static Logger logger = LoggerFactory.getLogger(WeatherResponse.class);

    public static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        return this.doGetWeather(uri);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_URI + "city=" + cityName;
        return this.doGetWeather(uri);
    }



    private WeatherResponse doGetWeather(String uri) {

        String body = null;
        WeatherResponse weatherResponse = null;
        ObjectMapper mapper = new ObjectMapper();
        ValueOperations<String, String> ops = redisTemplate.opsForValue();

        // 先从Redis中查找数据，如果有则直接取出
        // 如果没有则直接抛出异常
        if (redisTemplate.hasKey(uri)) {
            logger.info("Redis has data!");
            body = ops.get(uri);
        } else {
            logger.info("Redis has no data。。。");
            throw new RuntimeException("Don't has data!");
        }

        try {
            weatherResponse = mapper.readValue(body, WeatherResponse.class);
        } catch (IOException e) {
            logger.error("Error",e);
        }


        return weatherResponse;
    }


}

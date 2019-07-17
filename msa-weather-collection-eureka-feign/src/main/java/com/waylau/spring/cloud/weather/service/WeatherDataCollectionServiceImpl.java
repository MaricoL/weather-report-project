package com.waylau.spring.cloud.weather.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Service
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {
    private final static Logger logger = LoggerFactory.getLogger(WeatherDataCollectionServiceImpl.class);

    public static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    private static final long TIME_OUT = 1800L;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public void syncDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;

        String body = null;
        ValueOperations<String, String> ops = redisTemplate.opsForValue();

        ResponseEntity<String> entity = restTemplate.getForEntity(uri, String.class);

        if (entity.getStatusCodeValue() == 200) {
            body = entity.getBody();
        }
        ops.set(uri, body, TIME_OUT, TimeUnit.SECONDS);
    }


}

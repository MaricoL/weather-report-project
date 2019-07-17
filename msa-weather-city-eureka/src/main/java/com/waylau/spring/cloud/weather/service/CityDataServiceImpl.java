package com.waylau.spring.cloud.weather.service;

import com.waylau.spring.cloud.weather.util.XmlBuilder;
import com.waylau.spring.cloud.weather.vo.City;
import com.waylau.spring.cloud.weather.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class CityDataServiceImpl implements CityDataService{

    @Override
    public List<City> listCity() throws Exception {
        // 1. 读取xml文件
        Resource resource = new ClassPathResource("citylist.xml");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
        StringBuffer stringBuffer = new StringBuffer();

        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            stringBuffer.append(line);
        }

        // 2. 将xml转换成Java对象
       CityList cityList = (CityList) XmlBuilder.xmlStrToObject(CityList.class, stringBuffer.toString());

        return cityList.getCities();
    }
}

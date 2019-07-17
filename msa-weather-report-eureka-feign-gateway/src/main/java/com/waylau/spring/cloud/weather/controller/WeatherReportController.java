package com.waylau.spring.cloud.weather.controller;

import com.waylau.spring.cloud.weather.service.DataClient;
import com.waylau.spring.cloud.weather.service.WeatherReportService;
import com.waylau.spring.cloud.weather.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/report")
public class WeatherReportController {

    @Autowired
    private WeatherReportService weatherReportService;

    @Autowired
    private DataClient dataClient;

    @GetMapping("/cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception {
        model.addAttribute("title", "老卫的天气预报");
        model.addAttribute("cityId", cityId);

        // 由城市数据API来获取数据
        List<City> cityList = dataClient.listCity();

        model.addAttribute("cityList",cityList);
        model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
        return new ModelAndView("weather/report", "reportModel", model);
    }
}

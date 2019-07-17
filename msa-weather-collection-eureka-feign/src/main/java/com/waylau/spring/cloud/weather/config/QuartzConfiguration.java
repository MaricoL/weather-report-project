package com.waylau.spring.cloud.weather.config;

import com.waylau.spring.cloud.weather.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfiguration {
    private static final int TIME = 1; // 更新频率

    // JobDetail
    @Bean
    public JobDetail weatherDataSyncJobDetail() {
        return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDataSyncJob")
                .storeDurably().build();
    }

    // Trigger
    @Bean
    public Trigger weatherDataSyncTrigger() {

        SimpleScheduleBuilder schedBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(TIME).withRepeatCount(1);

        return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDetail())
                .withIdentity("weatherDataSyncTrigger").withSchedule(schedBuilder).build();
    }
}

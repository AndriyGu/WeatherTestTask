package com.example.WeatherTestTask.schedulingtasks;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.WeatherTestTask.WeatherTestTaskApplication;
import com.example.WeatherTestTask.model.ApiKeyHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {



    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


    @Scheduled(cron = "0 0 12 * * ?", zone = "UTC")
    public void reportCurrentTime() {
        int i = 7;
        log.info("The time is now {}", dateFormat.format(new Date()));
        System.out.println("eeeeeeeee");


    }
}

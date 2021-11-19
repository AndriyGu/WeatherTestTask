package com.example.WeatherTestTask.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "Weather")
public class Weather {

    @Id
    private int id;

    private String temp_c;
    private String wind_kph;
    private String humidity;

    @OneToOne
    @JoinColumn(name = "id")
    @MapsId
    private RequestData requestData;

    public Weather() {
    }

    public Weather(String temp_c, String wind_kph, String humidity, RequestData requestData) {
        this.temp_c = temp_c;
        this.wind_kph = wind_kph;
        this.humidity = humidity;
        this.requestData = requestData;
    }

    public int getId() {
        return id;
    }

    public String getTemp_c() {
        return temp_c;
    }

    public void setTemp_c(String temp_c) {
        this.temp_c = temp_c;
    }

    public String getWind_kph() {
        return wind_kph;
    }

    public void setWind_kph(String wind_kph) {
        this.wind_kph = wind_kph;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public RequestData getRequestData() {
        return requestData;
    }

    public void setRequestData(RequestData requestData) {
        this.requestData = requestData;
    }
}

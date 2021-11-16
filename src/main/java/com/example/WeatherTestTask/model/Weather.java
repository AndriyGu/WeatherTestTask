package com.example.WeatherTestTask.model;


import javax.persistence.*;


@Entity
@Table(name = "Weather")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String temp_c;
    private String wind_kph;
    private String humidity;

    private int requestId;

    public Weather() {
    }

    public Weather(String temp_c, String wind_kph, String humidity, int requestId) {
        this.temp_c = temp_c;
        this.wind_kph = wind_kph;
        this.humidity = humidity;
        this.requestId = requestId;
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

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }
}

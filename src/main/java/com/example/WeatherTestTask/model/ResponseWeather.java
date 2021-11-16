package com.example.WeatherTestTask.model;


public class ResponseWeather {

    private Location location;
    private Weather current;
    private BedResponse error;



    public ResponseWeather() {
    }

    public ResponseWeather(Location location, Weather current, BedResponse error) {
        this.location = location;
        this.current = current;
        this.error = error;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Weather getCurrent() {
        return current;
    }

    public void setCurrent(Weather current) {
        this.current = current;
    }

    public BedResponse getError() {
        return error;
    }

    public void setError(BedResponse error) {
        this.error = error;
    }
}

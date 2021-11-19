package com.example.WeatherTestTask.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private String name;
    private String region;
    private String country;
    private String lat;
    private String lon;

    @OneToMany (mappedBy="location", fetch=FetchType.LAZY)
    private List<RequestData> requestList = new ArrayList<RequestData>();

    public Location() {
    }

    public Location(String name, String region, String country, String lat, String lon, List<RequestData> requestList) {
        this.name = name;
        this.region = region;
        this.country = country;
        this.lat = lat;
        this.lon = lon;
        this.requestList = requestList;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public List<RequestData> getRequestList() {
        return requestList;
    }

    public void setRequestList(List<RequestData> requestList) {
        this.requestList = requestList;
    }
}


package com.example.WeatherTestTask.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="RequestData")
public class RequestData {
    //пользователь, время, гeоданные для поиска, погода в данной локации

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime requestDate;

    private int userId;

    //поменять местами
    //                     requestData
    @OneToOne (mappedBy = "requestData")//, cascade = CascadeType.ALL)
    private Weather current;


    @ManyToOne (optional=false)
    @JoinColumn (name="reqId")
    private Location location;

    public RequestData() {
    }

    public RequestData(LocalDateTime requestDate, int userId, Weather current, Location location) {
        this.requestDate = requestDate;
        this.userId = userId;
        this.current = current;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDateTime request_date) {
        this.requestDate = request_date;
    }

    public Weather getCurrent() {
        return current;
    }

    public void setCurrent(Weather current) {
        this.current = current;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}

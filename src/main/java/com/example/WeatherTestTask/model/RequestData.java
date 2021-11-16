package com.example.WeatherTestTask.model;

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

    public RequestData() {
    }

    public RequestData(int userId, LocalDateTime requestDate) {
        this.userId = userId;
        this.requestDate = requestDate;
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
}

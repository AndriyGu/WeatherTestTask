package com.example.WeatherTestTask.repository;

import com.example.WeatherTestTask.model.RequestData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface RequestDataRepository extends JpaRepository<RequestData, Integer> {
    @Query("Select r from RequestData r WHERE r.id = ?1 and  r.requestDate = ?2")
    RequestData findReqestByIdAndRequestData(int id, LocalDateTime date);
}

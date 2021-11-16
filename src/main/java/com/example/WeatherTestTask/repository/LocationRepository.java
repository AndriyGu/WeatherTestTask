package com.example.WeatherTestTask.repository;

import com.example.WeatherTestTask.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface LocationRepository extends JpaRepository<Location, Integer> {

}



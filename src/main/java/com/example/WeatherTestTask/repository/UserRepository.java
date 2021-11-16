package com.example.WeatherTestTask.repository;

import com.example.WeatherTestTask.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("Select user from User user")
    List<User> getAllUsers();

    User findByLogin(String login);

    User findById(int id);

    @Query("Select user from User user where user.login=?1")
    Optional<User> findByLoginOpt(String login);
}

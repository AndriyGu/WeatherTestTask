package com.example.WeatherTestTask.controller;


import com.example.WeatherTestTask.exeption.JwtAuthenticationException;
import com.example.WeatherTestTask.model.DTO.LoginDTO;
import com.example.WeatherTestTask.security.jwt.CustomUserDetails;
import com.example.WeatherTestTask.security.jwt.cache.CurrentUser;
import com.example.WeatherTestTask.service.AuthenticationService;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO request) {
        Map<String, String> res = new HashMap<>();
        try {
            String token = authenticationService.login(request);
            res.put("message", "You have successfully logged in");
            res.put("token", token);
            return ResponseEntity.ok(res);
        } catch (AuthenticationException ex) {
            res.put("message", ex.getMessage());
            return ResponseEntity.badRequest().body(res);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseEntity.badRequest().body(res);
        }
    }

    @PutMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request,
                                    @CurrentUser CustomUserDetails account) {
        Map<String, String> res = new HashMap<>();
        String message = authenticationService.logout(request, account);
        res.put("message", message);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/check")
    public ResponseEntity<?> checkTokenExpire(@RequestBody Map<String, String> request) {
        Map<String, String> res = new HashMap<>();
        try {
            String message = authenticationService.checkExpiration(request.get("token"));
            res.put("message", message);
            return ResponseEntity.ok(res);
        } catch (JwtAuthenticationException | ExpiredJwtException e) {
            res.put("message", e.getMessage());
            return ResponseEntity.status(401).body(res);
        }
    }
}

package com.example.WeatherTestTask.service;

import com.example.WeatherTestTask.model.*;
import com.example.WeatherTestTask.repository.LocationRepository;
import com.example.WeatherTestTask.repository.RequestDataRepository;
import com.example.WeatherTestTask.repository.UserRepository;
import com.example.WeatherTestTask.repository.WeatherRepository;
import com.example.WeatherTestTask.security.jwt.JwtProvider;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;

@Service
public class WeatherApiService {

    @Autowired
    JwtProvider jwtProvider;
    UserRepository userRepository;
    RequestDataRepository requestDataRepository;
    LocationRepository locationRepository;
    WeatherRepository weatherRepository;

    public WeatherApiService(JwtProvider jwtProvider, UserRepository userRepository, RequestDataRepository requestDataRepository, LocationRepository locationRepository, WeatherRepository weatherRepository) {
        this.jwtProvider = jwtProvider;
        this.userRepository = userRepository;
        this.requestDataRepository = requestDataRepository;
        this.locationRepository = locationRepository;
        this.weatherRepository = weatherRepository;
    }

    public ResponseEntity<ResponseWeather> getWeatherByCityCountry(String city, String country, HttpServletRequest req) throws IOException, InterruptedException {

        String url = String.format("https://weatherapi-com.p.rapidapi.com/current.json?q=%s,%s", city, country);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("x-rapidapi-host", "weatherapi-com.p.rapidapi.com")
                .header("x-rapidapi-key", ApiKeyHolder.apiKey)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        ResponseWeather responseWeather = new Gson().fromJson(response.body(), ResponseWeather.class);

        if (responseWeather.getCurrent() != null && responseWeather.getLocation() != null) {
            int i =9;
            saveDataToBase(responseWeather, req);
            return new ResponseEntity<ResponseWeather>(responseWeather, HttpStatus.OK);
        } else {
            return new ResponseEntity<ResponseWeather>(responseWeather, HttpStatus.NOT_FOUND);
        }
    }

    private void saveDataToBase(ResponseWeather responseWeather, HttpServletRequest req) {

        String token = jwtProvider.getTokenFromRequest(req);
        int userId = jwtProvider.getIdFromToken(token);

        //Accounts a = new Accounts();
        RequestData requestData = new RequestData();
        //a.setUser(user);
        requestData.setUserId(userId);
        LocalDateTime localDateTime = LocalDateTime.now();
        requestData.setRequestDate(localDateTime);

        // return a;

        Weather weather = responseWeather.getCurrent();
        weather.setRequestData(requestData);
        weatherRepository.save(weather);

       //requestDataRepository.save(requestData);

        //Bed way

    //  int idRequest = requestDataRepository.findReqestByIdAndRequestData(userId, localDateTime).getId();

        //requestData.setLocation(responseWeather.getLocation());
       // Location location = responseWeather.getLocation();
       // locationRepository.save(location);


    }
}

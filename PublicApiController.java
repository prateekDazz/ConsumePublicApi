package com.banking.BankingApplication.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.banking.BankingApplication.dto.WeatherResponseDto;


@RestController
@RequestMapping("/consumePublicApi")
public class PublicApiController {
	@Autowired
	private  RestTemplate restTemplate;
	private static String API = "https://api.weatherstack.com/current?access_key=dd0581886d64d972d48940ee424ed18d&query=test";
	
	@GetMapping
	public WeatherResponseDto getWeather(@RequestParam("city")String city)
	{
		
		HttpHeaders headers = new HttpHeaders();
		
//    headers.set("access_key", "****");
//    HttpEntity<String> entity = new HttpEntity<>(headers);
		
		String apiRequest =  API.replace("test", city);
//		ResponseEntity<WeatherResponseDto>  weatherResponseDto= restTemplate.exchange(apiRequest, HttpMethod.GET, entity, WeatherResponseDto.class);
		ResponseEntity<WeatherResponseDto> WeatherResponseDto = restTemplate.exchange(apiRequest, HttpMethod.GET, null, WeatherResponseDto.class);
		System.out.println("Response Body: " + WeatherResponseDto.getBody());
		System.out.println("Status Code: " + WeatherResponseDto.getStatusCode());
		return WeatherResponseDto.getBody();
	}

}

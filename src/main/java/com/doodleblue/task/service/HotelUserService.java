package com.doodleblue.task.service;

import org.springframework.http.ResponseEntity;

import com.doodleblue.task.request.RegisterHotelUserRequest;

public interface HotelUserService {

	ResponseEntity<Object> registerHotelUser(RegisterHotelUserRequest registrationUser);
}
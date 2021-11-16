package com.doodleblue.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.doodleblue.task.dao.HotelUserDao;
import com.doodleblue.task.entity.User;
import com.doodleblue.task.request.RegisterHotelUserRequest;

@Service
public class HotelUserServiceImpl implements HotelUserService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private HotelUserDao hotelUserDao;

	@Override
	public ResponseEntity<Object> registerHotelUser(RegisterHotelUserRequest registrationUser) {
		hotelUserDao.saveHotelUser(User.builder().email(registrationUser.getEmail())
				.password(passwordEncoder.encode(registrationUser.getPassword())).role(registrationUser.getRole()).build());

		return ResponseEntity.ok().build();
	}
}
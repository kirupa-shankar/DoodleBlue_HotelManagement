package com.doodleblue.task.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doodleblue.task.request.RegisterHotelUserRequest;
import com.doodleblue.task.response.ResponseMessage;
import com.doodleblue.task.response.RegisterHotelUserResponse;
import com.doodleblue.task.service.HotelUserService;

@RestController
@RequestMapping("register")
public class HotelUserController {

	@Autowired
	private HotelUserService hotelUserService;

	@PostMapping("user")
	public ResponseEntity<Object> registerHotelUser(@Validated @ModelAttribute RegisterHotelUserRequest registrationUser, BindingResult bindingResult) {
		if (!bindingResult.hasFieldErrors())
			return hotelUserService.registerHotelUser(registrationUser);
		else {
			List<ResponseMessage> fieldErros = new LinkedList<ResponseMessage>();
			bindingResult.getAllErrors().forEach(error -> {
				fieldErros.add(ResponseMessage.builder().message(error.getDefaultMessage()).build());
			});
			bindingResult.getAllErrors().stream().forEach(System.out::println);

			return new ResponseEntity<>(RegisterHotelUserResponse.builder().fieldErrorResponse(fieldErros).build(), HttpStatus.BAD_REQUEST);
		}
	}
}
package com.doodleblue.task.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doodleblue.task.request.RoomBookingRequest;
import com.doodleblue.task.response.ResponseMessage;
import com.doodleblue.task.response.RegisterHotelUserResponse;
import com.doodleblue.task.service.HotelManagementService;

@RestController
@RequestMapping("hotel")
public class HotelManagementController {

	@Autowired
	private HotelManagementService hotelManagementService;

	@GetMapping("check-in")
	public ResponseEntity<String> getCheckInDetails(@RequestParam String name, @RequestParam String time) {
		return hotelManagementService.getCheckInDetails(name, time);
	}

	@GetMapping("check-out")
	public ResponseEntity<String> getCheckOutDetails(@RequestParam String name, @RequestParam String time) {
		return hotelManagementService.getCheckOutDetails(name, time);
	}

	@GetMapping("get-all-room")
	public ResponseEntity<Object> getAllRooms() {
		return hotelManagementService.getAllRooms();
	}

	@GetMapping("get-booked-rooms")
	public ResponseEntity<Object> getBookedRooms() {
		return hotelManagementService.getBookedRooms();
	}

	@GetMapping("get-vacant-rooms")
	public ResponseEntity<Object> getVacantRooms() {
		return hotelManagementService.getVacantRooms();
	}

	@PostMapping("book-room")
	public ResponseEntity<Object> getBookRoom(@Validated @ModelAttribute RoomBookingRequest roomBooking, BindingResult bindingResult) {
		if (!bindingResult.hasFieldErrors())
			return hotelManagementService.bookRoom(roomBooking);
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
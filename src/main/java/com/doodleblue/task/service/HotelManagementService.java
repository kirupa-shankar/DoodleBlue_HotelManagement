package com.doodleblue.task.service;

import org.springframework.http.ResponseEntity;

import com.doodleblue.task.request.RoomBookingRequest;

public interface HotelManagementService {

	ResponseEntity<String> getCheckInDetails(String name, String time);

	ResponseEntity<String> getCheckOutDetails(String name, String time);

	ResponseEntity<Object> getAllRooms();

	ResponseEntity<Object> getBookedRooms();

	ResponseEntity<Object> getVacantRooms();

	ResponseEntity<Object> bookRoom(RoomBookingRequest roomBooking);
}
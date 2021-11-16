package com.doodleblue.task.service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.doodleblue.task.dao.HotelManagementDao;
import com.doodleblue.task.entity.HotelRoomBookingHistory;
import com.doodleblue.task.entity.HotelRooms;
import com.doodleblue.task.entity.UserCheckIn;
import com.doodleblue.task.entity.UserCheckOut;
import com.doodleblue.task.request.RoomBookingRequest;
import com.doodleblue.task.response.HotelManagementResponse;
import com.doodleblue.task.response.ResponseMessage;

@Service
public class HotelManagementServiceImpl implements HotelManagementService {

	@Autowired
	private HotelManagementDao hotelManagementDao;

	@Override
	public ResponseEntity<String> getCheckInDetails(String name, String time) {
		Optional<UserCheckIn> userCheckIn = hotelManagementDao.getUserCheckIn(name);

		if (userCheckIn.isPresent())
			return new ResponseEntity<>("Success", HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<>("Failure", HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<String> getCheckOutDetails(String name, String time) {
		Optional<UserCheckOut> userCheckOut = hotelManagementDao.getUserCheckOut(name);

		if (userCheckOut.isPresent())
			return new ResponseEntity<>("Success", HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<>("Failure", HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<Object> getAllRooms() {
		return new ResponseEntity<>(hotelManagementDao.getAllRooms(), HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<Object> getBookedRooms() {
		List<HotelRooms> hotelRooms = hotelManagementDao.getBookedRooms();

		if (hotelRooms.isEmpty())
			return new ResponseEntity<>(ResponseMessage.builder().message("All rooms are vacant").build(), HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<>(hotelRooms, HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<Object> getVacantRooms() {
		List<HotelRooms> hotelRooms = hotelManagementDao.getVacantRooms();
		if (hotelRooms.isEmpty())
			return new ResponseEntity<>(ResponseMessage.builder().message("All rooms are booked").build(), HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<>(hotelRooms, HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<Object> bookRoom(RoomBookingRequest roomBooking) {
		Optional<HotelRooms> optionalHotelRoom = hotelManagementDao.getRoom(roomBooking.getRoomNo());

		if (optionalHotelRoom.isPresent()) {
			HotelRooms hotelRoom = optionalHotelRoom.get();

			if (hotelRoom.getBooked())
				return new ResponseEntity<>(ResponseMessage.builder().message("Room already booked..!!").build(), HttpStatus.BAD_REQUEST);

			hotelRoom.setBooked(true);
			HotelRoomBookingHistory hotelRoomBookingHistory = HotelRoomBookingHistory.builder().name(roomBooking.getName()).email(roomBooking.getEmail())
				.age(roomBooking.getAge()).address(roomBooking.getAddress()).aadharNo(roomBooking.getAadharNo()).roomNo(roomBooking.getRoomNo())
				.amount(roomBooking.getAmount()).bookedOn(new Date()).build();
			hotelManagementDao.bookRoom(hotelRoomBookingHistory);
			hotelManagementDao.updateRoomStatus(hotelRoom);
			
			return new ResponseEntity<>(HotelManagementResponse.builder().invoiceNo(UUID.randomUUID()).name(hotelRoomBookingHistory.getName())
					.email(hotelRoomBookingHistory.getEmail()).age(hotelRoomBookingHistory.getAge()).address(hotelRoomBookingHistory.getAddress())
					.aadharNo(hotelRoomBookingHistory.getAadharNo()).roomNo(hotelRoomBookingHistory.getRoomNo()).message("Room booked successfully..!!")
					.amount(hotelRoomBookingHistory.getAmount()).bookingDate(hotelRoomBookingHistory.getBookedOn()).build(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(ResponseMessage.builder().message("Room not found..!!").build(), HttpStatus.BAD_REQUEST);
	}
}
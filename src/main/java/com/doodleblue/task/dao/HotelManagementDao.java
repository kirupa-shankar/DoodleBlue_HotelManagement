package com.doodleblue.task.dao;

import java.util.List;
import java.util.Optional;

import com.doodleblue.task.entity.HotelRoomBookingHistory;
import com.doodleblue.task.entity.HotelRooms;
import com.doodleblue.task.entity.UserCheckIn;
import com.doodleblue.task.entity.UserCheckOut;

public interface HotelManagementDao {

	Optional<UserCheckIn> getUserCheckIn(String user);

	Optional<UserCheckOut> getUserCheckOut(String user);

	List<HotelRooms> getAllRooms();

	List<HotelRooms> getBookedRooms();

	List<HotelRooms> getVacantRooms();

	void updateRoomStatus(HotelRooms hotelRooms);

	Optional<HotelRooms> getRoom(String roomNo);

	void bookRoom(HotelRoomBookingHistory hotelRoomBookingHistory);
}
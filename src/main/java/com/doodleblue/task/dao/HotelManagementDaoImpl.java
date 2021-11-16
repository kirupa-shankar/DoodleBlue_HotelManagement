package com.doodleblue.task.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.doodleblue.task.entity.HotelRoomBookingHistory;
import com.doodleblue.task.entity.HotelRooms;
import com.doodleblue.task.entity.UserCheckIn;
import com.doodleblue.task.entity.UserCheckOut;
import com.doodleblue.task.repo.HotelRoomBookingRepository;
import com.doodleblue.task.repo.HotelRoomsRepository;
import com.doodleblue.task.repo.UserCheckInRepository;
import com.doodleblue.task.repo.UserCheckOutRepository;

@Repository
public class HotelManagementDaoImpl implements HotelManagementDao {

	@Autowired
	private UserCheckInRepository userCheckInRepo;

	@Autowired
	private UserCheckOutRepository userCheckOutRepo;

	@Autowired
	private HotelRoomsRepository hotelRoomsRepo;

	@Autowired
	private HotelRoomBookingRepository hotelRoomBookingRepo;

	@Override
	public Optional<UserCheckIn> getUserCheckIn(String user) {
		return userCheckInRepo.findByUser(user);
	}

	@Override
	public Optional<UserCheckOut> getUserCheckOut(String user) {
		return userCheckOutRepo.findByUser(user);
	}

	@Override
	public List<HotelRooms> getAllRooms() {
		return hotelRoomsRepo.findAllRooms();
	}

	@Override
	public List<HotelRooms> getBookedRooms() {
		return hotelRoomsRepo.findByBookedIsTrue();
	}

	@Override
	public List<HotelRooms> getVacantRooms() {
		return hotelRoomsRepo.findByBookedIsFalse();
	}

	@Override
	public void updateRoomStatus(HotelRooms hotelRooms) {
		hotelRoomsRepo.save(hotelRooms);
	}

	@Override
	public Optional<HotelRooms> getRoom(String roomNo) {
		return hotelRoomsRepo.findByRoomNo(roomNo);
	}

	@Override
	public void bookRoom(HotelRoomBookingHistory hotelRoomBookingHistory) {
		hotelRoomBookingRepo.save(hotelRoomBookingHistory);
	}
}
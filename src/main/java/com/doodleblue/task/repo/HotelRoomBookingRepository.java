package com.doodleblue.task.repo;

import org.springframework.data.repository.CrudRepository;

import com.doodleblue.task.entity.HotelRoomBookingHistory;

public interface HotelRoomBookingRepository extends CrudRepository<HotelRoomBookingHistory, Long> {

}
package com.doodleblue.task.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.doodleblue.task.entity.HotelRooms;

public interface HotelRoomsRepository extends CrudRepository<HotelRooms, Long> {

	@Query("select u from HotelRooms u")
	List<HotelRooms> findAllRooms();

	List<HotelRooms> findByBookedIsTrue();

	List<HotelRooms> findByBookedIsFalse();

	Optional<HotelRooms> findByRoomNo(String roomNo);
}
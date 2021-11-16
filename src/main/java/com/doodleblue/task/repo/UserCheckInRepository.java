package com.doodleblue.task.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.doodleblue.task.entity.UserCheckIn;

public interface UserCheckInRepository extends CrudRepository<UserCheckIn, Long> {

	Optional<UserCheckIn> findByUser(String user);
}
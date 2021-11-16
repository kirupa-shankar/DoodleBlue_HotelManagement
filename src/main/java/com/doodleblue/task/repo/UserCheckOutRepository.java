package com.doodleblue.task.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.doodleblue.task.entity.UserCheckOut;

public interface UserCheckOutRepository extends CrudRepository<UserCheckOut, Long> {

	Optional<UserCheckOut> findByUser(String user);
}
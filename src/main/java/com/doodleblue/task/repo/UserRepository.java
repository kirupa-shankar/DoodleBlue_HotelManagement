package com.doodleblue.task.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.doodleblue.task.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

	Optional<User> findByEmail(String email);
}
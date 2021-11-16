package com.doodleblue.task.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.doodleblue.task.entity.User;
import com.doodleblue.task.repo.UserRepository;

@Repository
public class HotelUserDaoImpl implements HotelUserDao {

	@Autowired
	private UserRepository userRepo;

	@Override
	public void saveHotelUser(User user) {
		userRepo.save(user);
	}
}
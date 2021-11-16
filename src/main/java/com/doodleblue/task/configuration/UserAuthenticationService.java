package com.doodleblue.task.configuration;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.doodleblue.task.entity.User;
import com.doodleblue.task.modal.CustomUser;
import com.doodleblue.task.repo.UserRepository;

@Service
public class UserAuthenticationService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRED)
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByEmail(email);
		if (!user.isPresent())
			throw new UsernameNotFoundException("User is not available");

		return new CustomUser(user.get());
	}
}
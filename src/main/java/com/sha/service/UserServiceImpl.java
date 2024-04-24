package com.sha.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sha.model.Role;
import com.sha.model.User;
import com.sha.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;

	private final PasswordEncoder passwordEncoder;

	@Override
	public User saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole(Role.USER);
		user.setCreateTime(LocalDateTime.now());

		return userRepository.save(user);
	}

	@Override
	public Optional<User> findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	@Transactional // Transactional is required when executing an update/delete query.
	public void changeRole(Role newRole, String username) {
		userRepository.updateUserRole(username, newRole);
	}

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

}

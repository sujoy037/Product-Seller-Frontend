package com.sha.service;

import java.util.List;
import java.util.Optional;

import com.sha.model.Role;
import com.sha.model.User;

public interface UserService {

	User saveUser(User user);

	void changeRole(Role newRole, String username);

	List<User> findAllUsers();

	Optional<User> findByUsername(String username);

}

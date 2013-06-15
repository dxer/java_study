package com.azure.app.service.impl;

import java.util.List;

import com.azure.app.entity.User;
import com.azure.app.mapper.UserMapper;
import com.azure.app.service.UserService;

public class UserServiceImpl implements UserService {

	private UserMapper userMapper;

	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public void addUser(User user) {
		userMapper.addUser(user);
	}

	@Override
	public void deleteUserById(int id) {
		userMapper.deleteUserById(id);
	}

	@Override
	public List<User> listAllUser() {
		return userMapper.listAllUser();
	}

	@Override
	public void updateUser(User user) {
		userMapper.updateUser(user);
	}

}

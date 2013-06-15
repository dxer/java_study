package com.azure.app.mapper;

import java.util.List;

import com.azure.app.entity.User;

public interface UserMapper {

	/**
	 * 
	 * @param user
	 */
	public void addUser(User user);

	/**
	 * 
	 * @param id
	 */
	public void deleteUserById(int id);

	/**
	 * 
	 * @return
	 */
	public List<User> listAllUser();

	/**
	 * 
	 * @param user
	 */
	public void updateUser(User user);
}

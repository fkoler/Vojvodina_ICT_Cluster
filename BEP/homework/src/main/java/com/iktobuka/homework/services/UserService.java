package com.iktobuka.homework.services;

import com.iktobuka.homework.entities.UserEntity;
import com.iktobuka.homework.entities.UserEntityDTO;

public interface UserService {

	Iterable<UserEntity> getAllUsers();

	UserEntity getUserById(Integer id);

	UserEntity createUser(UserEntityDTO userDTO);

	UserEntity updateUser(Integer id, UserEntityDTO userDTO);

	UserEntity deleteUser(Integer id);
}

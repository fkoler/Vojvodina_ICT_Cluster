package com.iktobuka.serialization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iktobuka.serialization.entities.UserEntity;
import com.iktobuka.serialization.entities.dto.UserDTO;
import com.iktobuka.serialization.entities.dto.UserRegisterDTO;
import com.iktobuka.serialization.entities.mapper.UserMapper;

@Service
public class UserService {
	
	@Autowired
	protected UserMapper userMapper;

	public UserDTO createUser(UserRegisterDTO user) {
//		UserEntity ue = new UserEntity();
		UserEntity ue = userMapper
						.toEntityFromUserRegisterDTO(user);
		
		ue.setId(3);
//		ue.setEmail(user.getEmail());
//		ue.setName(user.getName());
		
//		UserDTO udto = new UserDTO();
		UserDTO udto = userMapper.toDto(ue);
		
//		udto.setId(ue.getId());
//		udto.setEmail(ue.getEmail());
//		udto.setName(ue.getName());
		
		return udto;
	}
	
	public UserDTO updateUser(UserDTO user, Integer id) {
//		UserEntity ue = new UserEntity();

//		ue.setEmail(user.getEmail());
//		ue.setName(user.getName());

//		UserDTO udto = new UserDTO();

//		udto.setId(ue.getId());
//		udto.setEmail(ue.getEmail());
//		udto.setName(ue.getName());
		
		UserEntity ue = userMapper
						.toEntityFromUserDTO(user);
		ue.setId(3);
		UserDTO udto = userMapper.toDto(ue);

		return udto;
	}
}

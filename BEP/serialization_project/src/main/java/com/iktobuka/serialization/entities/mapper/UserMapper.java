package com.iktobuka.serialization.entities.mapper;

import org.springframework.stereotype.Component;

import com.iktobuka.serialization.entities.UserEntity;
import com.iktobuka.serialization.entities.dto.UserDTO;
import com.iktobuka.serialization.entities.dto.UserRegisterDTO;

@Component
public class UserMapper {

	public UserDTO toDto(UserEntity ue) {
		UserDTO udto = new UserDTO();

		udto.setId(ue.getId());
		udto.setName(ue.getName());
		udto.setEmail(ue.getEmail());

		return udto;
	}

	public UserEntity toEntityFromUserDTO(
			UserDTO udto
		) {
		UserEntity ue = new UserEntity();

		ue.setName(udto.getName());
		ue.setEmail(udto.getEmail());

		return ue;
	}

	public UserEntity toEntityFromUserRegisterDTO(
			UserRegisterDTO udto
		) {
		UserEntity ue = new UserEntity();

		ue.setName(udto.getName());
		ue.setEmail(udto.getEmail());

		return ue;
	}
}

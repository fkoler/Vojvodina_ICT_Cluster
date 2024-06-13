package com.iktobuka.homework.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iktobuka.homework.entities.AddressEntity;
import com.iktobuka.homework.entities.JobPositionEntity;
import com.iktobuka.homework.entities.UserEntity;
import com.iktobuka.homework.entities.UserEntityDTO;
import com.iktobuka.homework.repository.AddressRepository;
import com.iktobuka.homework.repository.JobPositionRepository;
import com.iktobuka.homework.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private JobPositionRepository jobPositionRepository;

	@Override
	public Iterable<UserEntity> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public UserEntity getUserById(Integer id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public UserEntity createUser(UserEntityDTO userDTO) {
		UserEntity user = new UserEntity();
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setComment(userDTO.getComment());
		user.setDateOfBirth(userDTO.getDateOfBirth());
		user.setPhoneNumber(userDTO.getPhoneNumber());
		user.setSsn(userDTO.getSsn());
		user.setIdCardNumber(userDTO.getIdCardNumber());

		AddressEntity address = addressRepository.findById(
				userDTO.getAddressId()
			).orElse(null);
		
		user.setAddress(address);

		JobPositionEntity jobPosition = jobPositionRepository.findById(
				userDTO.getJobPositionId()
			).orElse(null);
		
		user.setJobPosition(jobPosition);

		return userRepository.save(user);
	}

	@Override
	public UserEntity updateUser(Integer id, UserEntityDTO userDTO) {
		Optional<UserEntity> optionalUser = userRepository.findById(id);
		
		if (optionalUser.isPresent()) {
			UserEntity user = optionalUser.get();
			user.setName(userDTO.getName());
			user.setEmail(userDTO.getEmail());
			user.setComment(userDTO.getComment());
			user.setDateOfBirth(userDTO.getDateOfBirth());
			user.setPhoneNumber(userDTO.getPhoneNumber());
			user.setSsn(userDTO.getSsn());
			user.setIdCardNumber(userDTO.getIdCardNumber());

			AddressEntity address = addressRepository.findById(
					userDTO.getAddressId()
				).orElse(null);
			
			user.setAddress(address);

			JobPositionEntity jobPosition = jobPositionRepository.findById(
					userDTO.getJobPositionId()
				).orElse(null);
			
			user.setJobPosition(jobPosition);

			return userRepository.save(user);
		}
		return null;
	}

	@Override
	public UserEntity deleteUser(Integer id) {
		Optional<UserEntity> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			UserEntity user = optionalUser.get();
			userRepository.delete(user);
			return user;
		}
		return null;
	}
}

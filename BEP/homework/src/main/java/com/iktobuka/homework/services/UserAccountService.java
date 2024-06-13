package com.iktobuka.homework.services;

import com.iktobuka.homework.entities.UserAccountEntity;
import com.iktobuka.homework.entities.UserAccountEntityDTO;
import com.iktobuka.homework.entities.UserEntity;

public interface UserAccountService {

	public Iterable<UserAccountEntity> getAllUserAccounts();

	public UserAccountEntity getUserAccountById(Integer id);

	public UserAccountEntity createUserAccount(
			UserAccountEntityDTO userAccountDTO
		);

	public UserAccountEntity updateUserAccount(
			Integer id,
			UserAccountEntityDTO userAccountDTO
		);

	public UserAccountEntity deleteUserAccount(Integer id);

	public UserEntity addUserAccountToUser(
			Integer userId, 
			UserAccountEntityDTO userAccountDTO
		);

	public UserEntity removeUserAccountFromUser(
			Integer userId,
			Integer userAccountId
		);
}

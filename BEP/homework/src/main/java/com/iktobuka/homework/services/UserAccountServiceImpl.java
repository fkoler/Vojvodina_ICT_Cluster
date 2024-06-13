package com.iktobuka.homework.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iktobuka.homework.entities.UserAccountEntity;
import com.iktobuka.homework.entities.UserAccountEntityDTO;
import com.iktobuka.homework.entities.UserEntity;
import com.iktobuka.homework.repository.UserAccountRepository;
import com.iktobuka.homework.repository.UserRepository;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<UserAccountEntity> getAllUserAccounts() {
        return userAccountRepository.findAll();
    }

    @Override
    public UserAccountEntity getUserAccountById(Integer id) {
        return userAccountRepository.findById(id).orElse(null);
    }

    @Override
    public UserAccountEntity createUserAccount(
    		UserAccountEntityDTO userAccountDTO
    	) {
        UserEntity user = userRepository
        				 .findById(userAccountDTO.getUserId())
        				 .orElse(null);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        UserAccountEntity userAccount = new UserAccountEntity();
        userAccount.setUsername(userAccountDTO.getUsername());
        userAccount.setPassword(userAccountDTO.getPassword());
        userAccount.setEmail(userAccountDTO.getEmail());
        userAccount.setUser(user);

        return userAccountRepository.save(userAccount);
    }

    @Override
    public UserAccountEntity updateUserAccount(
    		Integer id,
    		UserAccountEntityDTO userAccountDTO
    	) {
        Optional<UserAccountEntity> optionalUserAccount = userAccountRepository
        												 .findById(id);
        if (optionalUserAccount.isPresent()) {
            UserAccountEntity userAccount = optionalUserAccount.get();
            userAccount.setUsername(userAccountDTO.getUsername());
            userAccount.setPassword(userAccountDTO.getPassword());
            userAccount.setEmail(userAccountDTO.getEmail());
            UserEntity user = userRepository.findById(
            		userAccountDTO.getUserId()
            		).orElse(null);
            
            userAccount.setUser(user);

            return userAccountRepository.save(userAccount);
        }
        
        return null;
    }

    @Override
    public UserAccountEntity deleteUserAccount(Integer id) {
        Optional<UserAccountEntity> optionalUserAccount = userAccountRepository
        												 .findById(id);
        if (optionalUserAccount.isPresent()) {
            UserAccountEntity userAccount = optionalUserAccount.get();
            userAccountRepository.delete(userAccount);
            
            return userAccount;
        }
        
        return null;
    }

    @Override
    public UserEntity addUserAccountToUser(
    		Integer userId, 
    		UserAccountEntityDTO userAccountDTO
    	) {
        UserEntity user = userRepository.findById(userId).orElse(null);
        
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        UserAccountEntity userAccount = new UserAccountEntity();
        userAccount.setUsername(userAccountDTO.getUsername());
        userAccount.setPassword(userAccountDTO.getPassword());
        userAccount.setEmail(userAccountDTO.getEmail());
        userAccount.setUser(user);

        user.addUserAccount(userAccount);
        userRepository.save(user);

        return user;
    }

    @Override
    public UserEntity removeUserAccountFromUser(
    		Integer userId,
    		Integer userAccountId
    	) {
        UserEntity user = userRepository.findById(userId).orElse(null);
        
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        Optional<UserAccountEntity> optionalUserAccount = userAccountRepository
        												 .findById(userAccountId);
        if (optionalUserAccount.isPresent()) {
            UserAccountEntity userAccount = optionalUserAccount.get();
            user.removeUserAccount(userAccount);
            userRepository.save(user);
            
            return user;
        }
        
        return null;
    }
}

package com.iktobuka.homework.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.iktobuka.homework.entities.UserEntity;
import com.iktobuka.homework.entities.UserEntityDTO;
import com.iktobuka.homework.security.Views;
import com.iktobuka.homework.services.UserService;

@RestController
@RequestMapping(value = "api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/worker")
    @JsonView(Views.WorkerView.class)
    public List<UserEntity> getAll() {
        return (List<UserEntity>) userService.getAllUsers();
    }

    @GetMapping("/leader/{id}")
    @JsonView(Views.LeaderView.class)
    public ResponseEntity<UserEntity> getById(
    		@PathVariable Integer id
    	) {
        UserEntity user = userService.getUserById(id);
        
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/directory")
    @JsonView(Views.DirectoryView.class)
    public ResponseEntity<UserEntity> create(
    		@RequestBody UserEntityDTO userDTO
    	) {
        UserEntity user = userService.createUser(userDTO);
        
        return ResponseEntity.ok(user);
    }

    @PutMapping("/directory/{id}")
    @JsonView(Views.DirectoryView.class)
    public ResponseEntity<UserEntity> update(
    		@PathVariable Integer id,
    		@RequestBody UserEntityDTO userDTO
    	) {
        UserEntity user = userService.updateUser(id, userDTO);
        
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/directory/{id}")
    @JsonView(Views.DirectoryView.class)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        UserEntity user = userService.deleteUser(id);
        
        if (user != null) {
            return ResponseEntity.ok().build();
        }
        
        return ResponseEntity.notFound().build();
    }
}

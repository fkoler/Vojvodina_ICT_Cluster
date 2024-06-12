package com.iktobuka.security_example_token.controllers;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.iktobuka.security_example_token.entities.UserDTO;
import com.iktobuka.security_example_token.entities.UserEntity;
import com.iktobuka.security_example_token.repositories.UserRepository;
import com.iktobuka.security_example_token.util.Encryption;

import io.jsonwebtoken.Jwts;

@RestController
public class UserController {
	
	@Autowired
	private SecretKey secretKey;
	
	@Value("${spring.security.token-duration}")
	private Integer tokenDuration;
	
	@Autowired
	private UserRepository userRepository;

	private String getJWTToken(UserEntity userEntity) {
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList(userEntity.getRole()
				.getName());
		String token = Jwts.builder()
				.setId("softtekJWT")
				.setSubject(userEntity.getEmail())
				.claim("authorities",
				grantedAuthorities.stream()
				.map(GrantedAuthority::getAuthority)
				.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 				this.tokenDuration))
				.signWith(this.secretKey)
				.compact();
		
		return "Bearer " + token;
	}

	@PostMapping("/api/v1/login")
	public ResponseEntity<?> login(@RequestParam("user") String email, @RequestParam("password") String pwd) {
		UserEntity userEntity = userRepository.findByEmail(email);
		
		if (userEntity != null && Encryption
				.validatePassword(pwd,
				userEntity.getPassword())) {
			String token = getJWTToken(userEntity);
			UserDTO user = new UserDTO();
			
			user.setUser(email);
			user.setToken(token);
			
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Wrong credentials", HttpStatus.UNAUTHORIZED);
	}

	@Secured("ROLE_USER")
	@GetMapping("/api/v1/users")
	public ResponseEntity<?> listUsers() {
		return new ResponseEntity<List<UserEntity>>((List<UserEntity>) 		userRepository.findAll(), HttpStatus.OK);
	}
}

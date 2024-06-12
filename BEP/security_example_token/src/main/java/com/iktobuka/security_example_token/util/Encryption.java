package com.iktobuka.security_example_token.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encryption {
	public static String getPassEncoded(String pass) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder.encode(pass);
	}

	public static boolean validatePassword(String pass, String encodedPass) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder.matches(pass, encodedPass);
	}
}

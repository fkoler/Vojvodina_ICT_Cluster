package com.iktobuka.validation_example.utils;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.iktobuka.validation_example.entities.dto.UserDto;

@Component
public class UserCustomValidator implements Validator {
    
    @Override
    public boolean supports(Class<?> myClass) {
        return UserDto.class.equals(myClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto user = (UserDto) target;
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "Passwords must be the same");
        }
    }
}

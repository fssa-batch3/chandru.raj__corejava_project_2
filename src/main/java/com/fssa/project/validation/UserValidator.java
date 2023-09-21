package com.fssa.project.validation;

import com.fssa.project.exception.ValidationException;
import com.fssa.project.model.User;
import java.time.LocalDate;
import java.util.regex.Pattern;

public class UserValidator {
    private User user;

    public UserValidator(User user) {
        this.user = user;
    }

    public void validateAll() throws ValidationException {
        validateName();
        
        validateMobileNumber();
        
        validateEmail();
        validatePassword();
    }

    public void validateName() throws ValidationException {
        if (user.getName() == null || user.getName().isEmpty()) {
            throw new ValidationException("Name is required.");
        }
        // Additional validation rules for name if needed
    }

    

    public void validateMobileNumber() throws ValidationException {
        if (user.getMobileNumber() == null || user.getMobileNumber().isEmpty()) {
            throw new ValidationException("Mobile number is required.");
        }
        // Additional validation rules for mobile number if needed
    }

    

    public void validateEmail() throws ValidationException {
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new ValidationException("Email is required.");
        }

        // Additional validation rules for email if needed
        // For example, check if the email format is valid using regex
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (!user.getEmail().matches(emailRegex)) {
            throw new ValidationException("Invalid email format.");
        }
    }

    public void validatePassword() throws ValidationException {
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new ValidationException("Password is required.");
        }
        // Additional validation rules for password if needed
    }
}

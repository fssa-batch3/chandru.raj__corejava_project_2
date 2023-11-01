package com.fssa.project.validation;

import com.fssa.project.exception.ValidationException;
import com.fssa.project.model.User;

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
        
        // Define a regex pattern for a valid name (adjust as needed)
        String namePattern = "^[A-Za-z\\s'-]{3,}$"; // This pattern allows letters, spaces, hyphens, and apostrophes and requires at least 6 characters
        
        if (!user.getName().matches(namePattern)) {
            throw new ValidationException("Invalid name(eg:Ajay Natraj) format or too short (minimum 3 characters).");
        }
        
        // Additional validation rules for name if needed
    }


    

    public void validateMobileNumber() throws ValidationException {
        if (user.getMobileNumber() == null || user.getMobileNumber().isEmpty()) {
            throw new ValidationException("Mobile number is required.");
        }
        
        // Define a regex pattern for a 10-digit mobile number starting with 9, 8, or 6
        String mobilePattern = "^[9876][0-9]{9}$"; // This pattern allows exactly 10 digits and starts with 9, 8, or 6
        
        if (!user.getMobileNumber().matches(mobilePattern)) {
            throw new ValidationException("Invalid mobile number format.");
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
        
        // regex pattern for password
        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
        
        if (!user.getPassword().matches(passwordPattern)) {
            throw new ValidationException("Invalid password format.");
        }
        
     
    }

}

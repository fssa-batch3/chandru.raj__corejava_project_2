package com.fssa.project.validator;

import com.fssa.project.exception.ValidationException;
import com.fssa.project.model.User;
import org.junit.jupiter.api.Test;
import com.fssa.project.validation.UserValidator;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserValidatorTest {

    @Test
    public void testValidUser() {
        User user = new User("John Doe", "1234567890", "john@example.com", "password");
        UserValidator validator = new UserValidator(user);
        assertDoesNotThrow(() -> validator.validateAll());
    }

    @Test
    public void testInvalidEmptyName() {
        User user = new User("", "1234567890", "john@example.com", "password");
        UserValidator validator = new UserValidator(user);
        assertThrows(ValidationException.class, () -> validator.validateAll());
    }

    

    @Test
    public void testInvalidEmptyMobileNumber() {
        User user = new User("Michael Doe", "", "michael@example.com", "password");
        UserValidator validator = new UserValidator(user);
        assertThrows(ValidationException.class, () -> validator.validateAll());
    }

    

//    @Test
//    public void testInvalidInvalidEmail() {
//        User user = new User("Olivia Doe", "Female", "9876543210", LocalDate.of(1994, 4, 4), "olivia@.com", "password");
//        UserValidator validator = new UserValidator(user);
//        assertThrows(ValidationException.class, () -> validator.validateAll());
//    }

    @Test
    public void testInvalidEmptyPassword() {
        User user = new User("Ethan Doe", "1234567890", "ethan@example.com", "");
        UserValidator validator = new UserValidator(user);
        assertThrows(ValidationException.class, () -> validator.validateAll());
    }
}

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
        User user = new User("John Doe", "Male", "1234567890", LocalDate.of(1990, 1, 1), "john@example.com", "password");
        UserValidator validator = new UserValidator(user);
        assertDoesNotThrow(() -> validator.validateAll());
    }

    @Test
    public void testInvalidEmptyName() {
        User user = new User("", "Male", "1234567890", LocalDate.of(1990, 1, 1), "john@example.com", "password");
        UserValidator validator = new UserValidator(user);
        assertThrows(ValidationException.class, () -> validator.validateAll());
    }

    @Test
    public void testInvalidEmptyGender() {
        User user = new User("Jane Doe", "", "1234567890", LocalDate.of(1995, 5, 5), "jane@example.com", "password");
        UserValidator validator = new UserValidator(user);
        assertThrows(ValidationException.class, () -> validator.validateAll());
    }

    @Test
    public void testInvalidEmptyMobileNumber() {
        User user = new User("Michael Doe", "Male", "", LocalDate.of(1998, 9, 15), "michael@example.com", "password");
        UserValidator validator = new UserValidator(user);
        assertThrows(ValidationException.class, () -> validator.validateAll());
    }

    @Test
    public void testInvalidFutureDateOfBirth() {
        User user = new User("Emma Doe", "Female", "9876543210", LocalDate.now().plusYears(1), "emma@example.com", "password");
        UserValidator validator = new UserValidator(user);
        assertThrows(ValidationException.class, () -> validator.validateAll());
    }

    @Test
    public void testInvalidInvalidEmail() {
        User user = new User("Olivia Doe", "Female", "9876543210", LocalDate.of(1994, 4, 4), "olivia@.com", "password");
        UserValidator validator = new UserValidator(user);
        assertThrows(ValidationException.class, () -> validator.validateAll());
    }

    @Test
    public void testInvalidEmptyPassword() {
        User user = new User("Ethan Doe", "Male", "1234567890", LocalDate.of(1989, 3, 29), "ethan@example.com", "");
        UserValidator validator = new UserValidator(user);
        assertThrows(ValidationException.class, () -> validator.validateAll());
    }
}

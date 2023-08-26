package com.fssa.project.validator;

import com.fssa.project.exception.ValidationException;

import com.fssa.project.model.Hall;
import com.fssa.project.validation.HallValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HallValidatorTest {

    @Test
    public void testValidHall() {
        Hall hall = new Hall("HallName", "HallLocation", "1234567890");
        HallValidator validator = new HallValidator(hall);
        assertDoesNotThrow(() -> validator.validateAll());
    }

    @Test
    public void testInvalidEmptyHallName() {
        Hall hall = new Hall("", "HallLocation", "1234567890");
        HallValidator validator = new HallValidator(hall);
        assertThrows(ValidationException.class, () -> validator.validateHallName());
    }

    @Test
    public void testInvalidEmptyHallLocation() {
        Hall hall = new Hall("HallName", "", "1234567890");
        HallValidator validator = new HallValidator(hall);
        assertThrows(ValidationException.class, () -> validator.validateHallLocation());
    }

    @Test
    public void testInvalidEmptyMobileNumber() {
        Hall hall = new Hall("HallName", "HallLocation", "");
        HallValidator validator = new HallValidator(hall);
        assertThrows(ValidationException.class, () -> validator.validateMobileNumber());
    }

    @Test
    public void testInvalidShortMobileNumber() {
        Hall hall = new Hall("HallName", "HallLocation", "123");
        HallValidator validator = new HallValidator(hall);
        assertThrows(ValidationException.class, () -> validator.validateMobileNumber());
    }

    @Test
    public void testInvalidLongMobileNumber() {
        Hall hall = new Hall("HallName", "HallLocation", "12345678901");
        HallValidator validator = new HallValidator(hall);
        assertThrows(ValidationException.class, () -> validator.validateMobileNumber());
    }

    @Test
    public void testInvalidNonNumericMobileNumber() {
        Hall hall = new Hall("HallName", "HallLocation", "abcd123456");
        HallValidator validator = new HallValidator(hall);
        assertThrows(ValidationException.class, () -> validator.validateMobileNumber());
    }
}

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
        Hall validHall = new Hall("ABC Hall","Tambaram","9876543212");
//        validHall.setHallName("ABC Hall");
//        validHall.setHallLocation("Some Location");
//        validHall.setMobileNumber("1234567890");

        assertDoesNotThrow(() -> HallValidator.validateHall(validHall));
    }
        
    @Test
    public void testEmptyHallName() {
        Hall invalidHall = new Hall("","Tambaram","9876543212");
//        invalidHall.setHallName("");
//        invalidHall.setHallLocation("Some Location");
//        invalidHall.setMobileNumber("1234567890");

        assertThrows(ValidationException.class, () -> HallValidator.validateHall(invalidHall));
    }

    @Test
    public void testInvalidHallName() {
        Hall invalidHall = new Hall("ABC@123","Tambaram","9876543212");
//        invalidHall.setHallName("ABC@123");
//        invalidHall.setHallLocation("Some Location");
//        invalidHall.setMobileNumber("1234567890");

        assertThrows(ValidationException.class, () -> HallValidator.validateHall(invalidHall));
    }

    @Test
    public void testEmptyHallLocation() {
        Hall invalidHall = new Hall("ABC@123","","9876543212");
//        invalidHall.setHallName("ABC Hall");
//        invalidHall.setHallLocation("");
//        invalidHall.setMobileNumber("1234567890");

        assertThrows(ValidationException.class, () -> HallValidator.validateHall(invalidHall));
    }

    @Test
    public void testEmptyMobileNumber() {
        Hall invalidHall = new Hall("ABC@123","Tambaram","");
//        invalidHall.setHallName("ABC Hall");
//        invalidHall.setHallLocation("Some Location");
//        invalidHall.setMobileNumber("");

        assertThrows(ValidationException.class, () -> HallValidator.validateHall(invalidHall));
    }

    @Test
    public void testInvalidMobileNumber() {
        Hall invalidHall = new Hall("ABC@123","Tambaram","987");
//        invalidHall.setHallName("ABC Hall");
//        invalidHall.setHallLocation("Some Location");
//        invalidHall.setMobileNumber("123"); // Invalid format

        assertThrows(ValidationException.class, () -> HallValidator.validateHall(invalidHall));
    }
}

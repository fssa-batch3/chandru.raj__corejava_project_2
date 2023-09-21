package com.fssa.project.validator;

import com.fssa.project.exception.ValidationException;
import com.fssa.project.model.Hall;
import com.fssa.project.validation.HallValidator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HallValidatorTest {
            
    @Test
    public void testValidHall() {
        Hall validHall = new Hall(0, "ABC Hall","Tambaram","9876543212","850", "15000", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg");
//        validHall.setHallName("ABC Hall");
//        validHall.setHallLocation("Some Location");
//        validHall.setMobileNumber("1234567890");

        assertDoesNotThrow(() -> HallValidator.validateHall(validHall));
    }
        
    @Test
    public void testEmptyHallName() {
        Hall invalidHall = new Hall(0, "","Tambaram","9876543212","850", "15000", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg");
//        invalidHall.setHallName("");
//        invalidHall.setHallLocation("Some Location");
//        invalidHall.setMobileNumber("1234567890");

        assertThrows(ValidationException.class, () -> HallValidator.validateHall(invalidHall));
    }

    @Test
    public void testInvalidHallName() {
        Hall invalidHall = new Hall(0, "ABC@123","Tambaram","9876543212", "850", "15000", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg");
//        invalidHall.setHallName("ABC@123");
//        invalidHall.setHallLocation("Some Location");
//        invalidHall.setMobileNumber("1234567890");

        assertThrows(ValidationException.class, () -> HallValidator.validateHall(invalidHall));
    }

    @Test
    public void testEmptyHallLocation() {
        Hall invalidHall = new Hall(0, "ABC@123","","9876543212", "850", "15000", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg");
//        invalidHall.setHallName("ABC Hall");
//        invalidHall.setHallLocation("");
//        invalidHall.setMobileNumber("1234567890");

        assertThrows(ValidationException.class, () -> HallValidator.validateHall(invalidHall));
    }

    @Test
    public void testEmptyMobileNumber() {
        Hall invalidHall = new Hall(0, "ABC@123","Tambaram","", "850", "15000", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg");
//        invalidHall.setHallName("ABC Hall");
//        invalidHall.setHallLocation("Some Location");
//        invalidHall.setMobileNumber("");

        assertThrows(ValidationException.class, () -> HallValidator.validateHall(invalidHall));
    }

    @Test
    public void testInvalidMobileNumber() {
        Hall invalidHall = new Hall(0, "ABC@123","Tambaram","987", "850", "15000", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg");
//        invalidHall.setHallName("ABC Hall");
//        invalidHall.setHallLocation("Some Location");
//        invalidHall.setMobileNumber("123"); // Invalid format

        assertThrows(ValidationException.class, () -> HallValidator.validateHall(invalidHall));
    }
    
    @Test
    public void testInvalidCapacity() {
        Hall invalidHall = new Hall(0, "ABC@123","Tambaram","987", "avh", "15000", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg");
//        invalidHall.setHallName("ABC Hall");
//        invalidHall.setHallLocation("Some Location");
//        invalidHall.setMobileNumber("123"); // Invalid format

        assertThrows(ValidationException.class, () -> HallValidator.validateHall(invalidHall));
    }
    
    @Test
    public void testInvalidPricing() {
        Hall invalidHall = new Hall(0, "ABC@123","Tambaram","987", "pricing", "800", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg");
//        invalidHall.setHallName("ABC Hall");
//        invalidHall.setHallLocation("Some Location");
//        invalidHall.setMobileNumber("123"); // Invalid format

        assertThrows(ValidationException.class, () -> HallValidator.validateHall(invalidHall));
    }
    
    public static boolean isValidURL(String url) {
        // Regular expression for a valid URL
        String regex = "^(https?|ftp)://[A-Za-z0-9+&@#/%?=~_|!:,.;]*[A-Za-z0-9+&@#/%=~_|]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }
}

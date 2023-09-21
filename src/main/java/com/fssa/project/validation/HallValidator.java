package com.fssa.project.validation;

import java.util.regex.Pattern;

import com.fssa.project.exception.ValidationException;
import com.fssa.project.model.Hall;

public class HallValidator {

    private HallValidator() {
    }

    public static void validateHall(Hall hall) throws ValidationException {
        if (hall == null) {
            throw new ValidationException("Hall object is null");
        } 

        if (hall.getHallName() == null || hall.getHallName().isEmpty()) {
            throw new ValidationException("Hall name is required");
        } else if (!isValidHallName(hall.getHallName())) {
            throw new ValidationException("Invalid hall name");
        }

        if (hall.getHallLocation() == null || hall.getHallLocation().isEmpty()) {
            throw new ValidationException("Hall location is required");
        }

        if (hall.getMobileNumber() == null || hall.getMobileNumber().isEmpty()) {
            throw new ValidationException("Mobile number is required");
        } 
//        else if (!isValidMobileNumber(hall.getMobileNumber())) {
//            throw new ValidationException("Invalid mobile number");
//        }
        
        if (hall.getCapacity() == null || hall.getCapacity().isEmpty()) {
            throw new ValidationException("Capacity is required");
        } else if (isValidCapacity(hall.getCapacity())) {
            throw new ValidationException("Invalid capacity");
        }
        
        if (hall.getPricing() == null || hall.getPricing().isEmpty()) {
            throw new ValidationException("Pricing is required");
        } else if (isValidPricing(hall.getPricing())) {
            throw new ValidationException("Invalid pricing");
        }

        
//        if (hall.getUrl() != null || !hall.getUrl().isEmpty() || isValidImageURL(hall.getUrl())) {
//            throw new ValidationException("Invalid image URL");
//        }
    

       
    }

    public static boolean isValidHallName(String hallName) {
        
        String regex = "^[a-zA-Z0-9\\s]+$"; // Alphanumeric with spaces
        
        return hallName.matches(regex);
    }
    
    

    public static boolean isValidMobileNumber(String mobileNumber) {
        
        String regex = "^[0-9]{10}$"; // Assuming 10-digit mobile number
        
        return mobileNumber.matches(regex);
    }
    
   public static boolean isValidCapacity(String capacity) {
        
        String regex = "^[0-9]{10}$"; // Assuming 10-digit mobile number
        
        return capacity.matches(regex);
    }
   
   public static boolean isValidPricing(String pricing) {
       
       String regex = "^[0-9]{10}$"; // Assuming 10-digit mobile number
       
       return pricing.matches(regex);
   }
    
    public static boolean isValidLocation(String location) {
        // Define the regex pattern for a valid location (letters, numbers, spaces, and commas)
        String regex = "^[a-zA-Z0-9\\s,]+$";

        // Check if the location string matches the regex pattern
        return location.matches(regex);
    }
    
    public static boolean isValidImageURL(String imageUrl) {
        // Regular expression for a valid image URL (supports common image formats)
        String regex = "^(https?|ftp)://[A-Za-z0-9+&@#/%?=~_|!:,.;]*[A-Za-z0-9+&@#/%=~_|](.jpg|.jpeg|.png|.gif|.bmp)$";
        return Pattern.matches(regex, imageUrl.toLowerCase());
    }

	public static void validateHall(String hallName) {
		// TODO Auto-generated method stub
		
	}

	public static void validateHallLocation(String hallLocation) {
		// TODO Auto-generated method stub
		
	}

	public static void validateMobileNumber(String mobileNumber) {
		// TODO Auto-generated method stub
		
	}
}

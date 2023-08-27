package com.fssa.project.validation;

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
        } else if (!isValidMobileNumber(hall.getMobileNumber())) {
            throw new ValidationException("Invalid mobile number");
        }

        // You can add more validation rules as needed
    }

    private static boolean isValidHallName(String hallName) {
        // Define your regex pattern for a valid hall name
        String regex = "^[a-zA-Z0-9\\s]+$"; // Alphanumeric with spaces
        
        return hallName.matches(regex);
    }

    private static boolean isValidMobileNumber(String mobileNumber) {
        // Define your regex pattern for a valid mobile number
        String regex = "^[0-9]{10}$"; // Assuming 10-digit mobile number
        
        return mobileNumber.matches(regex);
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

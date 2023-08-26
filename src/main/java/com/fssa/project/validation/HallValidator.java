package com.fssa.project.validation;

import com.fssa.project.exception.ValidationException;
import com.fssa.project.model.Hall;

public class HallValidator {
    private Hall hall;

    public HallValidator(Hall hall) {
        this.hall = hall;
    }

    public void validateAll() throws ValidationException {
        validateHallName();
        validateHallLocation();
        validateMobileNumber();
    }

    public void validateHallName() throws ValidationException {
        if (hall.getHallName() == null || hall.getHallName().isEmpty()) {
            throw new ValidationException("Hall name is required.");
        }
        // Additional validation rules for hall name if needed
    }

    public void validateHallLocation() throws ValidationException {
        if (hall.getHallLocation() == null || hall.getHallLocation().isEmpty()) {
            throw new ValidationException("Hall location is required.");
        }
        // Additional validation rules for hall location if needed
    }

    public void validateMobileNumber() throws ValidationException {
        if (hall.getMobileNumber() == null || hall.getMobileNumber().isEmpty()) {
            throw new ValidationException("Mobile number is required.");
        }
        // Additional validation rules for mobile number if needed
        String mobileNumber = hall.getMobileNumber();
        String regex = "^[0-9]{10}$"; // Regex for 10-digit mobile number
        if (!mobileNumber.matches(regex)) {
            throw new ValidationException("Invalid mobile number format.");
        }
    }

	public Object validateAll1() {
		// TODO Auto-generated method stub
		return null;
	}
}

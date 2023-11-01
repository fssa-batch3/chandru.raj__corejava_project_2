package com.fssa.project.validation;

import java.util.regex.Matcher;
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

        validateHallName(hall.getHallName());
        validateHallLocation(hall.getHallLocation());
        validateMobileNumber(hall.getMobileNumber());
        validateCapacity(hall.getCapacity());
        validatePricing(hall.getPricing());
        validateImageUrl(hall.getUrl());
        validateImageUrl(hall.getUrl1());
        validateImageUrl(hall.getUrl2());
        validateImageUrl(hall.getUrl3());
        validateImageUrl(hall.getUrl4());
        validateImageUrl(hall.getUrl5());
        validateImageUrl(hall.getUrl6());
    }

    private static void validateHallName(String hallName) throws ValidationException {
        if (hallName == null || hallName.isEmpty()) {
            throw new ValidationException("Hall name is required");
        }

        String hallNamePattern = "^[A-Za-z0-9\\s]+$"; // Example pattern allowing letters, numbers, and spaces

        if (!Pattern.matches(hallNamePattern, hallName)) {
            throw new ValidationException("Invalid hall name");
        }
    }

    private static void validateHallLocation(String hallLocation) throws ValidationException {
        if (hallLocation == null || hallLocation.isEmpty()) {
            throw new ValidationException("Hall location is required");
        }

        String hallLocationRegex = "^[A-Za-z0-9\\s]+$"; // Modify the pattern as needed

        Pattern pattern = Pattern.compile(hallLocationRegex);

        Matcher matcher = pattern.matcher(hallLocation);
        if (!matcher.matches()) {
            throw new ValidationException("Invalid hall location format");
        }
    }

    private static void validateMobileNumber(String mobileNumber) throws ValidationException {
        if (mobileNumber == null || mobileNumber.isEmpty()) {
            throw new ValidationException("Mobile number is required");
        }

        String mobileNumberRegex = "^[0-9]+$"; // This pattern allows only numeric characters

        Pattern pattern = Pattern.compile(mobileNumberRegex);

        Matcher matcher = pattern.matcher(mobileNumber);
        if (!matcher.matches()) {
            throw new ValidationException("Invalid mobile number format. Please enter numbers only.");
        }
    }

    private static void validateCapacity(String capacity) throws ValidationException {
        if (capacity == null || capacity.isEmpty()) {
            throw new ValidationException("Capacity is required");
        }

        String capacityRegex = "^[0-9]{0,4}$"; // This pattern allows exactly 4 numeric characters

        Pattern pattern = Pattern.compile(capacityRegex);

        Matcher matcher = pattern.matcher(capacity);
        if (!matcher.matches()) {
            throw new ValidationException("Invalid capacity. Capacity must consist of 4 digits.");
        }
    }

    private static void validatePricing(String pricing) throws ValidationException {
        if (pricing == null || pricing.isEmpty()) {
            throw new ValidationException("Pricing is required");
        }

        String pricingRegex = "^[0-9]+(\\.[0-9]{2})?$";

        Pattern pattern = Pattern.compile(pricingRegex);

        Matcher matcher = pattern.matcher(pricing);
        if (!matcher.matches()) {
            throw new ValidationException("Invalid pricing format. Please enter a valid price.");
        }
    }

    private static void validateImageUrl(String imageUrl) throws ValidationException {
        if (imageUrl != null && !imageUrl.isEmpty()) {
        	String regex = "\\bhttps://\\S+";
            Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

            Matcher matcher = pattern.matcher(imageUrl);
            if (!matcher.matches()) {
                throw new ValidationException("Invalid image URL");
            }
        }
    }
}

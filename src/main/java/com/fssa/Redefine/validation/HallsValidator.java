package com.fssa.redefine.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import com.fssa.redefine.model.Halls;
import com.fssa.redefine.validation.exception.InvalidUserException;

public class HallsValidator {
  public static boolean ValidateHall(Halls halls) throws InvalidUserException {
	  if(halls != null && validateName(halls.getHall_name())&&validateLocation(halls.getHall_location())&&validateNumber(halls.getMobile_no())) {
		  return true;
	  }  else { 
		  throw new InvalidUserException("It is not a valid hall");
	  }
	  
	  }
  


private static boolean validateNumber(String mobile_no) {
	// TODO Auto-generated method stub
	return false;
}



public static boolean validateName(String hall_name) {
	boolean match = false;
	
		String regex = "^[A-Za-z0-9_]{3,30}$";
		match = Pattern.matches(regex, hall_name);
	if (match) {
		System.out.println("The Hall Name is Valid");
	} else {
		System.out.println("The Hall Name is not Valid ");
	}

	
	return  match;

	}
public static boolean validateLocation(String hall_location) {
	boolean match = false;
	
		String regex = "^[A-Za-z0-9_]{3,30}$";
		match = Pattern.matches(regex, hall_location);
		if (match) {
			System.out.println("The hall location is valid");
		}else {
			System.out.println("The hall location is Invalid");
		}

		return match;
	}
		
	
	
	
	public static boolean validateNumber(int value) {
        String stringValue = Integer.toString(value);
        String regex = "\\d+"; 
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(stringValue);
        
        return matcher.matches();
    }	

}


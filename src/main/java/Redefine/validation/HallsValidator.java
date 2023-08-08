package Redefine.validation;

import Redefine.model.Halls;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HallsValidator {
  public static boolean ValidateHall(Halls halls) {
	  if(halls != null && validateName(halls.getHall_name())&&validateLocation(halls.getHall_location())&&validateNumber(halls.getMobile_no())) {
		  return true;
	  }  else { throw new InvalidHallException("It is not a valid hall");
	  
	  }
  }
}

public static boolean validateName(String hall_name) {
	boolean match = false;
	try {
		String regex = "^[A-Za-z0-9_]{3,30}$";
		match = Pattern.matches(regex, hall_name);
	if (match) {
		System.out.println("The Hall Name is Valid");
	} else {
		System.out.println("The Hall Name is not Valid ");
	}
	}
	return  match;
}

public static boolean validateLocation(String hall_location) {
	boolean match = false;
	try {
		String regex = "^[A-Za-z0-9_]{3,30}$";
		match = Pattern.matches(regex, hall_location);
		if (match) {
			System.out.println("The hall location is valid");
		}else {
			System.out.println("The hall location is Invalid");
		}
		}
	return match;
	}


public static boolean validateNumber



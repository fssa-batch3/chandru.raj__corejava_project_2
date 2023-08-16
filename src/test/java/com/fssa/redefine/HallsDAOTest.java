package com.fssa.redefine;

import com.fssa.redefine.model.Halls;
import com.fssa.redefine.services.HallsService;
import com.google.protobuf.ServiceException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class HallsDAOTest {

	@Test
	public void testAddHallSuccess() {
	    Halls halls = new Halls("chandru", "karuppampulam", 9876);

	    try {
	        HallsService hallsService = new HallsService();
	        boolean result = hallsService.addHall(halls);
	        assertTrue(result);
	        System.out.println("Test passed: Hall added successfully.");
	    } catch (ServiceException e) {
	        e.printStackTrace();
	        fail("Exception occurred: " + e.getMessage());
	    }
	}
	
	public void testAddHallFailure() {
	    Halls halls = new Halls(null, "karuppampulam", 9876);

	    try {
	        HallsService hallsService = new HallsService();
	        boolean result = hallsService.addHall(halls);
	        assertFalse(result); 
	        System.out.println("Test passed: Hall addition should have failed.");
	    } catch (ServiceException e) {
	        
	        System.out.println("Expected exception: " + e.getMessage());
	    }
	}

}

package com.fssa.redefine;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.redefine.model.Halls;
import com.fssa.redefine.services.HallsService;
import com.google.protobuf.ServiceException;

public class HallsServiceTest {
    @Test
    public void testUpdateHallSuccess() {
        Halls updatedHall = new Halls("chandru3737", "Ajmal", 9753);
        updatedHall.setHall_name("chandru3737");  // Assuming this is the name of the hall you want to update

        HallsService hallsService = new HallsService();

        try {
            boolean result = hallsService.updateHall(updatedHall);
            assertTrue(result);
            System.out.println("Test passed: Hall updated successfully.");
        } catch (ServiceException e) {
        	 System.out.println("Test passed: Hall updated nogt.");
            e.printStackTrace();
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testUpdateHallInvalidName() {
        Halls updatedHall = new Halls(null, "New Location", 123456);  // Invalid name

        HallsService hallsService = new HallsService();

        try {
            hallsService.updateHall(updatedHall);
            fail("Expected ServiceException due to invalid hall name.");
        } catch (ServiceException e) {
            System.out.println("Expected exception: " + e.getMessage());
        }
    }
}

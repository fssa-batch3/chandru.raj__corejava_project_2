package com.fssa.project.service;

import com.fssa.project.exception.ServiceException;
import com.fssa.project.model.Hall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HallServiceTest {

    private HallService hallService;

    @BeforeEach
    public void setup() {
        hallService = new HallService();
    }

    @Test
    public void testCreateHall() throws ServiceException {
        Hall hall = new Hall("HallName", "HallLocation", "1234567890");
        String result = hallService.createHall(hall);
        assertEquals("Hall Created Successfully", result);
    }

    @Test
    public void testCreateHallWithInvalidData() {
        Hall hall = new Hall("", "HallLocation", "1234567890");
        assertThrows(ServiceException.class, () -> hallService.createHall(hall));
    }

    @Test
    public void testReadHall() throws ServiceException {
        Hall hall = new Hall("HallName", "HallLocation", "1234567890");
        hallService.createHall(hall);

        Hall retrievedHall = hallService.readHall(1);
        assertNotNull(retrievedHall);
        assertEquals("HallName", retrievedHall.getHallName());
    }

    @Test
    public void testReadNonExistentHall() {
        assertThrows(ServiceException.class, () -> hallService.readHall(9));
    }

    @Test
    public void testUpdateHall() throws ServiceException {
        Hall hall = new Hall("HallName", "HallLocation", "1234567890");
        hallService.createHall(hall);

        Hall updatedHall = new Hall("HallName", "NewLocation", "9876543210");
        String result = hallService.updateHall(updatedHall);
        assertEquals("Hall Updated Successfully", result);

        Hall retrievedHall = hallService.readHall(9);
        assertNotNull(retrievedHall);
        assertEquals("NewLocation", retrievedHall.getHallLocation());
    }

    @Test
    public void testDeleteHall() throws ServiceException {
        Hall hall = new Hall("HallName", "HallLocation", "1234567890");
        hallService.createHall(hall);

        String result = hallService.deleteHall(8);
        assertEquals("Hall Deleted Successfully", result);

        assertThrows(ServiceException.class, () -> hallService.readHall(7));
    }

    @Test
    public void testDeleteNonExistentHall() {
        assertThrows(ServiceException.class, () -> hallService.deleteHall(3));
    }
}

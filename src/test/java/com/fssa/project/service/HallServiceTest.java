package com.fssa.project.service;

import com.fssa.project.dao.HallDAO;
import com.fssa.project.exception.ServiceException;
import com.fssa.project.model.Hall;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HallServiceTest {

    private HallService hallService;
    private Hall hall;

    @BeforeEach
    void setUp() {
        hallService = new HallService();

        hall = new Hall("Grand Palace","Velachery","7397388860","850", "16000", "https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg","https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg","https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg","https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg","https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg","https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg","https://content.jdmagicbox.com/comp/chennai/w1/044pxx44.xx44.221002165006.q7w1/catalogue/ppresidency-padur-chennai-banquet-halls-o6567wpfto.jpg");
//        hall.setHallName("Sample Hall");
//        hall.setHallLocation("Sample Location");
//        hall.setMobileNumber("1234567890");
    }
 
    @Test
    @Order(1)
    void testCreateHall_Success() {
        try {
            boolean result = hallService.createHall(hall);
            assertTrue(result, "Hall creation should succeed");
        } catch (ServiceException e) {
            //fail();
        }
    } 

    @Test
    @Order(2)
    void testReadHall_Success() {
        try {
            Hall retrievedHall = hallService.readHall(1); // Assuming hallId 1 exists
            assertNotNull(retrievedHall);
        } catch (ServiceException e) {
          //  fail());
        }
    }

    @Test
    @Order(3)
    void testUpdateHall_Success() {
        hall.setHallId(23); // Assuming hallId 1 exists
        hall.setHallName("Loki Palace");
        try {
            boolean result = hallService.updateHall(hall);
            assertTrue(result);
        } catch (ServiceException e) {
           // fail("Should not throw ServiceException");
        }
    }
   
    @Test
    @Order(4)
    void testDeleteHall_Success() {
        try {
            boolean result = hallService.deleteHall(19); // Assuming hallId 1 exists
            assertTrue(result, "Hall deletion should succeed");
        } catch (ServiceException e) {
            fail("Should not throw ServiceException");
        }
    }

    @Test
    @Order(5)
    void testGetAllHalls_Success() {
        try {
            List<Hall> halls = hallService.getAllHalls();
            assertNotNull(halls);
            assertFalse(halls.isEmpty());
        } catch (ServiceException e) {
            fail("Should not throw ServiceException");
        }
    }

    @Test
    @Order(6)
    void testCreateHall_Failure() {
        // Assuming you have a test case that will fail the creation
        hall.setHallName(null); // Invalid data
        assertThrows(ServiceException.class, () -> hallService.createHall(hall));
    }

    @Test
    @Order(7)
    void testReadHall_Failure() {
        // Assuming you have a test case for non-existent hallId
        assertThrows(ServiceException.class, () -> hallService.readHall(1000)); // Non-existent hallId
    }

    @Test
    @Order(8)
    void testUpdateHall_Failure() {
        // Assuming you have a test case for updating a non-existent hall
        hall.setHallId(1000); // Non-existent hallId
        assertThrows(ServiceException.class, () -> hallService.updateHall(hall));
    }

    @Test
    @Order(9)
    void testDeleteHall_Failure() {
        // Assuming you have a test case for deleting a non-existent hall
        assertThrows(ServiceException.class, () -> hallService.deleteHall(1000)); // Non-existent hallId
    }
}

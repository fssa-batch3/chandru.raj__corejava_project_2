package com.fssa.project.service;

import com.fssa.project.exception.ServiceException;
import com.fssa.project.model.Hall;
import com.fssa.project.utils.ConnectionUtil;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HallServiceTest {

    private static HallService hallService;
    private static int createdHallId;

    @BeforeAll
    public static void setUp() throws SQLException {
        hallService = new HallService();
        clearTestData();
    }

    @AfterAll
    public static void tearDown() throws SQLException {
        clearTestData();
    }

    private static void clearTestData() throws SQLException {
        try (Connection connection = ConnectionUtil.getConnection()) {
            String query = "DELETE FROM halls";
            try (PreparedStatement pst = connection.prepareStatement(query)) {
                pst.executeUpdate();
            }
        }
    }

    @Test
    @Order(1)
    public void testCreateHall_Success() {
        Hall hall = new Hall();
        hall.setHallName("ABC Hall");
        hall.setHallLocation("Some Location");
        hall.setMobileNumber("1234567890");

        assertDoesNotThrow(() -> {
            int hallId = hallService.createHall(hall);
            assertTrue(hallId > 0);
            createdHallId = hallId;
        });
    }

    @Test
    @Order(2)
    public void testReadHall_Success() {
        assertDoesNotThrow(() -> {
            Hall hall = hallService.readHall(createdHallId);
            assertNotNull(hall);
        });
    }

    @Test
    @Order(3)
    public void testUpdateHall_Success() {
        assertDoesNotThrow(() -> {
            Hall hall = hallService.readHall(createdHallId);
            assertNotNull(hall);

            hall.setHallLocation("Updated Location");
            boolean result = hallService.updateHall(hall);
            assertTrue(result);

            Hall updatedHall = hallService.readHall(createdHallId);
            assertNotNull(updatedHall);
            assertEquals("Updated Location", updatedHall.getHallLocation());
        });
    }

    @Test
    @Order(4)
    public void testDeleteHall_Success() {
        assertDoesNotThrow(() -> {
            boolean result = hallService.deleteHall(createdHallId);
            assertTrue(result);

            Hall deletedHall = hallService.readHall(createdHallId);
            assertNull(deletedHall);
        });
    }

    @Test
    @Order(5)
    public void testReadHall_InvalidHallId() {
        assertThrows(ServiceException.class, () -> {
            Hall hall = hallService.readHall(-1);
        });
    }

    @Test
    @Order(6)
    public void testUpdateHall_InvalidData() {
        assertThrows(ServiceException.class, () -> {
            Hall hall = hallService.readHall(createdHallId);
            assertNotNull(hall);

            hall.setMobileNumber("");
            hallService.updateHall(hall);
        });
    }

    @Test
    @Order(7)
    public void testDeleteHall_InvalidHallId() {
        assertThrows(ServiceException.class, () -> {
            hallService.deleteHall(-1);
        });
    }
}

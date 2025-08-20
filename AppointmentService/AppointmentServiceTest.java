import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.Calendar;
import org.junit.jupiter.api.BeforeEach;

class AppointmentServiceTest {
	
	//Init map variables
	private AppointmentService service;
	private Appointment appointment1;
	
	//Testing helper function for getting a future or prior date
	private Date getTestDate(int numDays) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, numDays);
		return calendar.getTime();
	}
	
	//Setup for each test
	@BeforeEach
	void setUp() {
		service = new AppointmentService();
		Date futureDate = getTestDate(7);
		appointment1 = new Appointment("042", futureDate, "7 Days from now.");		
	}

	//Service tests
    @Test
    @DisplayName("Add Valid Appointment")
    void testAddValidAppointment() {
		service.addAppointment(appointment1);
		Appointment addedAppointment = service.getAppointment("042");
		assertNotNull(addedAppointment);
		assertEquals(appointment1.getAppointmentID(), addedAppointment.getAppointmentID());
		assertEquals(appointment1.getDate(), addedAppointment.getDate());
		assertEquals(appointment1.getDescription(), addedAppointment.getDescription());
	}
    
    @Test
    @DisplayName("Catch Duplicate Add Appointment")
    void testDuplicateAddAppointment() {
    	service.addAppointment(appointment1);
		assertThrows(IllegalArgumentException.class, () -> {
			service.addAppointment(appointment1);
		});
    }

    @Test
    @DisplayName("Catch Null Add Appointment")
    void testNullAddAppointment() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.addAppointment(null);
		});
    }
    
    @Test
    @DisplayName("Test Valid Delete Appointment")
    void testValidDeleteAppointment() {
    	service.addAppointment(appointment1);
    	service.deleteAppointment("042");
    	assertNull(service.getAppointment("042"));
    }
    
    @Test
    @DisplayName("Catch Delete Non-Existing Appointment")
    void testDeleteNonExistingAppointment() {
    	assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment("042");
        });
    }
    
    @Test
    @DisplayName("Catch Delete Null Appointment")
    void testDeleteNullAppointment() {
    	assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment(null);
        });
    }
}

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.Calendar;

class AppointmentTest {
	//Testing helper function for getting a future or prior date
	private Date getTestDate(int numDays) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, numDays);
		return calendar.getTime();
	}
	
	//Constructor tests
	@Test
	@DisplayName("Valid Appointment Creation")
	void testValidAppointment() {
		Date futureDate = getTestDate(7);
		Appointment newAppointment = new Appointment("042", futureDate, "7 Days from now.");
		assertNotNull(newAppointment);
		assertEquals("042", newAppointment.getAppointmentID());
		assertEquals(futureDate, newAppointment.getDate());
		assertEquals("7 Days from now.", newAppointment.getDescription());
	}

	@Test
	@DisplayName("Catch Null Appointment ID")
	void testNullAppointmentID() {
		Date futureDate = getTestDate(7);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, futureDate, "7 Days from now.");
        });
	}
	
	@Test
	@DisplayName("Catch Too Long Appointment ID")
	void testTooLongAppointmentID() {
		Date futureDate = getTestDate(7);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("0420123456789", futureDate, "7 Days from now.");
        });
	}
	
	@Test
	@DisplayName("Catch Null Appointment Date")
	void testNullAppointmentDate() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("042", null, "7 Days from now.");
        });
    }
	
	@Test
	@DisplayName("Catch Previous Appointment Date")
	void testPreviousAppointmentDate() {
		Date previousDate = getTestDate(-7);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("042", previousDate, "7 Days prior.");
        });	
    }
	
	@Test
	@DisplayName("Catch Null Appointment Description")
	void testNullAppointmentDescription() {
		Date futureDate = getTestDate(7);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("042", futureDate, null);
        });	
    }
	
	@Test
	@DisplayName("Catch Too Long Appointment Description")
	void testTooLongAppointmentDescription() {
		Date futureDate = getTestDate(7);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("042", futureDate, "7 Days from now. 0123456789 0123456789 0123456789 0123456789 0123456789 0123456789");
        });	
    }
	
	//Mutators tests
	@Test
	@DisplayName("Test Valid Set Date") 
	void testValidSetDate() {
		Date futureDate = getTestDate(7);
		Appointment newAppointment = new Appointment("042", futureDate, "7 Days from now.");
		Date newDate = getTestDate(5);
		newAppointment.setDate(newDate);
		assertEquals(newDate, newAppointment.getDate());
	}
	
	@Test
	@DisplayName("Catch Null Set Date")
	void testNullSetDate() {
		Date futureDate = getTestDate(7);
		Appointment newAppointment = new Appointment("042", futureDate, "7 Days from now.");
        assertThrows(IllegalArgumentException.class, () -> {
            newAppointment.setDate(null);
        });	
    }
	
	@Test
	@DisplayName("Catch Set Date in past")
	void testInvalidSetDate() {
		Date futureDate = getTestDate(7);
		Appointment newAppointment = new Appointment("042", futureDate, "7 Days from now.");
		Date previousDate = getTestDate(-14);
        assertThrows(IllegalArgumentException.class, () -> {
            newAppointment.setDate(previousDate);
        });	
    }
	
	@Test
	@DisplayName("Test Valid Set Description") 
	void testValidSetDescription() {
		Date futureDate = getTestDate(7);
		Appointment newAppointment = new Appointment("042", futureDate, "7 Days from now.");
		newAppointment.setDescription("Seven Days from now.");
		assertEquals("Seven Days from now.", newAppointment.getDescription());
	}
	
    @Test
    @DisplayName("Catch Set Null Description")
    void testSetNullDescription() {
    	Date futureDate = getTestDate(7);
		Appointment newAppointment = new Appointment("042", futureDate, "7 Days from now.");
        assertThrows(IllegalArgumentException.class, () -> {
            newAppointment.setDescription(null);
        });
    }

    @Test
    @DisplayName("Catch Too Long Set Description")
    void testTooLongSetDescription() {
    	Date futureDate = getTestDate(7);
		Appointment newAppointment = new Appointment("042", futureDate, "7 Days from now.");
        assertThrows(IllegalArgumentException.class, () -> {
            newAppointment.setDescription("7 Days from now. 0123456789 0123456789 0123456789 0123456789 0123456789 0123456789");
        });
    }
}

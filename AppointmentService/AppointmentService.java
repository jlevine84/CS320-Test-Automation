import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
	//Init key-value Map for Appointments
	private final Map<String, Appointment> appointments = new HashMap<>();
	
	//Add Appointment Method
	public void addAppointment(Appointment appointment) {
		//Validate param is not null or already exists
		if (appointment == null || appointments.containsKey(appointment.getAppointmentID())) {
			throw new IllegalArgumentException("Appointment already exists");
		}
		
		appointments.put(appointment.getAppointmentID(),  appointment);
	}
	
	//Delete Appointment Method
	public void deleteAppointment(String appointmentID) {
		//Validate param is not null or Appointment ID does not exist
		if (appointmentID == null || !appointments.containsKey(appointmentID)) {
			throw new IllegalArgumentException("Delete Appointment unsuccessful. Verify Appointment ID");
		}
		
		appointments.remove(appointmentID);
	}
		
	//Accessor Method for an Appointment (if needed)
	public Appointment getAppointment(String appointmentID) {
		return appointments.get(appointmentID);
	}
}


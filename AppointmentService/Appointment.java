//Import date library
import java.util.Date;

public class Appointment {
	//Variable declarations
	private String appointmentID;
	private Date appointmentDate;
	private String description;
	
	//Constructor with validators
	public Appointment(String appointmentID, Date appointmentDate, String description ) {
		if (appointmentID == null || appointmentID.length() > 10) {
			throw new IllegalArgumentException("Invalid Appointment ID");
		}
		
		this.appointmentID = appointmentID;
		setDate(appointmentDate);
		setDescription(description);
	}
	
	//Accesors
	public String getAppointmentID() {
		return this.appointmentID;
	}
	
	public Date getDate() {
		return this.appointmentDate;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	//Mutators
	public void setDate(Date date) {
		if (date == null || date.before(new Date())) {
			throw new IllegalArgumentException("Invalid Appointment Date");
		}
		
		this.appointmentDate = date;
	}
	
	public void setDescription(String description) {
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Appointment Description");
		}
		
		this.description = description;
	}
}

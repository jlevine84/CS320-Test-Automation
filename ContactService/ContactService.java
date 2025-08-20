import java.util.HashMap;
import java.util.Map;

public class ContactService {
	//Init key-value Map for Contacts
	private final Map<String, Contact> contacts = new HashMap<>();
	
	//Add Contact Method
	public void addContact(Contact contact) {
		//Validate param is not null or already exists
		if (contact == null || contacts.containsKey(contact.getContactID())) {
			throw new IllegalArgumentException("Contact already exists");
		}
		
		contacts.put(contact.getContactID(),  contact);
	}
	
	//Delete Contact Method
	public void deleteContact(String contactID) {
		//Validate param is not null or Contact ID does not exist
		if (contactID == null || !contacts.containsKey(contactID)) {
			throw new IllegalArgumentException("Delete Contact unsuccessful. Verify Contact ID");
		}
		
		contacts.remove(contactID);
	}
	
	//Update Contact Method
	public void updateContact(String contactID, String firstName, String lastName, String phone, String address) {
		//Get existing Contact or null instantiation for validation
		Contact existingContact = contacts.get(contactID);
		
		if (existingContact == null) {
			throw new IllegalArgumentException("No valid Contact found");
		}
		
		//Update any non-null values
		if (firstName != null) {
			existingContact.setFirstName(firstName);
		}
		
		if (lastName != null) {
			existingContact.setLastName(lastName);
		}
		
		if (phone != null) {
			existingContact.setPhone(phone);
		}
		
		if (address != null) {
			existingContact.setAddress(address);
		}
	}
	
	//Accessor Method for a Contact (if needed)
	public Contact getContact(String contactID) {
		return contacts.get(contactID);
	}
}

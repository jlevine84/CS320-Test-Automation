import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
	//Instantiate map variables
	private ContactService service;
	private Contact contact1;
	private Contact contact2;
	
	//Set up for tests
	@BeforeEach
	void setUp() {
		service = new ContactService();
		contact1 = new Contact("cont1", "Zaphod", "Beeblebrox", "1234567890", "42 Hoopy Frood Lane");
		contact2 = new Contact("cont2", "Arthur", "Dent", "0987654321", "Somewhere in England");
	}

	//Updated for additional coverage and edge cases
	@Test
	@DisplayName("Test valid add contact")
	void testValidAddContact() {
		service.addContact(contact1);
		assertNotNull(service.getContact("cont1"));
		assertEquals("Zaphod", service.getContact("cont1").getFirstName());
	}
	
	@Test
	@DisplayName("Catch duplicate add contact")
	void testDuplicateContact() {
		service.addContact(contact1);
		assertThrows(IllegalArgumentException.class, () -> {
			service.addContact(contact1);
		});
	}
	
	@Test
	@DisplayName("Catch null add contact")
	void testNullAddContact() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.addContact(null);
		});
	}
	
	@Test
	@DisplayName("Test valid delete contact")
	void testValidDeleteContact() {
		service.addContact(contact1);
		assertNotNull(service.getContact("cont1"));
		service.deleteContact("cont1");
		assertNull(service.getContact("cont1"));
	}

	@Test
	@DisplayName("Catch invalid delete contact")
	void testInvalidDeleteContact() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.deleteContact("cont3");
		});
	}
	
	@Test
	@DisplayName("Catch null ID on delete")
	void testNullIDOnDelete() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.deleteContact(null);
		});
	}
	
	@Test
	@DisplayName("Test valid update contact (all fields)")
	void testValidUpdateContact() {
		service.addContact(contact2);
		service.updateContact("cont2", "Ford", "Prefect", "7894561230", "Near Betelgeuse");
		
		Contact updatedContact2 = service.getContact("cont2");
		assertEquals("Ford", updatedContact2.getFirstName());
		assertEquals("Prefect", updatedContact2.getLastName());
		assertEquals("7894561230", updatedContact2.getPhone());
		assertEquals("Near Betelgeuse", updatedContact2.getAddress());
	}
	
	@Test
	@DisplayName("Test update contact with null first name - others updated")
	void testUpdateContactNullFirstName() {
		service.addContact(contact1);
		service.updateContact("cont1", null, "Prefect", "7894561230", "Near Betelgeuse");
		Contact updatedContact = service.getContact("cont1");
		assertEquals("Zaphod", updatedContact.getFirstName());
		assertEquals("Prefect", updatedContact.getLastName());
	}
	
	@Test
	@DisplayName("Test update contact with null last name - others updated")
	void testUpdateContactNullLastName() {
		service.addContact(contact1);
		service.updateContact("cont1", "Ford", null, "7894561230", "Near Betelgeuse");
		Contact updatedContact = service.getContact("cont1");
		assertEquals("Ford", updatedContact.getFirstName());
		assertEquals("Beeblebrox", updatedContact.getLastName());
	}
	
	@Test
	@DisplayName("Test update contact with null phone - others updated")
	void testUpdateContactNullPhone() {
		service.addContact(contact1);
		service.updateContact("cont1", "Ford", "Prefect", null, "Near Betelgeuse");
		Contact updatedContact = service.getContact("cont1");
		assertEquals("Ford", updatedContact.getFirstName());
		assertEquals("1234567890", updatedContact.getPhone());
	}
	
	@Test
	@DisplayName("Test update contact with null address - others updated")
	void testUpdateContactNullAddress() {
		service.addContact(contact1);
		service.updateContact("cont1", "Ford", "Prefect", "7894561230", null);
		Contact updatedContact = service.getContact("cont1");
		assertEquals("Ford", updatedContact.getFirstName());
		assertEquals("42 Hoopy Frood Lane", updatedContact.getAddress());
	}
	
	@Test
	@DisplayName("Catch non-existing update contact")
	void testNonExistingUpdateContact() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateContact("cont3", "Trisha", "McMillan", "9638527410", "Destroyed Earth");
		});
	}
	
	@Test
	@DisplayName("Catch invalid update contact First Name")
	void testInvalidUpdateContactFirstName() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateContact("cont2", "Trisha (Trillion)", null, null, null);
		});
	}
	
	@Test
	@DisplayName("Catch invalid update contact Last Name")
	void testInvalidUpdateContactLastName() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateContact("cont2", null, "012345678901234567890123456789012345678901234567890123456789", null, null);
		});
	}
	
	@Test
	@DisplayName("Catch invalid update contact phone")
	void testInvalidUpdateContactPhone() {
		service.addContact(contact1);
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateContact("cont1", null, null, "12345", null);
		});
	}
	
	@Test
	@DisplayName("Catch invalid update contact address")
	void testInvalidUpdateContactAddress() {
		service.addContact(contact1);
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateContact("cont1", null, null, null, "012345678901234567890123456789012345678901234567890123456789");
		});
	}
}

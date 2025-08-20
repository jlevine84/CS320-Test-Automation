import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class ContactTest {
	//Testing Constructor and initial variable validations
	@Test
	@DisplayName("Valid Constructor test")
	void testContactCreation() {
		Contact newContact = new Contact("042", "Zaphod", "Beeblebrox", "1234567890", "42 Hoopy Frood Lane");
		assertNotNull(newContact);
		assertEquals("042", newContact.getContactID());
		assertEquals("Zaphod", newContact.getFirstName());
		assertEquals("Beeblebrox", newContact.getLastName());
		assertEquals("1234567890", newContact.getPhone());
		assertEquals("42 Hoopy Frood Lane", newContact.getAddress());		
	}
	
	@Test
	@DisplayName("Catch invalid contact ID length")
	void testContactIDInvalidLength() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890042", "Zaphod", "Beeblebrox", "1234567890", "42 Hoopy Frood Lane");
		});
	}

	@Test
	@DisplayName("Catch null contact ID")
	void testNullContactID() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Zaphod", "Beeblebrox", "1234567890", "42 Hoopy Frood Lane");
		});
	}
	
	@Test
	@DisplayName("Catch invalid first name length")
	void testFirstNameInvalidLength() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("042", "Zaphodious, the Nothingth", "Beeblebrox", "1234567890", "42 Hoopy Frood Lane");
		});
	}
	
	@Test
	@DisplayName("Catch null first name")
	void testNullFirstName() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("042", null, "Beeblebrox", "1234567890", "42 Hoopy Frood Lane");
		});
	}
	
	@Test
	@DisplayName("Catch invalid last name length")
	void testLastNameInvalidLength() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("042", "Zaphod", "Beeblebrox, the Nothingth", "1234567890", "42 Hoopy Frood Lane");
		});
	}
	
	@Test
	@DisplayName("Catch null last name")
	void testNullLastName() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("042", "Zaphod", null, "1234567890", "42 Hoopy Frood Lane");
		});
	}
	
	@Test
	@DisplayName("Catch invalid phone number length and digits")
	void testInvalidPhoneNumberLength() {
		//Less than 10 digits
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("042", "Zaphod", "Beeblebrox", "12345", "42 Hoopy Frood Lane");
		});
		
		//More than 10 digits
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("042", "Zaphod", "Beeblebrox", "123456789012345", "42 Hoopy Frood Lane");
		});
		
		//Contains a non-digit
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("042", "Zaphod", "Beeblebrox", "123456J890", "42 Hoopy Frood Lane");
		});
	}
	
	@Test
	@DisplayName("Catch null phone number")
	void testNullPhoneNumber() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("042", "Zaphod", "Beeblebrox", null, "42 Hoopy Frood Lane");
		});
	}
	
	@Test
	@DisplayName("Catch invalid address length")
	void testInvalidAddressLength() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("042", "Zaphod", "Beeblebrox", "1234567890", "42 Hoopy Frood Lane, The restaurant at the end of the Universe");
		});
	}
	
	@Test
	@DisplayName("Catch null address")
	void testNullAddress() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("042", "Zaphod", "Beeblebrox", "1234567890", null);
		});
	}
	
	// Updated to test each set method and individual tests for accessors
	// Mutator tests
	@Test
	@DisplayName("Test valid set first name")
	void testSetFirstNameValid() {
		Contact newContact = new Contact("042", "Zaphod", "Beeblebrox", "1234567890", "42 Hoopy Frood Lane");
		newContact.setFirstName("Ford");
		assertEquals("Ford", newContact.getFirstName());
	}

	@Test
	@DisplayName("Catch null set first name")
	void testSetFirstNameNull() {
		Contact newContact = new Contact("042", "Zaphod", "Beeblebrox", "1234567890", "42 Hoopy Frood Lane");
		assertThrows(IllegalArgumentException.class, () -> {
			newContact.setFirstName(null);
		});
	}
	
	@Test
	@DisplayName("Catch too long set first name")
	void testSetFirstNameInvalidLength() {
		Contact newContact = new Contact("042", "Zaphod", "Beeblebrox", "1234567890", "42 Hoopy Frood Lane");
		assertThrows(IllegalArgumentException.class, () -> {
			newContact.setFirstName("Zaphodious1234567890");
		});
	}
	
	@Test
	@DisplayName("Test valid set last name")
	void testSetLastNameValid() {
		Contact newContact = new Contact("042", "Zaphod", "Beeblebrox", "1234567890", "42 Hoopy Frood Lane");
		newContact.setLastName("Prefect");
		assertEquals("Prefect", newContact.getLastName());
	}
	
	@Test
	@DisplayName("Catch null set last name")
	void testSetLastNameNull() {
		Contact newContact = new Contact("042", "Zaphod", "Beeblebrox", "1234567890", "42 Hoopy Frood Lane");
		assertThrows(IllegalArgumentException.class, () -> {
			newContact.setLastName(null);
		});
	}
	
	@Test
	@DisplayName("Catch too long set last name")
	void testSetLastNameInvalidLength() {
		Contact newContact = new Contact("042", "Zaphod", "Beeblebrox", "1234567890", "42 Hoopy Frood Lane");
		assertThrows(IllegalArgumentException.class, () -> {
			newContact.setLastName("Beeblebrox, the Nothingth");
		});
	}
	
	@Test
	@DisplayName("Test valid set phone")
	void testSetPhoneValid() {
		Contact newContact = new Contact("042", "Zaphod", "Beeblebrox", "1234567890", "42 Hoopy Frood Lane");
		newContact.setPhone("0987654321");
		assertEquals("0987654321", newContact.getPhone());
	}
	
	@Test
	@DisplayName("Catch null set phone")
	void testSetPhoneNull() {
		Contact newContact = new Contact("042", "Zaphod", "Beeblebrox", "1234567890", "42 Hoopy Frood Lane");
		assertThrows(IllegalArgumentException.class, () -> {
			newContact.setPhone(null);
		});
	}
	
	@Test
	@DisplayName("Catch too long set phone")
	void testSetPhoneTooLong() {
		Contact newContact = new Contact("042", "Zaphod", "Beeblebrox", "1234567890", "42 Hoopy Frood Lane");
		assertThrows(IllegalArgumentException.class, () -> {
			newContact.setPhone("09876543210987654321");
		});
	}

	@Test
	@DisplayName("Catch too short set phone")
	void testSetPhoneTooShort() {
		Contact newContact = new Contact("042", "Zaphod", "Beeblebrox", "1234567890", "42 Hoopy Frood Lane");
		assertThrows(IllegalArgumentException.class, () -> {
			newContact.setPhone("12345");
		});
	}
	
	@Test
	@DisplayName("Test valid set address")
	void testSetAddressValid() {
		Contact newContact = new Contact("042", "Zaphod", "Beeblebrox", "1234567890", "42 Hoopy Frood Lane");
		newContact.setAddress("Near Betelgeuse");
		assertEquals("Near Betelgeuse", newContact.getAddress());
	}
	
	@Test
	@DisplayName("Catch null set address")
	void testSetAddressNull() {
		Contact newContact = new Contact("042", "Zaphod", "Beeblebrox", "1234567890", "42 Hoopy Frood Lane");
		assertThrows(IllegalArgumentException.class, () -> {
			newContact.setAddress(null);
		});
	}
	
	@Test
	@DisplayName("Catch too long set address")
	void testSetAddressTooLong() {
		Contact newContact = new Contact("042", "Zaphod", "Beeblebrox", "1234567890", "42 Hoopy Frood Lane");
		assertThrows(IllegalArgumentException.class, () -> {
			newContact.setAddress("42 Hoopy Frood Lane, The restaurant at the end of the Universe");
		});
	}
	
	
	@Test
	@DisplayName("Test getContactID accessor")
	void testGetContactID() {
		Contact newContact = new Contact("042", "Zaphod", "Beeblebrox", "1234567890", "42 Hoopy Frood Lane");
		assertEquals("042", newContact.getContactID());
	}

	@Test
	@DisplayName("Test getFirstName accessor")
	void testGetFirstName() {
		Contact newContact = new Contact("042", "Zaphod", "Beeblebrox", "1234567890", "42 Hoopy Frood Lane");
		assertEquals("Zaphod", newContact.getFirstName());
	}

	@Test
	@DisplayName("Test getLastName accessor")
	void testGetLastName() {
		Contact newContact = new Contact("042", "Zaphod", "Beeblebrox", "1234567890", "42 Hoopy Frood Lane");
		assertEquals("Beeblebrox", newContact.getLastName());
	}

	@Test
	@DisplayName("Test getPhone accessor")
	void testGetPhone() {
		Contact newContact = new Contact("042", "Zaphod", "Beeblebrox", "1234567890", "42 Hoopy Frood Lane");
		assertEquals("1234567890", newContact.getPhone());
	}

	@Test
	@DisplayName("Test getAddress accessor")
	void testGetAddress() {
		Contact newContact = new Contact("042", "Zaphod", "Beeblebrox", "1234567890", "42 Hoopy Frood Lane");
		assertEquals("42 Hoopy Frood Lane", newContact.getAddress());
	}
}


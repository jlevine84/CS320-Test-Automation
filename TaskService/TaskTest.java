import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TaskTest {

	@Test
	@DisplayName("Valid Constructor Test")
	void testValidConstructor() {
		Task newTask = new Task("042", "Heart of Gold", "A spaceship");
		assertNotNull(newTask);
		assertEquals("042", newTask.getTaskID());
		assertEquals("Heart of Gold", newTask.getName());
		assertEquals("A spaceship", newTask.getDescription());
	}
	
	@Test
	@DisplayName("Catch Invalid Task ID length")
	void testInvalidTaskIDLength() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234567890042", "Heart of Gold", "A spaceship");
		});
	}
	
	@Test
	@DisplayName("Catch Null Task ID")
	void testNullTaskID() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "Heart of Gold", "A spaceship");
		});
	}
	
	@Test
	@DisplayName("Catch Invalid Name Length")
	void testInvalidNameLength() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("042", "Heart of Gold, Heart of Gold, Heart of Gold", "A spaceship");
		});
	}
	
	@Test
	@DisplayName("Catch Null Task Name")
	void testNullTaskName() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("042", null, "A spaceship");
		});
	}
	
	@Test
	@DisplayName("Catch Invalid Description Length")
	void testInvalidDescriptionLength() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("042", "Heart of Gold", "A spaceship0123456789012345678901234567890123456789012345678901234567890123456789");
		});
	}
	
	@Test
	@DisplayName("Catch Null Description")
	void testNullDescription() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("042", "Heart of Gold", null);
		});
	}
	
	@Test
	@DisplayName("Valid Update Test")
	void testValidUpdateTest() {
		//Init valid Task
		Task newTask = new Task("042", "Heart of Gold", "A spaceship");
		
		//Valid update: Name
		newTask.setName("The Heart of Gold");
		assertEquals("The Heart of Gold", newTask.getName());
		
		//Valid update: Description
		newTask.setDescription("A better spaceship");
		assertEquals("A better spaceship", newTask.getDescription());
	}
	
	@Test
	@DisplayName("Catch Invalid Update Test")
	void testInvalidUpdateTest() {
		//Init valid Task
		Task newTask = new Task("042", "Heart of Gold", "A spaceship");
		
		//Invalid Name Length
		assertThrows(IllegalArgumentException.class, () -> {
			newTask.setName("Heart of Gold, 01234567890");
		});

		//Null Name
		assertThrows(IllegalArgumentException.class, () -> {
			newTask.setName(null);
		});
		//Invalid Description Length
		assertThrows(IllegalArgumentException.class, () -> {
			newTask.setDescription("A spaceship 01234567890 01234567890 01234567890 01234567890 01234567890");
		});
		
		//Null Description
		assertThrows(IllegalArgumentException.class, () -> {
			newTask.setDescription(null);
		});
	}
}

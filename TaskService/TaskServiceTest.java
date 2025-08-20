import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TaskServiceTest {
	
	//Init map variables
	private TaskService service;
	private Task task1;
	
	//Setup for each test
	@BeforeEach
	void setUp() {
		service = new TaskService();
		task1 = new Task("042", "Heart of Gold", "A spaceship");
	}
	
	@Test
	@DisplayName("Add Valid Task Test")
	void testValidAddTask() {
		service.addTask(task1);
		assertNotNull(service.getTask("042"));
		assertEquals("Heart of Gold", service.getTask("042").getName());
		assertEquals("A spaceship", service.getTask("042").getDescription());
	}
	
	@Test
	@DisplayName("Catch Adding a Duplicate Task")
	void testAddDuplicateTask() {
		service.addTask(task1);
		assertThrows(IllegalArgumentException.class, () -> {
			service.addTask(task1);
		});
	}
	
	@Test
	@DisplayName("Catch Adding Null Task")
	void testAddNullTask() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.addTask(null);
		});
	}
	
	@Test
	@DisplayName("Delete Existing Task")
	void testDeleteExistingTask() {
		service.addTask(task1);
		service.deleteTask("042");
		assertNull(service.getTask("042"));
	}
	
	@Test
	@DisplayName("Catch Delete Null Task")
	void testDeleteNullTask() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.deleteTask(null);
		});
	}

	@Test
	@DisplayName("Catch Delete Non-Existing Task")
	void testDeleteNonexistingTask() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.deleteTask("042");
		});
	}
	
	@Test
	@DisplayName("Update Valid Task's Name and Description")
	void testValidTaskUpdate() {
		service.addTask(task1);
		service.updateTask("042", "Death Star", "Not a moon");
		assertEquals("Death Star", service.getTask("042").getName());
		assertEquals("Not a moon", service.getTask("042").getDescription());		
	}
	
	@Test
	@DisplayName("Update Task with Null Name and Valid Description")
	void testValidUpdateTaskWithNullName() {
		service.addTask(task1);
		service.updateTask("042", null, "Not a moon");
		assertEquals("Heart of Gold", service.getTask("042").getName());
		assertEquals("Not a moon", service.getTask("042").getDescription());
	}

	@Test
	@DisplayName("Update Task with Null Description and Valid Name")
	void testValidUpdateTaskWithNullDescription() {
		service.addTask(task1);
		service.updateTask("042", "Death Star", null);
		assertEquals("Death Star", service.getTask("042").getName());
		assertEquals("A spaceship", service.getTask("042").getDescription());
	}

	@Test
	@DisplayName("Update Task with Both Name and Description Null - No Change")
	void testValidUpdateTaskBothNull() {
		service.addTask(task1);
		service.updateTask("042", null, null);
		assertEquals("Heart of Gold", service.getTask("042").getName());
		assertEquals("A spaceship", service.getTask("042").getDescription());
	}
	
	@Test
	@DisplayName("Catch Update Null ID Task")
	void testUpdateNullIDTask() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateTask(null, "New Name", "New Description");
		});
	}

	@Test
	@DisplayName("Catch Update Non-Existing Task")
	void testUpdateNonExistingTask() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateTask("NoID", "New Name", "New Description");
		});
	}

	@Test
	@DisplayName("Catch Update Task Invalid Name Length")
	void testUpdateTaskInvalidNameLength() {
		service.addTask(task1);
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateTask("042", "Death Star 0123456789 0123456789 0123456789 0123456789", "Valid Description");
		});
	}

	@Test
	@DisplayName("Catch Update Task Invalid Description Length")
	void testUpdateTaskInvalidDescriptionLength() {
		service.addTask(task1);
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateTask("042", "Valid Name", "Not a moon  0123456789 0123456789 0123456789 0123456789 0123456789 0123456789 0123456789");
		});
	}
}

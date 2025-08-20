import java.util.HashMap;
import java.util.Map;

public class TaskService {
	//Init key-value Map for Tasks
	private final Map<String, Task> tasks = new HashMap<>();
	
	//Add Task Method Method
	public void addTask(Task task) {
		//Validate param is not null or already exists
		if (task == null || tasks.containsKey(task.getTaskID())) {
			throw new IllegalArgumentException("Task already exists");
		}
		
		tasks.put(task.getTaskID(),  task);
	}
	
	//Delete Task Method
	public void deleteTask(String taskID) {
		//Validate param is not null or Contact ID does not exist
		if (taskID == null || !tasks.containsKey(taskID)) {
			throw new IllegalArgumentException("Delete Task unsuccessful. Verify Task ID");
		}
		
		tasks.remove(taskID);
	}
	
	//Update Task Method
	public void updateTask(String taskID, String name, String description) {
		//Get existing Task or null instantiation for validation
		Task existingTask = tasks.get(taskID);
		
		if (existingTask == null) {
			throw new IllegalArgumentException("No valid Task found");
		}
		
		//Update any non-null values
		if (name != null) {
			existingTask.setName(name);
		}
		
		if (description != null) {
			existingTask.setDescription(description);
		}
	}
		
	//Accessor Method for a Task (if needed)
	public Task getTask(String taskID) {
		return tasks.get(taskID);
	}
}

import java.util.HashMap;

/**
 * @author yesimyalc
 * @author musosman
 */

public class Task
{
	 private HashMap<Integer, String> allTasks;
	 private Integer TaskId;
	 private String TaskName;
	 private boolean doneTask;
	 
	 /**
	  * Constructor of janitor
	  * @param ID
	  * @param level
	  */
	 public Task(Integer level)
	 {
		 	setAllTasks();
		 	//setTaskName(ID);
			//TaskId=ID;
			taskDifficulty=level;
			doneTask=false;
	 }
	 
	 /**
	  * Sets all the possible tasks that can be registered.
	  */
	 private void setAllTasks()
	 {
		 allTasks=new HashMap<Integer, String>();
		 allTasks.put(001, "Insert a task here");
		 allTasks.put(010, "Insert a task here");
		 allTasks.put(011, "Insert a task here");
		 allTasks.put(100, "Insert a task here");
		 allTasks.put(101, "Insert a task here");
		 allTasks.put(110, "Insert a task here");
		 allTasks.put(111, "Insert a task here");
	 }
	 
	 /**
	  * If there is a registered task for the given ID, sets the task.
	  * If there is not a registered task for the given ID, throws an exception. 
	  * @param ID is the given ID.
	  */
	 private void setTaskName(Integer ID)
	 {
		 String taskName=allTasks.get(ID);
		 if(taskName==null)
			 throw new IllegalArgumentException();
		 else
			 TaskName=taskName;
	 }
	 
	 /**
	 * Getter for TaskId
	 * @return
	 */
	public int getTaskId() 
	{
		return TaskId;
	}
	 
	 /**
     * Getter for TaskName
     * @return TaskName
     */
	public String getTaskName() 
	{
		return TaskName;
	}

    /**
     * Setter for TaskId
     * @param taskId Task Id of the task
     */
	public void setTaskId(int taskId) 
	{
		TaskId = taskId;
		setTaskName(taskId);
	}
	
    /**
     * Setter for doneTask
     * @param doneTask Variable that keeps the task done or not
     */
	public void setDoneTask(boolean doneTask) 
	{
		this.doneTask = doneTask;
	}
	
	 /**
     * Getter for doneTask
     * @return
     */
	public boolean isDoneTask() 
	{
		return doneTask;
	}
	

}

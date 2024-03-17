// Name: Zhiyuan Chang
// Computing ID: vgs3qt
// Homework Name: HW12 Priority Queue

public class Task implements Comparable<Task> {

    private String TaskName;
    private int priority;

    public Task(String name){
        // With only task name entered
        this.TaskName = name;
    }

    public Task(String name, int pri) {
        // With both task name and priority
        this.TaskName = name;
        this.priority = pri;
    }

    public void setName(String name){
        // Set the task name, return if the name is null
        if(name == null){
            return;
        }
        this.TaskName = name;
    }

    public String getName(){
        // return the task name
        if(TaskName == null){
            return null;
        }
        return this.TaskName;
    }

    public void setPriority(int pri){
        // set the priority
        this.priority = pri;
    }

    public int getPriority(){
        // return priority
        return this.priority;
    }

    @Override
    public String toString() {
        // return a String with Taskname and priority in the give format
        return "[ " + TaskName + "," + priority + " ]";
    }

    @Override
    public boolean equals(Object obj) {
        // compare the object with task
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Task)) {
            return false;
        }
        Task other = (Task) obj;
        if(TaskName.equals(other.getName())){
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Task o) {
        // compareTo method, return 0, 1, -1
        return Integer.compare(o.priority, this.priority);
    }

}

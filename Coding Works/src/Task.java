
public class Task implements Comparable<Task> {
    String name;
    int priority;
    public Task(String inName, int priority){
        this.name = inName;
        this.priority = priority;
    }

    public Task(String inName) {
        this.name = inName;
    }
    public int getPriority(){
        return this.priority;
    }
    public void setPriority(int priority){
        this.priority = priority;
    }

    public String getName(){
        if(name == null) return null;
        return this.name;
    }
    public void setName(String task){
        if(task == null) return;
        this.name = task;
    }
    @Override
    public String toString(){
        return "[ " + this.name + ", " + this.priority + " ]";
    }
    public boolean equals(Object o){
        if (o == this) {
            return true;
        }
        if (!(o instanceof Task)) {
            return false;
        }
        Task other = (Task) o;
        return name.equals(other.getName()) ;
//                && priority == other.priority;
    }
    @Override
    public int compareTo(Task o) {
        return Integer.compare(o.priority, this.priority);
    }
}

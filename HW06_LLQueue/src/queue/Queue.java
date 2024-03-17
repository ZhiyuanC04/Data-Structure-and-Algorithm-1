// Name: Zhiyuan Chang
// Computing ID: vgs3qt
// Homework Name: HW 6 - LLQueue

package queue;
import list.LinkedList;
public class Queue<T> implements IQueue<T>{
	private LinkedList<T> list;

	public Queue(){
		// Constructor: Initialize the inner list
		list = new LinkedList<>();
	}

	public int size() {
		// Return the size by invoking the size of the list
		return list.size();
	}

	public void enqueue(T data) {
		// Simply add the data to the tail of the linked list
		list.insertAtTail(data);
	}

	public T dequeue(){
		// Simply remove data from the head of the list, throw exception if list is empty.
		return list.removeAtHead();
	}
}

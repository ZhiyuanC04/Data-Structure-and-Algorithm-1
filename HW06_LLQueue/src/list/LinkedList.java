// Name: Zhiyuan Chang
// Computing ID: vgs3qt
// Homework Name: HW 6 - LLQueue

package list;
public class LinkedList<T> implements SimpleList<T>{
	private ListNode<T> head, tail;
	private int size;

	public LinkedList() {
		// Create dummy head and tail node, and 0 element between them so head -- tail.
		head = new ListNode<>(null);
		tail = new ListNode<>(null);
		head.next = tail;
		tail.prev = head;
		size = 0;
	}

	public int size() {
		// Return the number of element in the list.
		return this.size;
	}

	public void clear() {
		// Clear all the nodes between. So nothing is left.
		head.next = tail;
		tail.prev = head;
		size = 0;
	}

	public void insertAtTail(T data) {
		// Insert in the last position, next of the new is tail. tail.prev before insert is tail_prev.
		ListNode<T> new_node = new ListNode<>(data);
		ListNode<T> tail_prev = tail.prev;
		tail_prev.next = new_node;
		new_node.next = tail;
		new_node.prev = tail_prev;
		tail.prev = new_node;
		size++;
	}

	public void insertAtHead(T data) {
		// Insert in the first position, prev of the new is head. head.next before insert is head_next.
		ListNode<T> new_node = new ListNode<>(data);
		ListNode<T> head_next = head.next;
		head_next.prev = new_node;
		new_node.prev = head;
		new_node.next = head_next;
		head.next = new_node;
		size++;
	}

	public void insertAt(int index, T data) {
		// Insert an element to the index position, make others' position n+1.
		// Inserts node such that index becomes the position of the newly inserted data
//		System.out.println(size());
//		System.out.println(index);
		if(index < 0 || index > size){
			return;
		}
		if(index == 0){
			insertAtHead(data);
		}
		else if(index == size){
			insertAtTail(data);
		}
		else{
			ListNode<T> add = new ListNode<>(data);
			ListNode<T> in = new ListNode<>(null);
			in = head.next;
			for(int i = 0; i < index; i++){
//				if(in == tail){
//					System.out.println("111");
//				}
//				else{
//					System.out.println(in.getData());
//				}
//				System.out.println("000");
				in = in.next;
			}
			add.prev = in.prev;
			add.next = in;
			add.prev.next = add;
			in.prev = add;
			size++;
			}
		return;
		}

	public void insert(ListIterator<T> it, T data) {
		// Inserts data after the node pointed to by iterator.
		ListNode<T> add = new ListNode<>(data);
		add.prev = it.curNode;
		add.next = it.curNode.next;
		it.curNode.next = add;
		size++;
	}

	public T removeAtTail(){
		// If only one element, it's a special case. If only one, it is same as clear.
		// If more than one, just remove the node before tail.
		if(size > 1){
			T rem = tail.prev.getData();
			ListNode<T> change = tail.prev.prev;
			tail.prev = change;
			change.next = tail;
			size--;
			return rem;
		}
		else if(size == 1){
			T rem = tail.prev.getData();
			tail.prev = head;
			size--;
			return rem;
		}
		return null;
	}

	public T removeAtHead(){
		// If only one element, it's a special case. If only one, it is same as clear.
		// If more than one, just remove the node after head.
		if(size > 1){
			T rem = head.next.getData();
			ListNode<T> change = head.next.next;
			head.next = change;
			change.prev = head;
			size--;
			return rem;
		}
		else if(size == 1){
			T rem = head.next.getData();
			head.next = tail;
			size--;
			return rem;
		}
		return null;
	}

	public T remove(ListIterator<T> it) {
		// Remove based on Iterator position
		// Sets the iterator to the node AFTER the one removed
		ListNode<T> before = it.curNode.prev;
		T rem = it.curNode.getData();
		it.moveBackward();
		before.next = it.curNode;
		it.curNode.prev = before;
		size--;
		return rem;
	}

	public int find(T data) {
		// Returns index of first occurrence of the data in the list, or -1 if not present
		int index = -1;
		ListNode<T> in = head;
		for(int i = 0; i < size; i++){
			if(in.next.getData().equals(data)){
				index = i;
				return index;
			}
			in = in.next;
		}
		return index;
	}

	public T get(int index) {
		// Returns the data at the given index, null if anything goes wrong
		if(index < 0 || index >= size){
			return null;
		}
		ListNode<T> in = head;
		for(int i = 0; i <= index; i++) {
			in = in.next;
		}
		return in.getData();
	}
	

	public String toString() {
		String toRet = "[";
		ListNode<T> curNode = head.next;
		while(curNode != tail) {
			toRet += curNode.getData() + ", ";
			curNode = curNode.next;
		}
		return toRet + "]";
	}

	public ListIterator<T> front(){
		// Return iterators at front of list
		ListIterator front = new ListIterator(head);
		return front;
	}

	public ListIterator<T> back(){
		// Return iterators at end of list
		ListIterator back = new ListIterator(tail);
		return back;
	}
}
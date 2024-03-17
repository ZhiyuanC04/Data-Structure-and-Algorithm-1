
import javax.naming.InitialContext;
import java.util.Arrays;

public class Vector<T> implements List<T> {

	private T[] itemArray;
	private int size = 0;
	private static final int INITIAL_CAPACITY = 100;

	public Vector() {
		this(INITIAL_CAPACITY);  // calls the other constructor that takes an int parameter
	}

	@SuppressWarnings("unchecked")
	public Vector(int capacity) {
		this.itemArray = (T[]) new Object[capacity];
		this.size = 0;
	}

	public int capacity() {
		return this.itemArray.length;
	}

	/**
	 * When the underlying array fills up, we need to somehow resize it to accommodate the
	 * Vectors's elements.
	 * Ignores the request if the requested new capacity is too small to fit the elements
	 * already in the Vector
	 */
	public void resize(int newCapacity) {

		// TODO: Implement this method
		T[] newitemArray = (T[]) new Object[newCapacity];
		for (int i = 0; i < this.size;i++){
			newitemArray[i] = this.itemArray[i];
		}
		this.itemArray = newitemArray;
	}

	@Override
	public int size() {
		// TODO: Implement this method
		return this.size;
	}

	@Override
	public void clear() {
		// TODO: Implement this method
		for(int i = size - 1; i >= 0; i--){
			this.removeAtTail();
		}
	}

	@Override
	public void insertAtTail(T item) {
		if (this.size == this.capacity()){
			int newcapcity = this.capacity() * 2;
			this.resize(newcapcity);
		}
		itemArray[size] = item;
		size++;

		// TODO: Implement this method
	}

	@Override
	public void insertAtHead(T item) {
		// TODO: Implement this method
		if(this.size == this.capacity()){
			int newcapcity = this.capacity() * 2;
			resize(newcapcity);
		}

		for(int i = size; i > 0; i--){
			itemArray[i] = itemArray[i-1];
		}
		itemArray[0] = item;
		size ++;
	}

	@Override
	public void insertAt(int index, T item) {
		// TODO: Implement this method
		if(this.size == this.capacity()){
			int newcapcity = this.capacity() * 2;
			resize(newcapcity);
		}

		for(int i = size; i > index; i--){
			itemArray[i] = itemArray[i-1];
		}
		itemArray[index] = item;
		size ++;
	}

	@Override
	public T removeAtTail() {
		// TODO: Implement this method
		if(size == 0){
			return null;
		}
		T result = itemArray[size - 1];
		itemArray[size - 1] = null;
		size --;
		return result;
	}

	@Override
	public T removeAtHead() {
		// TODO: Implement this method
		if(size == 0){
			return null;
		}
		T result = itemArray[0];
		for(int i = 0; i < size; i++){
			itemArray[i] = itemArray[i+1];
		}
		itemArray[size - 1] = null;
		size --;
		return result;
	}

	@Override
	public int find(T item) {
		// TODO: Implement this method
		for (int i = 0; i < size; i++){
			if(this.itemArray[i].equals(item) ){
				return i;
			}
		}
		return -1;
	};

	@Override
	public T get(int index) {
		// TODO: Implement this method
		if(index >= size || index < 0){
			return null;
		}
		return itemArray[index];
	}

	/*
	 * This toString() method allow you to print a nicely formatted version of your Vector. E.g.
	 *     System.out.println( myVector );
	 * It uses utility methods in the Java Arrays library.
	 */
	@Override
	public String toString() {
//		return Arrays.toString(this.itemArray); // prints entire array from 0 to capacity-1
		return Arrays.toString(Arrays.copyOfRange(this.itemArray, 0, this.size)); // prints from 0 to size-1
	}

}

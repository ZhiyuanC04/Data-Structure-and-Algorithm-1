// Name: Zhiyuan Chang
// Computing ID: vgs3qt
// Homework Name: Vector.

package vector;
import java.util.Arrays;
public class Vector<T> implements SimpleList<T> {
	private T[] itemArray;
	private int size = 0;
	private static final int INITIAL_CAPACITY = 100;
	public Vector() {
		this(INITIAL_CAPACITY);
	}
	// Set the capacity of the itemArray.
	@SuppressWarnings("unchecked")
	public Vector(int capacity) {
		this.itemArray = (T[]) new Object[capacity];
		this.size = 0;
	}
	// return the length of the entire itemArray.
	public int capacity() {
		return this.itemArray.length;
	}
	// change the capacity of the array to newCapacity.
	public void resize(int newCapacity) {
		if(newCapacity >= size){
			T[] new_itemArray = (T[]) new Object[newCapacity];
			for (int i = 0; i < this.size; i++){
				new_itemArray[i] = this.itemArray[i];
			}
			this.itemArray = new_itemArray;
		}
	}
	// return the number of elements existed in itemArray.
	@Override
	public int size() {
		return this.size;
	}
	// clear all elements in itemArray.
	@Override
	public void clear() {
		for(int i = size - 1; i >= 0; i--){
			itemArray[size-1] = null;
			size--;
		}
	}
	// Insert a element at the tail of itemArray.
	@Override
	public void insertAtTail(T item) {
		if(this.size == this.capacity()){
			this.resize(this.capacity() * 2);
		}
		itemArray[size]=item;
		size++;
	}
	// Insert a element at the head of itemArray. Move the rest to +1 position.
	@Override
	public void insertAtHead(T item) {
		if(this.size == this.capacity()){
			this.resize(this.capacity() * 2);
		}
		for(int i = size; i > 0; i--){
			itemArray[i] = itemArray[i-1];
		}
		itemArray[0] = item;
		size++;
	}
	// insert at given index.
	@Override
	public void insertAt(int index, T item) {
		if(this.size == this.capacity()){
			this.resize(this.capacity() * 2);
		}
		if(index<=size) {
			for (int i = size; i > index; i--) {
				itemArray[i] = itemArray[i - 1];
			}
			itemArray[index] = item;
			size++;
		}
	}
	// remove an element at tail.
	@Override
	public T removeAtTail() {
		if(size == 0){
			return null;
		}
		T result = itemArray[size - 1];
		itemArray[size-1] = null;
		size--;
		return result;
	}
	// remove an element at beginning.
	@Override
	public T removeAtHead() {
		if(size == 0){
			return null;
		}
		T result = itemArray[0];
		for(int i = 0; i < size; i++){
			itemArray[i] = itemArray[i+1];
		}
		itemArray[size-1] = null;
		size--;
		return result;
	}
	// find the place index of the value (item) that exist in itemArray.
	@Override
	public int find(T item) {
		for(int i = 0; i < size; i++) {
			if(itemArray[i].equals(item)){
				return i;
			}
		}
		return -1;
	}
	// get the value of the element at index position.
	@Override
	public T get(int index) {
		if(size == 0 || index > size || index < 0){
			return null;
		}
		return itemArray[index];
	}
	// toString method.
	@Override
	public String toString() {
//		return Arrays.toString(this.itemArray); // prints entire array from 0 to capacity-1
		return Arrays.toString(Arrays.copyOfRange(this.itemArray, 0, this.size));
	}
}
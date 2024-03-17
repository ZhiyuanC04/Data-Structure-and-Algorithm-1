// Name: Zhiyuan Chang
// Computing ID: vgs3qt
// Homework Name: HW12 Priority Queue

package pq;

import java.util.ArrayList;

public class MyPriorityQueue<T extends Comparable<T>> implements SimplePQ<T>{

    private ArrayList<T> heap;

    public MyPriorityQueue(){
        // initialize ArrayList
        // no need to set capacity, it can grow by itself as we add element
        heap = new ArrayList<>();
    }

    @Override
    public void add(T t){
        // Add the given element to the priority queue
        heap.add(t);
        int index = heap.size() - 1;
        int parent = (index - 1)/2;
        // trickle up
        while(index > 0 && heap.get(index).compareTo(heap.get(parent)) < 0){
            // switch positions
            swap(index, parent);
            index = parent;
            parent = (index - 1)/2;
        }
    }

    @Override
    public void clear(){
        // Remove all elements from the priority queue; clear it
        if(heap.isEmpty()){
            return;
        }
        heap.clear();
    }

    @Override
    public boolean contains(Object o){
        // Return true if this value is already in the priority queue
        return heap.contains(o);
    }

    @Override
    public T peek(){
        // Returns item with highest priority; null if priority queue is empty;
        // no change to priority queue
        if(heap.isEmpty()){
            return null;
        }
        return heap.get(0);
    }

    @Override
    public T remove(){
        // Removes and returns item with highest priority; null if priority queue is empty
        if(heap.isEmpty()){
            return null;
        }
        T removing = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        // trickle down, and find the correct place for this element
        trickle_down(0);
        heap.remove(heap.size() - 1);
        return removing;
    }

    @Override
    public int size(){
        // Return the number of elements in the priority queue
        return heap.size();
    }

    public void swap(int first, int second){
        // swap method, change the position of two element(node)
        if(heap.isEmpty()){
            return;
        }
        T temp = heap.get(first);
        heap.set(first, heap.get(second));
        heap.set(second, temp);

    }

    public void trickle_down(int index){
        // trickle down method, find the
        if(heap.isEmpty()){
            return;
        }
        // check the parent and its children
        int left_child = (2 * index) + 1;
        int right_child = (2 * index) + 2;
        int current = index;
        // if the value is incorrect, change the index
        if (left_child < heap.size() - 1 && heap.get(left_child).compareTo(heap.get(current)) < 0) {
            current = left_child;
        }
        if (right_child < heap.size() && heap.get(right_child).compareTo(heap.get(current)) < 0) {
            current = right_child;
        }
        // when either of the if statement above run, swap the elements using the index
        if (current != index) {
            swap(index, current);
            trickle_down(current);
        }
    }

}

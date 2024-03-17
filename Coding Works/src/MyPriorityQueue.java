//package pq;
//
//import java.util.ArrayList;
//
//public class MyPriorityQueue<T extends Comparable<T>> implements SimplePQ<T>{
//    private ArrayList<T> heap;
//
//    public MyPriorityQueue(){
//        heap = new ArrayList<>();
//    }
//    @Override
//    public void add(T t) {
//        heap.add(t);
//        int i = heap.size() -1;
//        int parent = (i-1)/2;
//        while(i>0 && heap.get(i).compareTo(heap.get(parent)) < 0){
//            change(i, parent);
//            i = parent;
//        }
//    }
//
//    @Override
//    public void clear() {
//        if(heap.isEmpty()) return;
//        heap.clear();
//    }
//
//    @Override
//    public boolean contains(Object o) {
//        return heap.contains(o);
//    }
//
//    @Override
//    public T peek() {
//        if(heap.isEmpty()){
//            return null;
//        }
//        return heap.get(0);
//    }
//
//    @Override
//    public T remove() {
//        if(heap.isEmpty()){
//            return null;
//        }
//        T item = heap.get(0);
//        heap.set(0, heap.get(heap.size()-1));
//        fix(0);
//        heap.remove(heap.size()-1);
//
//        return item;
//    }
//    @Override
//    public String toString(){
//        if(heap.isEmpty()) return null;
//        String a = "";
//        for(int i = 0; i< heap.size(); i++){
//            a+=heap.get(i);
//        }
//        return a;
//    }
//    @Override
//    public int size() {
//        return heap.size();
//    }
//    public void change(int index1, int index2){
//        if(heap.isEmpty()) return;
//        T temp = heap.get(index1);
//        heap.set(index1, heap.get(index2));
//        heap.set(index2, temp);
//    }
//
//    public void fix(int i){
//        if(heap.isEmpty())return;
//        int leftchild = 2*i+1;
//        int rightchild = 2*i+2;
//        int curnode = i;
//        if (leftchild < heap.size() && heap.get(leftchild).compareTo(heap.get(curnode)) < 0) {
//            curnode = leftchild;
//        }
//        if (rightchild < heap.size() && heap.get(rightchild).compareTo(heap.get(curnode)) < 0) {
//            curnode = rightchild;
//        }
//        if (curnode != i) {
//            change(i, curnode);
//            fix(curnode);
//        }
//    }
//
//
//}

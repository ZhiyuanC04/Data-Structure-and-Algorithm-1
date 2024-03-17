// Name: Chris Li
// Computing ID: hl5ux
// Homework Name: Quiz5a

import java.util.*;

public class HashTable {
    private static final int INITIAL_CAP = 5;  // a default initial capacity
    private int currentCapacity = INITIAL_CAP;

    private String[] buckets;
    int size = 0;
    /* Max allowed load factor */
    private double maxLoad = 0.75;
    
    public HashTable() {  // default constructor sets capacity to default value
        this(INITIAL_CAP);
    }
    public HashTable(int capacity) {  // constructor sets capacity to given value
        if (capacity > 0) {
            buckets = new String[capacity];
            this.currentCapacity = capacity;
        }
        for (int i = 0; i < capacity; i++){
            buckets[i] = null;
        }
    }

    // insert() adds a new String if the key is not found, otherwise it does nothing
    public void insert(String key) {
        if ((double) size / currentCapacity >= maxLoad) {
            resize();
        }

        int index = hash(key);
        int i = 0;
        int newIndex;

        while (true) {
            newIndex = (index + (int) Math.pow(i, 2)) % buckets.length;
            if (buckets[newIndex] == null) {
                buckets[newIndex] = key;
                size++;
                break;
            }
            i++;
            if (i >= currentCapacity) {
                resize();
                index = hash(key);
                i = 0;
            }
        }
    }



    public int hash(String key) {
        int hashCode = StringHashFunc.hashCode(key);
        int index = Math.abs(hashCode) % buckets.length;
        return index;
    }



    public String retrieve(String key) {
        /* TODO: IMPLEMENT THIS METHOD */
        for (int i = 0; i < this.buckets.length; i++){
            if(buckets[i] != null && buckets[i].equals(key)) {
                return buckets[i];
            }
        }
        return null;
    }

    public void remove(String key) {
        /* TODO: IMPLEMENT THIS METHOD */
       for(int i = 0; i < this.buckets.length; i++){
            if(buckets[i] != null && buckets[i].equals(key)){
                buckets[i] = null;
                size--;
            }
       }
    }

    @Override
    public String toString() {
        String result = "";
        for (int idx = 0; idx < this.currentCapacity; ++idx) {
            result += (idx + ": " + buckets[idx] + "  ");
            if (idx % 5 == 0)
                result += "\n";
        }
	return result;
    }

    public int size() {
        return size;
    }

   private void resize() {
        String[] oldTable = buckets;
        currentCapacity = currentCapacity * 2 + 1;
        buckets = new String[currentCapacity];
        for (int i = 0; i < currentCapacity; i++)
            buckets[i] = null;
        int num = size;
        size = 0; //restart size at 0
        for(int i = 0; i < oldTable.length; i++) {
            if(oldTable[i] != null)
                insert(oldTable[i]);
        }
        if (size != num)
            System.out.println("resize failed to get all the values");
    }

    /**
     * Getting and setting the maxLoad field
     * @return
     */
    public double getMaxLoad(){
        return maxLoad;
        }
    public void setMaxLoad(double maxLoad){
        this.maxLoad = maxLoad;
        }

}

// Name: Zhiyuan Chang
// Computing ID: vgs3qt
// Homework Name: HW11_HashTables

package hash;
import java.util.ArrayList;

/**
 * Hash Table implementation.
 *
 * @param <K>
 * @param <V>
 */
public class HashTable<K,V> implements SimpleMap<K,V>{

    private static final int INITIAL_CAP = 5;  // a default initial capacity (set low for initial debugging)
    private int currentCapacity = INITIAL_CAP;
    private ArrayList<HashNode<K, V>> table;

    /*
     * Here are some hints about how to declare your hash table.
     * If you're using an ArrayList, it might look like this:
     * 		private ArrayList<HashNode<K, V>> table;
     * Note that you cannot declare an array of generics (i.e., an array of HashNodes) like this:
     *          private LinkedList<HashNode<K,V>>[] table;
     * but see here https://programming.guide/java/generic-array-creation.html for workarounds.
     */
    /* YOU WILL LIKELY WANT MORE PRIVATE VARIABLES HERE */

    private int number_of_element = 0;

    public HashTable() {  // default constructor sets capacity to default value
        this(INITIAL_CAP);
    }

    public HashTable(int capacity) {  // constructor sets capacity to given value
        /* TODO: IMPLEMENT THIS METHOD */
        /*
         * Here are some hints about how to allocate memory for your hash table.
         * If you're using an array, it might look like this:
         * 		this.table = (HashNode<K,V>[]) new HashNode<?,?>[initialCapacity];
         * If you're using an ArrayList, it might look like this:
         * 		this.table = new ArrayList<>(capacity); // sets list's initial capacity
         */
        this.table = new ArrayList<>(capacity);
        currentCapacity = capacity; // change capacity since capacity need change as size increases
        number_of_element = 0; // count number of element added to calculate loaded factor
        // make all element null, so the if statement can check if its empty
        for(int i = 0; i < capacity; i++) {
            table.add(null);
        }
    }

    @Override
    public void insert(K key, V value) {
        /* TODO: IMPLEMENT THIS METHOD */
        // Insert() adds a new key/value pair if the key is not found, otherwise it replaces
        // the existing key's value
        int hashCode = key.hashCode();
        int index = hashCode % currentCapacity;
        // take out the node  stored at this index
        HashNode<K, V> mem = table.get(index);
        if(mem == null) { // check if it has value or not
            table.set(index, new HashNode<>(key,value)); // if no value stored, add one
            number_of_element++;
        }
        else{
            // if there is a value inside
            while((mem != null) && !mem.getKey().equals(key)){
                // go to next index
                index = (index + 1) % currentCapacity; // make sure the index goes back (circular)
                mem = table.get(index);
            }
            // found one space, add the node into this space
            if (mem == null){
                table.set(index, new HashNode<>(key,value));
                number_of_element++;

            }
            else{
                // if the key already exist, replace the value
                mem.setValue(value);
            }
        }
        if (number_of_element * 1.0 / currentCapacity >= 0.75) {
            // check the loaded factor, if >0.75, resize the table
            resize();
        }
//        printHashTable();
    }

    @Override
    public V retrieve(K key) {
        /* TODO: IMPLEMENT THIS METHOD */
        // loop all element to find the key, if not found return null
        for (int i = 0; i < currentCapacity; i++){
            if(table.get(i) != null) {
                if (table.get(i).getKey().equals(key) || table.get(i).getKey() == key) {
                    return table.get(i).getValue();
                }
            }
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        /* TODO: IMPLEMENT THIS METHOD */
        int hashCode = key.hashCode();
        int index = hashCode % currentCapacity;
        HashNode<K, V> mem = table.get(index);
        // loop all elements to find the key, if key is there return true, otherwise false
        while (mem != null) {
            if(mem.getKey() != null) {
                if (mem.getKey().equals(key)) {
                    return true;
                }
            }
            index = (index + 1) % currentCapacity;
            mem = table.get(index);
        }
        return false;
    }

    @Override
    public void remove(K key) {
        /* TODO: IMPLEMENT THIS METHOD */
        // remove the node with same key
        int hashCode = key.hashCode();
        int index = hashCode % currentCapacity;
        HashNode<K, V> mem = table.get(index);
        // loop all elements to find the key
        while(mem != null) {
            if(mem.getKey().equals(key)) {
                // once find it, make that index null, clear the node stored
                table.set(index, null);
                number_of_element--;
                break;
            }
            index = (index + 1) % currentCapacity;
            mem = table.get(index);
        }
    }

    private void resize() {
        // a method I wrote to resize the HashTable
        // double the capacity and +1 to make it a prime number (because started with a prime number)
        currentCapacity = (currentCapacity * 2) + 1;
        ArrayList<HashNode<K, V>> before_change = table;
        table = new ArrayList<>(currentCapacity);
        // once having a new table, make all element null like constructor
        for (int i = 0; i < currentCapacity; i++) {
            table.add(null);
        }
        number_of_element = 0;
        // then put existed elements into the new table and store them
        for (HashNode<K, V> node : before_change) {
            if (node != null) {
                insert(node.getKey(), node.getValue());
            }
        }
    }

    /*
     * OPTIONAL HELPER METHODS: The next two methods will let you print out your
     * entire hash table, or let you make sure all keys that hash to a single
     * bucket's index get stored as they should in your table. You'll need to
     * implement the second method; it depends on how you store entries and
     * handle collisions. This is NOT required, but you may find it helpful when
     * debugging and testing your code.
     */

    public void printHashTable() {
        for (int idx=0; idx < this.currentCapacity; ++idx) {
            System.out.print(idx + ": ");
            printEntriesByIndex(idx);
        }
    }

    private void printEntriesByIndex(int idx) {
        /*
         * To implement this method to help print out one bucket of your hash table, you need to determine:
         * a) If there are no key/value pairs in the bucket idx, print "no entries"
         * b) If there are key/value pairs at that bucket, use a loop to print each one.
         *    Best to use System.out.print() and not println() so they're all on one line.
         * c) At the end of that loop, do System.out.println() to print a new line.
         */
        HashNode<K, V> temp = table.get(idx);
        if(temp == null) {
            System.out.println("no entries");
        }
        else {
            System.out.println(temp);
        }
        System.out.println();
    }

}


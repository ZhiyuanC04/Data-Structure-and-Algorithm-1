//// Name: Chris Li
//// Computing ID: hl5ux
//// Homework Name: HW11
//
//package hash;
//import java.util.ArrayList;
//
///**
// * Hash Table implementation.
// *
// * @param <K>
// * @param <V>
// */
//public class HashTable<K,V> implements SimpleMap<K,V> {
//
//    private static final int INITIAL_CAP = 5;  // a default initial capacity (set low for initial debugging)
//    private int currentCapacity = INITIAL_CAP;
//    private ArrayList<HashNode<K, V>> table;
//    /*
//     * Here are some hints about how to declare your hash table.
//     * If you're using an ArrayList, it might look like this:
//     * 		private ArrayList<HashNode<K, V>> table;
//     * Note that you cannot declare an array of generics (i.e., an array of HashNodes) like this:
//     *          private LinkedList<HashNode<K,V>>[] table;
//     * but see here https://programming.guide/java/generic-array-creation.html for workarounds.
//     */
//    /* YOU WILL LIKELY WANT MORE PRIVATE VARIABLES HERE */
//    private int number_of_element = 0;
//
//    public HashTable() {  // default constructor sets capacity to default value
//        this(INITIAL_CAP);
//    }
//    public HashTable(int capacity) {  // constructor sets capacity to given value
//        /* TODO: IMPLEMENT THIS METHOD */
//        /*
//         * Here are some hints about how to allocate memory for your hash table.
//         * If you're using an array, it might look like this:
//         * 		this.table = (HashNode<K,V>[]) new HashNode<?,?>[initialCapacity];
//         * If you're using an ArrayList, it might look like this:
//         * 		this.table = new ArrayList<>(capacity); // sets list's initial capacity
//         */
//        this.table = new ArrayList<>(capacity);
//        currentCapacity = capacity;
//        number_of_element = 0;
//        for(int i = 0; i < capacity; i++) {
//            table.add(null);
//        }
//    }
//
//    @Override
//    public void insert(K key, V value) {
//        int hashCode = key.hashCode();
//        int index = hashCode % currentCapacity;
//
//        if (number_of_element * 1.0 / currentCapacity >= 0.75) {
//            resizeHashTable();
//        }
//
//        HashNode<K, V> node = table.get(index);
//
//        if (node == null) {
//            table.set(index, new HashNode<>(key, value));
//            number_of_element++;
//        } else {
//            // Find an empty slot in the table or the slot with the same key
//            while (node != null && !node.getKey().equals(key)) {
//                index = (index + 1) % currentCapacity;
//                node = table.get(index);
//            }
//
//            if (node == null) {
//                table.set(index, new HashNode<>(key, value));
//                number_of_element++;
//            } else {
//                node.setValue(value);
//            }
//        }
//    }
//
//
//    private void rehash() {
//        ArrayList<HashNode<K, V>> tempTable = new ArrayList<>(currentCapacity);
//        for (int i = 0; i < currentCapacity; i++) {
//            tempTable.add(null);
//        }
//
//        for (HashNode<K, V> node : table) {
//            if (node != null) {
//                int newIndex = node.getKey().hashCode() % currentCapacity;
//
//                while (tempTable.get(newIndex) != null) {
//                    newIndex = (newIndex + 1) % currentCapacity;
//                }
//
//                tempTable.set(newIndex, node);
//            }
//        }
//
//        table = tempTable;
//    }
//
//    @Override
//    public V retrieve(K key) {
//        /* TODO: IMPLEMENT THIS METHOD */
//        for (int i = 0; i < currentCapacity; i++){
//            if(table.get(i) != null) {
//                if (table.get(i).getKey() == key) {
//                    return table.get(i).getValue();
//                }
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public boolean contains(K key) {
//        /* TODO: IMPLEMENT THIS METHOD */
//        int hashCode = key.hashCode();
//        int index = hashCode % currentCapacity;
//
//        HashNode<K, V> node = table.get(index);
//
//        while (node != null) {
//            if (node.getKey().equals(key)) {
//                return true;
//            }
//            index = (index + 1) % currentCapacity;
//            node = table.get(index);
//        }
//
//        return false;
//    }
//
//    @Override
//    public void remove(K key) {
//        /* TODO: IMPLEMENT THIS METHOD */
//        int hashCode = key.hashCode();
//        int index = hashCode % currentCapacity;
//
//        HashNode<K, V> node = table.get(index);
//
//        while (node != null) {
//            if (node.getKey().equals(key)) {
//                table.set(index, null);
//                number_of_element--;
//                break;
//            }
//            index = (index + 1) % currentCapacity;
//            node = table.get(index);
//        }
//    }
//
//    private void resizeHashTable() {
//        int old_capacity = currentCapacity;
//        currentCapacity = (currentCapacity * 2) + 1;
//        ArrayList<HashNode<K, V>> oldTable = table;
//
//        table = new ArrayList<>(currentCapacity);
//        for (int i = 0; i < currentCapacity; i++) {
//            table.add(null);
//        }
//
//        number_of_element = 0;
//
//        for (HashNode<K, V> node : oldTable) {
//            if (node != null) {
//                insert(node.getKey(), node.getValue());
//            }
//        }
//    }
//
//
//
//
//    /*
//     * OPTIONAL HELPER METHODS: The next two methods will let you print out your
//     * entire hash table, or let you make sure all keys that hash to a single
//     * bucket's index get stored as they should in your table. You'll need to
//     * implement the second method; it depends on how you store entries and
//     * handle collisions. This is NOT required, but you may find it helpful when
//     * debugging and testing your code.
//     */
//
////    public void printHashTable() {
////        for (int idx=0; idx < this.currentCapacity; ++idx) {
////            System.out.print(idx + ": ");
////            printEntriesByIndex(idx);
////        }
////    }
//
////    private void printEntriesByIndex(int idx) {
////        /*
////         * To implement this method to help print out one bucket of your hash table, you need to determine:
////         * a) If there are no key/value pairs in the bucket idx, print "no entries"
////         * b) If there are key/value pairs at that bucket, use a loop to print each one.
////         *    Best to use System.out.print() and not println() so they're all on one line.
////         * c) At the end of that loop, do System.out.println() to print a new line.
////         */
////        HashNode<K, V> temp = table.get(idx);
////        if(temp == null) {
////            System.out.println("no entries");
////        }
////        else {
////            System.out.println(temp);
////        }
////        System.out.println();
////    }
//
//}
//

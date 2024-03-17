import java.util.*;
public class HashTester {
    public static void main(String[] args) {

        HashTable stud = new HashTable();
        String[] arr = {"apple", "banana", "candy", "donut", "egg", "fish", "grapefruit", "ham", "ice",
                "jello", "kale", "lemon", "mango", "nuts", "orange", "pecan", "quinoa", "raisin", "sandwich",
                "thyme", "velveeta", "watermelon"};

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Inserting..." + arr[i]);
            stud.insert(arr[i]);
        }
        System.out.println("After inserting, hash table contains: " + stud);
        //stud.printHashTable();

       // String s = stud.retrieve(arr[6]);
       // System.out.println("Found : " + s);

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Retrieving..." + arr[i] + "  ");
            String s = stud.retrieve(arr[i]);
            System.out.println("Found : " + s);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Deleting ..." + arr[i] + "  ");
            stud.remove(arr[i]);
        }
        System.out.println("After deletions, hash table contains: " + stud);
        //stud.printHashTable();
        System.out.println("DONE");

  /*      boolean done = false;
        Scanner scan = new Scanner(System.in);

        do {
            // menu to process Task list
            printMenu();
            System.out.println("Enter choice");
            int choice = scan.nextInt();
            String trash = scan.nextLine();
            switch (choice) {
                case 1: // print(list);
                    System.out.println(stud);
                    break;
                case 2: //add
                    System.out.println("Enter String");
                    String n = scan.nextLine();
                    stud.insert(n);
                    break;
                case 3: // remove
                    System.out.println("Enter String");
                    n = scan.nextLine();
                    stud.remove(n);
                    break;
                case 4: // find value
                    System.out.println("Enter String");
                    n = scan.nextLine();
                    String result = stud.retrieve(n);
                    System.out.println("Value retrieved is : " + result);
                    break;
                case 5: // size
                    System.out.println("The size of the hash table is " + stud.size());
                    break;

                case 0:
                    System.out.println("Closing hash table.");
                    done = true;
                    break;
                default:
                    System.out.println("Error, invalid selection");
            }
        } while (!done);
*/

    }

    public static void printMenu() {
        System.out.println("1. Print the hash table");
        System.out.println("2. Insert a value");
        System.out.println("3. Remove a value");
        System.out.println("4. Find a value");
        System.out.println("5. Size of hash table");
        System.out.println("0. Quit");
    }
}







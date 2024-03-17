import java.util.*;
public class Lec04_Java_Example {
    public static void main(String[] args) {

 /*       int x = 1_000_000;

        System.out.println((long)x*x);


        String temp = "There once was a man named Abraham...";
        System.out.println(temp);
        String alpha = new String("Have a nice day!");
        System.out.println(alpha);
        Random r = new Random();
        System.out.println(r);
        System.out.println(r.nextLong());
*/

        System.out.println("Welcome to class.");
        // call method to get age
        int age = getAge();

        System.out.println("You were born in " + (2023-age+1));
    }

    public static int getAge() {
        Scanner scan = new Scanner(System.in);
        System.out.println("What is your age");
        int age = scan.nextInt();
        return age;
    }

}
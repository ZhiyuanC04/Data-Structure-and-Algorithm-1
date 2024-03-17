import java.util.Scanner;
public class Lec05_Java_Example {
    public static void main(String[] args) {

        //Let's find the sum and average of an array two ways

        // First way - initializer list
        //int [] arr1 = {15, 22, 11, 99, 42, 73};
        int [] arr1 = {1, 2, 4};
        System.out.println("Length of arr1 is " + arr1.length);
        int s1 = sum(arr1);
        System.out.println("Sum of arr1 is " + s1);
        double a1 = avg(arr1);
        System.out.println("Average of arr1 is " + a1);

        // Second way - user entered values
        Scanner scan = new Scanner(System.in);
        System.out.println("How many values do you want to enter?");
        int num = scan.nextInt();

        int [] arr2 = new int[num];
        System.out.println("Enter " + num + " values.");
        for (int i = 0; i < num ;i++)
            arr2[i] = scan.nextInt();
        s1 = sum(arr2);
        System.out.println("Sum of arr2 is " + s1);
        a1 = avg(arr2);
        System.out.println("Average of arr2 is " + a1);


    }

    public static int sum (int [] array) {
        int total = 0;
        for (int i = 0; i < array.length; i++)
            total += array[i];
        return total;
    }

    public static double avg (int [] array) {
        int sum = sum(array);
        double average = 0.0;
        if (array.length != 0)
            average = 1.0 * sum / array.length;
        return average;
    }
}
// Name: Zhiyuan Chang
// Computing ID: vgs3qt
// Homework Name: Module 1 - FourFunctions

public class HW01_FourFunctions {
    public static void main(String args[]) {}

    public static boolean just8and9 ( int[] numbers ) {
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 8) {
                count += 1;}
            else if (numbers[i] == 9) {
                count += 1;}
            else {
                return false;}
        }
    return true;
    }

    public static int countRuns ( int[] numbers ) {
        boolean inRun = false;
        int count = 0;
        int compare = numbers[0];
        int runs = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (compare == numbers[i]) {
                inRun = true;}
            if (inRun) {
                // only count the run once when it enters the run, and reset--make it ready for another count for runs
                // when it leaves the run and likely to enter a new run.
                if (count < 1) {
                    runs += 1;
                    count += 1;}
                // leaving the run.
                if (compare != numbers[i]) {
                    inRun = false;
                    count = 0;}}
            // works both when leaving the run and not inrun. the compare alwasy update.
            if (compare != numbers[i]) {
                compare = numbers[i];}
        }
    return runs;
    }

    public static int sum67 ( int[] numbers ) {
        boolean out67 = true;
        int total = 0;
        for (int i = 0; i < numbers.length; i++) {
            // the sequence is important.
            if (numbers[i] == 6) {
                out67 = false;}
            if (out67) {
                total += numbers[i];}
            if (numbers[i] == 7) {
                out67 = true;}
        }
    return total;
    }

    public static int mode ( int[] numbers ) {
        int result = 0;
        int compare = 1;
        for (int i = 0; i < numbers.length; i++){
            int count = 0;
            // loop inside a loop so compare the first digit to all other digits.
            for(int j = 0; j < numbers.length; j++){
                // if there's another same numbers in later parts of the array, count +1. It starts from 1 not 0.
                if (numbers[j] == numbers[i]){
                    count++;}
                // < sign to prevent showing the last mode instead of the first mode number.
            if (compare < count) {
                compare = count;
                result = numbers[i];}}}
        // deals with the situation when the array has only 1 number. And that number is the mode.
        if (numbers.length == 1) {
            result = numbers[0];}
        // when every number occurs only once so the first number is the mode.
        // This if only work when the for loop above result 0.
        if (result == 0) {
            result = numbers[0];}
    return result;
    }
}
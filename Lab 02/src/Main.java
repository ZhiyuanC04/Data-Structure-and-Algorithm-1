public class Main {
    public static void main(String[] args){
        SimpleDate test1 = new SimpleDate();
        test1.setDate(12,31,2023); //the year is not adding as the next day of the end of the year.
        test1.nextDay();
        System.out.println(test1);

        SimpleDate test2 = new SimpleDate();
        SimpleDate test3 = new SimpleDate();
        SimpleDate test4 = new SimpleDate();
        test2.setDate(6,31,2004);
        test3.setDate(12,31,2023);
        System.out.println(test2.lessThan(test3)); //test2 is less than test 3 but returns false.
//        System.out.println(test3);
        System.out.println(test2.equals(test3)); //not work when the date is same.
        test4.setDate(12,31,2000);
        test4.toString();
        System.out.println(test4);
    }
}

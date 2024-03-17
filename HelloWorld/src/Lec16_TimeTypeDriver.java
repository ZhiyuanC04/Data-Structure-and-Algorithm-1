import java.util.*;

public class Lec16_TimeTypeDriver
{
   public static void main (String [] args)
    { /*
      TimeType t = new TimeType();
      System.out.println(t.getHrs());
      t.setHrs(11);
      t.setMin(30);
      t.setSec(12);
      System.out.println("It is " + t.getHrs() + " hours and " + 
         t.getMins() + " minutes and " + t.getSecs() + " seconds.");
     t.setSec(120);
     t.setHrs(52);
     System.out.println("It is " + t.getHrs() + " hours and " + 
         t.getMins() + " minutes and " + t.getSecs() + " seconds.");
         
     TimeType dueTime = new TimeType(23, 59, 59);
     System.out.println("The due time is " + dueTime);
     for (int i = 0; i < 362; i++)
     {
         dueTime.increment();
         System.out.println("The due time is " + dueTime);
         
      }
      if (dueTime.lessThan(t))
         System.out.println("dueTime less");
      else
         System.out.println("t less");
      */
      // Begin Comparable testing
        Lec16_TimeType one = new Lec16_TimeType(10, 30, 30);
        Lec16_TimeType two = new Lec16_TimeType(10, 30, 30);
        Lec16_TimeType three = new Lec16_TimeType(10, 30, 31);
        Lec16_TimeType[] alpha = {three, two, one};

      if (one.compareTo(two) < 0)
          System.out.println("one is less than two");
      else
          System.out.println("one is bigger or equal to two");

      System.out.println("Before sort alpha is:");
      System.out.println(Arrays.toString(alpha));
      Arrays.sort(alpha);
      System.out.println("After sort alpha is:");
      System.out.println(Arrays.toString(alpha));
   }
}   
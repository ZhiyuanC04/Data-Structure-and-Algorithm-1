public class Lec16_TimeType implements Comparable<Lec16_TimeType>
{
   private int hrs, secs, mins;
   
   public int getHrs( ) { return hrs;}
	public int getMins( ) { return mins;}
	public int getSecs( ) { return secs;}
   
   public void setHrs(int initHrs) 
    {
	//  validate 0 <= initHrs <= 23
		if ( 0 <= initHrs && initHrs < 24) 		
		      hrs = initHrs;
	} 
   
   public void setMin(int initMin) 
    {
	//  validate 0 <= initHrs <= 59
		if ( 0 <= initMin && initMin < 60) 		
		      mins = initMin;
	} 

   public void setSec(int initSec) 
    {
	//  validate 0 <= initHrs <= 59
		if ( 0 <= initSec && initSec < 60) 		
		      secs = initSec;
	} 
   
   public Lec16_TimeType(int h, int m, int s)
   {
      setHrs(h);
      setMin(m);
      setSec(s);
   }

   public Lec16_TimeType()
   {  //int instance attributes default to 0
   }
   
   public String toString (  )		
	{    String holder= "";
	      if (hrs < 10)
		      holder = "0";
		holder += hrs + ":";
	      if (mins < 10)	
		      holder += '0';
	      holder += (mins + ":");
	      if (secs < 10)	
		      holder += '0';
	      holder += secs;
		return holder;
	}
   
   public void increment()
   {
      secs++;
      if (secs > 59)
      {
         secs = 0;
         mins++;
      }
      if (mins > 59)
      {
         mins = 0;
         hrs++;
      }
      if (hrs > 23)
      {
         hrs = 0;
      }
   }

   public boolean equals ( Lec16_TimeType other)
   {
      return (hrs == other.hrs && mins == other.mins && secs == other.secs);
      // return toString().equals(other.toString());
   }
   
   private boolean lessThan (Lec16_TimeType other)
   {
      boolean result = false;
      if (hrs < other.hrs)
         result = true;
      else if (hrs > other.hrs)
         result = false;
      else
      {
         if (mins < other.mins)
            result = true;
         else if (mins > other.mins)
            result = false;
         else
         {
            if (secs < other.secs)
               result = true;
            else
               result = false;
         }
      }
      return result;

   }

   public int compareTo(Lec16_TimeType other) {
	   if (lessThan(other))
		   return -1;
	   if (equals(other))
		   return 0;
	   return 1;
   }
}
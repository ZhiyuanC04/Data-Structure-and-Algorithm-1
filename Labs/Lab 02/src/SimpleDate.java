
/*
Name; Long, Levi
Date: 30/08/2015
*/

public class SimpleDate
{
  private int month;
  private int day;
  private int year;

  public static void main(String[] args){




  }

  /** default constructor
  *  sets month to 1, day to 1 and year to 2000
  */
  public SimpleDate( )
  {
    setDate( 2, 1, 2000 );
  }

  /** overloaded constructor
  *  @param mm    initial value for month
  *  @param dd    initial value for day
  *  @param yyyy  initial value for year
  *
  *  creates a SimpleDate object with the initial values of mm, dd, and yy
  */
  public SimpleDate( int mm, int dd, int yyyy )
  {
    setMonth( mm );
    setYear( yyyy );
    setDay( dd );
  }

  /* accessor methods */
  /** month accessor
  *  @return int  value for month
  *
  *  returns the value of month
  */
  int getMonth( ) { return month; }
  
  /** day accessor
  *  @return int  value for day
  *
  *  returns the value of day
  */
  int getDay( )   { return day; }
  
  /** year accessor
  *  @return int  value for year
  *
  *  returns the value of year
  */
  int getYear( )  { return year; }

  /** mutator method */
  /** setMonth
  *  @param mm new value for month
  *  if mm is invalid, does not change the value of month
  */
  public void setMonth( int mm )
  {
    int temp = month;
    month = ( mm >= 1 && mm <= 12 ? mm : temp );
    if (!isValidDay(day))
      month = temp;
  }

  /** setDay
  *  @param dd new value for day
  *  sets day to dd; if dd is invalid, does not change the value of day
  */
  public void setDay( int dd )
  {
    day = ( dd >= 1 && isValidDay( dd ) ? dd : 1 );
  }

  /** setYear
  *  @param yy new value for year
  *  sets year to yy if yy > 1000, otherwise year is set to 1900
  */
  public void setYear( int yy )
  {
    year = ( yy >= 1000 ? yy : 1900);
  }

  /** increments the date to the next day
  */
  public void nextDay( )
  {
     if ( ! isValidDay( ++day ) )
     {
         day = 1;
		 if ( ++month > 12 )
		 {
			 month = 1;
			 //year++;
		 }
	 }
  }

  private boolean isValidDay( int newDay )
  {
     int [] daysInMonth = { 0, 31, 28, 31,
	                            30, 31, 30,
	                            31, 31, 30,
                               31, 30, 31 };

    if ( newDay > daysInMonth[month] )
    {
	   if ( month == 2 && isLeapYear( ) && newDay == 29 )
	      return true;
	   else
	      return false;
    }
    else
       return true;

  }

  private boolean isLeapYear( )
  {
	 return !( year % 4 != 0
	           ||( year % 100 == 0)); // && year % 400 != 0 ) );
  }


  /** setDate
  *  @param mm    new value for month
  *  @param dd    new value for day
  *  @param yyyy  new value for year
  *  if valid, sets the date to mm/dd/yyyy
  */
  public void setDate( int mm, int dd, int yyyy )
  {
    setYear( yyyy );  // set year first (could be leap year)
    setMonth( mm );   // set month next
    setDay( dd );     // set day
  }

  /** toString
  *  @return String
  *  returns date in mm/dd/yyyy format
  */
  public String toString( )
  {
    return month + "/" + day + "/" + year;
  }

  /** equals
  *  @param   d  Object to compare to this object
  *  @return  true if d is equal to this object
  *           false, otherwise
  */
  public boolean equals( Object d ) 
  {
    if ( !( d instanceof SimpleDate ) )
       return false;
    SimpleDate d1 = (SimpleDate)d;
    /*if ( month == d1.month
         && day == d1.day
         && year == d1.year )
      return true;
    else
      return false; */
    return d == this;
  }

  /** equals
   *  @param   num  number of days to be added to this object
   *  adds num days to current date changing the current date
   */
  public void add( int num)
  {
    for (int i = 0; i < num; i++)
      nextDay();
  }

  /** lessThan
   *  @param   other  determines if other is less than current date
   *  @return  true if other is less than this object
   *           false, otherwise
   */
  public boolean lessThan( SimpleDate other)
  {
    if (other.year < year)
      return true;
    else if (other.year > year)
      return false;
    else if (other.month < month)
      return true;
    else if (other.month > month)
      return false;
    else //if (other.day < day)
      //return true;
    //else
      return false;
  }
}

   
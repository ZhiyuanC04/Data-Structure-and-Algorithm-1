public class Lec09_Weather {
        private double temperature; // in Fahrenheit
        private String sky;
        public static final double defaultTemp = 70.0;

        /**
         * Default constructor:<BR>
         * initializes temperature to 70.0 and sky to "sunny"
         * calls mutator methods to validate these default values
         */
        public Lec09_Weather( )
        {
            setTemperature( defaultTemp );
            setSky( "sunny" );
        }

        /**
         * Overloaded constructor:<BR>
         * Allows client to set beginning values for temperature and sky
         * This constructor takes two parameters<BR>
         * Calls mutator methods to validate new values
         * @param newTemperature the temperature for the weather forecast
         * @param newSky the sky conditions for the weather forecast
         */
        public Lec09_Weather( double newTemperature, String newSky )
        {
            setTemperature( newTemperature );
            setSky( newSky );
        }

        /** getTemperature method
         * @return the temperature
         */
        public double getTemperature( )
        {
            return temperature;
        }

        /**
         * Mutator method:<BR>
         * Allows client to set value of temperature
         * <B>setTemperature</B> sets the value of <B>temperature</B>
         *   to 70.0 if newTemperature is less than -50 or greater than 150
         * @param newTemperature the new number of temperature
         */
        public void setTemperature( double newTemperature )
        {
            if ( newTemperature >= -50 && newTemperature <= 150 )
                temperature = newTemperature;
            else
            {
                temperature = defaultTemp;
                System.err.println( "Temperature cannot be less than -50 or greater than 150." );
                System.err.println( "Temperature set to 70.0." );
            }
        }

        /** getSky method
         * @return the sky conditions
         */
        public String getSky( )
        {
            return sky;
        }

        /**
         * Mutator method:<BR>
         * Allows client to set value of sky
         * <B>setSky</B> sets the value of <B>sky</B>
         *   to "sunny" if newSky is neither "sunny", "snowy",
         *   "cloudy", nor "rainy"<BR>
         * This method is not case sensitive
         * @param newSky the new sky condition
         */
        public void setSky( String newSky )
        {
            newSky = newSky.toLowerCase( );
            if ( newSky.equals( "sunny" ) || newSky.equals( "snowy" )
                    || newSky.equals( "cloudy" ) || newSky.equals( "rainy" ) )
                sky = newSky;
            else
            {
                sky = "sunny";
                System.err.println( "Illegal value for sky." );
                System.err.println( "Sky set to sunny." );
            }
        }

        /**
         * @return the temperature and the sky conditions for the weather forecast
         */
        public String toString( )
        {
            return( "temperature: " + temperature + "; sky: " + sky );
        }

        /**
         * equals method
         * Compares two WeatherForecast objects for the same field values
         * @param wf another WeatherForecast object
         * @return a boolean, true if this object
         * has the same field values as the parameter wf
         */
        public boolean equals( Lec09_Weather wf )
        {
            return ( Math.abs( temperature - wf.temperature ) < 0.0001
                    && sky.equals( wf.sky ) );
        }

        /**
         * fahrenheitToCelsius method
         * Computes the degrees Celsius temperature
         * @return a double, the temperature value in degrees Celsius
         */
        public double fahrenheitToCelsius( )
        {
            return ( temperature - 32 ) * 5 / 9 ;
        }

        /**
         * isConsistent method
         * Checks if the temperature value and the sky conditions are compatible
         * @return a boolean, false if the temperature is below 32 and the sky is not snowy,
         *   or if the temperature is greater than 100 and the sky is not sunny, true otherwise
         */
        public boolean isConsistent( )
        {
            return !( ( temperature < 32 && !sky.equals( "snowy" ) )
                    || ( temperature > 100 && !sky.equals( "sunny" ) ) );
        }
}

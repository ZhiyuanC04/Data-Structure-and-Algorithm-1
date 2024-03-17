/* Team Client
 *  Tests information for a basketball team
 *  Morrison
 *  If you write your code correctly then you should not have to change anything
 *  in this file.  You may need to alter some of the calls to some methods,
 *  depending on how you write them.  Please highlight any lines changed.
 */

public class HW03_TeamClient
{
    public static void main( String [] args )
    {
        //first let's create an array of Players
        HW03_Player [] Caveliers = new HW03_Player[12];
        Caveliers[0] = new HW03_Player("Armaan Franklin", "guard", 12.7, 41.7, 71.4, 39.8);
        Caveliers[1] = new HW03_Player("Kihei Clark", "guard", 11.6, 42.5, 77.1, 40.0);
        Caveliers[2] = new HW03_Player("Jayden Gardner", "forward", 11.2, 51.9, 62.3, 0.0);
        Caveliers[3] = new HW03_Player("Reece Beekman", "guard", 10.0, 43.9, 84.2, 43.1);
        Caveliers[4] = new HW03_Player("Ben Vander Plas", "forward", 7.3, 40.2, 62.9, 32.1);
        Caveliers[5] = new HW03_Player("Kadin Shedrick", "forward", 7.0, 69.4, 82.6, 25.0);
        Caveliers[6] = new HW03_Player("Isaac McKneely", "guard", 6.6, 41.8, 73.3, 43.9);
        Caveliers[7] = new HW03_Player("Ryan Dunn", "guard", 2.9, 51.2, 70.0, 30.8);
        Caveliers[8] = new HW03_Player("Francisco Caffaro", "center", 1.7, 69.2, 50, 0);
        Caveliers[9] = new HW03_Player("Taine Murray", "guard", 1.5, 28.6, 75, 10);
        Caveliers[10] = new HW03_Player("Tristan How", "forward", 1.0, 25, 25, 0);
        Caveliers[11] = new HW03_Player("Chase Coleman","guard", 0.8, 16.7, 33.3, 25);
        // now instantiate the team calling the overloaded consstructor
        HW03_Team cavs = new HW03_Team(Caveliers);

//        System.out.println(Caveliers[0].getPosition()==Caveliers[2].getPosition());

        // now let's print the team (call toString)
        System.out.println(cavs);

//        System.out.println(cavs.toString());

        // instantiate identical object
        HW03_Team cavs2 = new HW03_Team( Caveliers);

        // calling accessors
        HW03_Player [ ] xx = cavs2.getTeam();
        System.out.println( "The players on cavs2 are: ");
        for (int i = 0; i < xx.length; i++)
            System.out.println(xx[i]);

        System.out.println();

//        System.out.println(cavs.toString2());
//        System.out.println(cavs2.toString2());
        // test equals
        System.out.println( cavs.equals( cavs2 ) );
        System.out.println( cavs.equals( cavs2 ) );
        if ( cavs.equals( cavs2 ) )
            System.out.println( "Objects are equal (this is correct)" );
        else
            System.out.println( "Objects are not equal (WRONG)" );

        // change some data
        System.out.println( "\nUsing mutators to change cavs3 data" );
        Caveliers[0].setFT(0.250);
        Caveliers[0].setName("Ralph Sampson");
        Caveliers[0].setPosition("center");
        HW03_Team cavs3 = new HW03_Team(Caveliers);
        // call toString
        System.out.println( "\ncavs3:\n" + cavs3 );

        // test equals again
        if ( cavs.equals( cavs3 ) )
            System.out.println( "Objects are equal (WRONG)" );
        else
            System.out.println( "Objects are not equal (This is correct)" );

        System.out.println();

        // find team FG percentage
        System.out.println( "\ncavs FG averages:" );
        System.out.println( cavs.FGAverage());
        System.out.println( );
        System.out.println( );

        // number of centers?
        int x = (cavs3.positionCount("CENTER"));
            System.out.println( "cavs3 have " + x + " centers (should be 2)");

        System.out.println();

        // test sort
        System.out.println("Caveliers sorted by free throw pt %, descending");
        HW03_Player [ ] sort = cavs.sort();
        for (int i = 0; i < sort.length; i++)
            System.out.println(sort[i]);

        System.out.println();
        // test for players on team
        String name = "Ralph Sampson";
        if (cavs.onTeam(name)) //CAVS!
            System.out.println(name + " is on the cavs. (WRONG)");
        else
            System.out.println(name + " is not on the cavs. (This is correct)");

        name = "Kihei Clark";
        if (cavs.onTeam(name))
            System.out.println(name + " is on the cavs. (This is correct)");
        else
            System.out.println(name + " is not on the cavs. (WRONG)");

        // test best 3 point shooter
        HW03_Player p =  cavs.best3pt();
        System.out.println("cavs best 3 point shooter is " + p.getName());
//        System.out.println(cavs); // Cavs CHANGED
    }
}
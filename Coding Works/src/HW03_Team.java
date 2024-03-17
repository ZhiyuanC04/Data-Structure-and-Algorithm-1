// Name: Zhiyuan Chang
// Computing ID: vgs3qt
// Homework Name: HW 3 - Basketball

// Team class, store values of a team. It's a array of Player values.
public class HW03_Team {
    HW03_Player[] team;
    // constructor, set team value.
    public HW03_Team(HW03_Player[] players) {
        setTeam(players);
    }
    // set team value to those values inputed.
    public void setTeam(HW03_Player[] players) {
        // deep copy first.
        HW03_Player[] fin = new HW03_Player[players.length];
        for (int i = 0; i < players.length; i++) {
            fin[i] = new HW03_Player(players[i].getName(),players[i].getPosition(),players[i].getPPG(),players[i].getFP()
                    ,players[i].getTPP(),players[i].getFTP());
        }
        team = new HW03_Player[fin.length];
        // put the deep copy into team, so change the out side one won't effect team.
        for (int i = 0; i < fin.length; i++) {
            team[i] = fin[i];
        }
    }
    // return team value. Do not leak the private data.
    public HW03_Player[] getTeam() {
        // deep copy first.
        HW03_Player[] fin = new HW03_Player[team.length];
        for (int i = 0; i < this.team.length; i++) {
            fin[i] = new HW03_Player(team[i].getName(),team[i].getPosition(),team[i].getPPG(),team[i].getFP()
                    ,team[i].getTPP(),team[i].getFTP());
        }
        return fin;
    }
    // return team value as a string.
    public String toString() {
        String fin = "";
        for (int i = 0; i < this.team.length; i++) {
            fin += team[i].getName()+" "+team[i].getPosition()+" "+team[i].getPPG()+" "+team[i].getFP()
                    +" "+team[i].getTPP()+" "+team[i].getFTP()+"\n";
        }
        return fin;
    }
    // return true is two team value is same, false otherwise.
    public boolean equals(Object other) {
        HW03_Team compare = (HW03_Team) other;
        HW03_Player[] com = compare.getTeam();
        for (int i = 0; i < this.team.length; i++) {
            if(team[i].getName().equals(com[i].getName())) {
            }
        else {
            return false;
            }
        }
        return true;
    }
    // return the average field_goal_percentage.
    public double FGAverage() {
        double result = 0.0;
        double fin = 0.0;
        // add up and get average.
        for (int i = 0; i < this.team.length; i++) {
            result += team[i].getFP();
            fin = result / team.length;
        }
        return fin;
    }
    // return number of players in that position.
    public int positionCount(String pos) {
        int result = 0;
        for (int i = 0; i < this.team.length; i++) {
            // case insensitive.
            if (team[i].getPosition().toUpperCase().equals(pos.toUpperCase())) {
                result += 1;
            }
        }
        return result;
    }
    // return another Player[] array with players sorted based on the free_throw_percentage.
    public HW03_Player[] sort() {
        HW03_Player temp;
        // deep copy first.
        HW03_Player[] fin = new HW03_Player[team.length];
        for (int i = 0; i < this.team.length; i++) {
            fin[i] = new HW03_Player(team[i].getName(),team[i].getPosition(),team[i].getPPG(),team[i].getFP()
                    ,team[i].getTPP(),team[i].getFTP());
        }
        // swap positions.
        for (int i = 0; i < fin.length; i++) {
            for (int j = 0; j < fin.length; j++) {
                if (fin[i].getFTP() > fin[j].getFTP()) {
                    temp = fin[i];
                    fin[i] = fin[j];
                    fin[j] = temp;
                }
            }
        }
        return fin;
    }
    // return true is the player inputed is in the team.
    public boolean onTeam(String name) {
        for (int i = 0; i < this.team.length; i++) {
            if (this.team[i].getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    // return the player with best three_point_percentage. 
    public HW03_Player best3pt() {
        double best_point = -1.0;
        HW03_Player best_man = team[0];
        // memorize the biggest and return it.
        for (int i = 0; i < team.length; i++) {
            if (team[i].getTPP() > best_point) {
                best_point = team[i].getTPP();
                best_man = team[i];
            }
        }
        return best_man;
    }
}
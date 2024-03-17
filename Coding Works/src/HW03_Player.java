// Name: Zhiyuan Chang
// Computing ID: vgs3qt
// Homework Name: HW 3 - Basketball

// Player Class, store values of each player.
public class HW03_Player {
    String name = " ";
    String position = " ";
    double points_per_game = 0.0;
    double field_goal_percentage = 0.0;
    double three_point_percentage = 0.0;
    double free_throw_percentage = 0.0;
    // constructor, set values to default.
    public HW03_Player() {
        name = " ";
        position = " ";
        points_per_game = 0.0;
        field_goal_percentage = 0.0;
        three_point_percentage = 0.0;
        free_throw_percentage = 0.0;
    }
    // constructor, set values to those inputed.
    public HW03_Player(String name, String position, double points_per_game, double field_goal_percentage,
                  double three_point_percentage, double free_throw_percentage) {
        setName(name);
        setPosition(position);
        setPoints_per_game(points_per_game);
        setField_goal_percentage(field_goal_percentage);
        setFT(free_throw_percentage);
        setThree_point_percentage(three_point_percentage);
    }
    // set the name value.
    public void setName(String player) {
        this.name = player;
    }
    // set the position value.
    public void setPosition(String position) {
        position = position.toLowerCase();
        if(position.equals("center")||position.equals("guard")||position.equals("forward")) {
            this.position = position;
        }
    }
    // set the points_per_game value.
    public void setPoints_per_game(double points_per_game) {
        if(points_per_game > 0){
            this.points_per_game = points_per_game;
        }
    }
    // set the field_goal_percentage value.
    public void setField_goal_percentage(double field_goal_percentage) {
        if(field_goal_percentage > 0){
            this.field_goal_percentage = field_goal_percentage;
        }
    }
    // set the three_point_percentage value.
    public void setThree_point_percentage(double three_point_percentage) {
        if (three_point_percentage > 0) {
            this.three_point_percentage = three_point_percentage;
        }
    }
    // set the free_throw_percentage value.
    public void setFT(double free_throw_percentage) {
        if(free_throw_percentage > 0){
            this.free_throw_percentage = free_throw_percentage;
        }
    }
    // return the name value.
    public String getName() {
        return this.name;
    }
    // return the position value.
    public String getPosition() {
        return this.position;
    }
    // return the points_per_game value.
    public double getPPG() {
        return this.points_per_game;
    }
    // return the field_goal_percentage value.
    public double getFP() {
        return this.field_goal_percentage;
    }
    // return the three_point_percentage value.
    public double getTPP() {
        return this.three_point_percentage;
    }
    // return the free_throw_percentage value.
    public double getFTP() {
        return this.free_throw_percentage;
    }
    // return every value in a string.
    public String toString() {
        return (name+" "+position+" "+points_per_game+" "+field_goal_percentage
            +" "+three_point_percentage+" "+free_throw_percentage);
    }
}
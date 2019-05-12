package robot;
import planet.Planet;
import util.Coord;

public class Mineral_extractor extends Robot {

    private boolean is_mining;
    private boolean is_going_to_base;
    private CEO_robot chief;
    private boolean mark_on;
    public Mineral_extractor(Base s_base, int s_life, String name, CEO_robot chief, Planet planet) {

        super(s_life, s_base, name, planet);
        this.mark_on = false;
        this.chief = chief;
        this.Name = name;
        is_mining = false;
        is_going_to_base = false;
        System.out.println("Agent " + Name + " au rapport !");
    }


    public void communicate () {

        //TODO
        chief.sendData();
    }


    public void move() {
        if(is_going_to_base) {
            // astar
        } else {
            Coord c = sensor.is_there_mineral_around();
            if(c != null){
                // go to mineral
                this.setCoord(c);
            } else {
                // go random but not from where we come from
            }
        }
    }



    public void mine() {

    }

    public void turn() {
        if(!is_mining) {
            move();
        } else {
            mine();
        }
    }
}

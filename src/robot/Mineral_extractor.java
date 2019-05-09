package robot;
import util.Coord;

public class Mineral_extractor extends Robot {

    private CEO_robot chief;
    private boolean mark_on;
    public Mineral_extractor(String name, Coord coord, CEO_robot chief1) {

        mark_on = false;
        chief = chief1;
        Name = name;
        this.coord = coord;
        System.out.println("Agent " + Name + " au rapport !");
    }


    public void communicate () {

        //TODO
        chief.sendData();
    }


    public void move() {

    }
}

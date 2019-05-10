package robot;
import util.Coord;

public class Mineral_extractor extends Robot {

    private CEO_robot chief;
    private boolean mark_on;
    public Mineral_extractor(Base s_base, int s_life, String name, CEO_robot chief) {

        super(s_life, s_base, name);
        this.mark_on = false;
        this.chief = chief;
        this.Name = name;
        System.out.println("Agent " + Name + " au rapport !");
    }


    public void communicate () {

        //TODO
        chief.sendData();
    }


    public void move() {

    }
}

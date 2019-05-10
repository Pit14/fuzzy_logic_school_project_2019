package robot;
import util.Coord;

abstract class Robot {

    protected String Name;
    protected Coord coord;
    protected Sensor sensor;
    protected int life;
    protected Base base;


    public Robot(int life, Base base, String name) {
        this.coord = base.getCoord();
        this.life = life;
        this.base = base;
        this.Name = name;
    }

    //  abstract void communicate();&
    abstract void move();



}

package robot;
import planet.Planet;
import util.Coord;

abstract class Robot {

    protected Planet planet;
    protected String Name;
    protected Coord coord;
    protected Sensor sensor;
    protected int life;
    protected Base base;
    private CEO_robot chief;

    public Robot(int life, Base base, String name, Planet planet, CEO_robot chief) {
        this.coord = base.getCoord();
        this.life = life;
        this.base = base;
        this.Name = name;
        this.sensor = new Sensor(this);
        this.planet = planet;
        this.chief = chief;
        if(chief != null) {
            this.getChief().add_robot_to_list(this);
        }
    }

    public CEO_robot getChief() {
        return chief;
    }

    public void setChief(CEO_robot chief) {
        this.chief = chief;
    }

    public Coord getCoord() {
        return coord;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }



    //  abstract void communicate();&
    abstract void move(Coord destination);



}

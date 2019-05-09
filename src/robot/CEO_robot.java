package robot;
import util.Cell;
import util.Coord;

public class CEO_robot extends Robot {

    private Coord coord;
    private Cell[][] resources_map;
    private Cell[][] pipeline_map;
    private Base base;


    public CEO_robot(String name, Coord coord, Base base) {
        this.Name = name;
        this.coord = coord;
        this.base = base;
        System.out.println("Agent " + Name + " au rapport !");
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public Cell[][] getResources_map() {
        return resources_map;
    }

    public void setResources_map(Cell[][] resources_map) {
        this.resources_map = resources_map;
    }

    public Cell[][] getPipeline_map() {
        return pipeline_map;
    }

    public void setPipeline_map(Cell[][] pipeline_map) {
        this.pipeline_map = pipeline_map;
    }

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }

    public void add_water( int deposit) {
        base.setWater(base.getWater()+deposit);
    }

    public void take_water ( int consumption) {
        base.setWater(base.getWater()-consumption);
    }

    public void add_food( int deposit) {
        base.setFood(base.getFood()+ deposit);
    }

    public void take_food ( int consumption) {
        base.setFood(base.getFood()-consumption);
    }

    public void add_mineral( int deposit) {
         base.setMineral(base.getMineral() + deposit);
    }

    public void take_mineral ( int consumption) {
        base.setMineral(base.getMineral() - consumption);
    }

    public void sendData() {

    }

    public void move(){
        // nothing
    }

    public void display_base_ressources() {
        System.out.println("Water : " + this.base.getWater());
        System.out.println("Food : " + this.base.getFood());
        System.out.println("Ressouces : " + this.base.getMineral());
    }

    public void turn() {
        display_base_ressources();
    }
}

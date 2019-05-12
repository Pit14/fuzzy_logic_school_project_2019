package robot;
import planet.Planet;
import util.Cell;
import util.Coord;

public class CEO_robot extends Robot {

    private Cell[][] resources_map;
    private Cell[][] pipeline_map;

    public CEO_robot(Base s_base, int s_life, String name, Planet planet) {
        super(s_life, s_base, name, planet);
        System.out.println("Agent " + Name + " au rapport !");
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

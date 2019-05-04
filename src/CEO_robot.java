public class CEO_robot extends Robot {


    private int food;
    private int water;
    private int resources;
    private Cell[][] resources_map;
    private Cell[][] pipeline_map;

    public CEO_robot(String name, Coord coord) {
        Name = name;
        this.coord = coord;
        System.out.println("Agent " + Name + " au rapport !");
    }

    public void add_water( int deposit) {
        water += deposit;
    }

    public void take_water ( int consumption) {
        water -= consumption;
    }

    public void add_food( int deposit) {
        food += deposit;
    }

    public void take_food ( int consumption) {
        food -= consumption;
    }

    public void add_resources( int deposit) {
        resources += deposit;
    }

    public void take_resources ( int consumption) {
        resources -= consumption;
    }

    public void sendData() {

    }

    public void move(){
        // nothing
    }
}

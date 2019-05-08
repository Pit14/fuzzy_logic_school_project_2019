public class CEO_robot extends Robot {


    private int NOURRITURE;
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

    public void add_NOURRITURE( int deposit) {
        NOURRITURE += deposit;
    }

    public void take_NOURRITURE ( int consumption) {
        NOURRITURE -= consumption;
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

public class Agent_reactif {

    private String Name;
    private Coord coord;
    private Sensor sensor;

    public Agent_reactif(String name, Coord coord) {
        Name = name;
        this.coord = coord;
        System.out.println("Agent " + Name + " au rapport !");
    }

    public void move(Coord dest_coord){
        if(true){ // if we can move on this coord
            this.coord = dest_coord;
        }
    }


}

package robot;
import planet.Planet;
import util.Cell;
import util.Coord;

public class Mineral_extractor extends Robot {

    private boolean is_mining;
    private boolean is_going_to_base;
    private CEO_robot chief;
    private Coord marked_coord;
    private boolean is_carrying_ore;
    public Mineral_extractor(Base s_base, int s_life, String name, CEO_robot chief, Planet planet) {

        super(s_life, s_base, name, planet);
        this.chief = chief;
        this.Name = name;
        is_mining = false;
        is_going_to_base = false;
        is_carrying_ore = false;
        System.out.println("Agent " + Name + " au rapport !");
    }


    public void communicate () {

        //TODO
        chief.sendData();
    }

    public void move(Coord destination) {
        if(is_going_to_base) {
            // astar
        } else {

        }
    }

    public void mine() {
        Cell mine = this.planet.getCells()[this.coord.getX()][this.coord.getY()];
        mine.setOre(mine.getOre()-2);
        is_going_to_base = true;
        is_carrying_ore = true;
    }

    public void turn() {
        if(is_mining) { // we found an mine and are currently mining it
            if(is_carrying_ore){ // we got some ore to deposit at the base
                System.out.println("Retour à la base");
                move(this.base.getCoord());
            } else {
                if (this.coord == marked_coord) {
                    mine();
                } else {
                    move(marked_coord);
                    System.out.println("Retour à la mine");
                }
            }
        } else { // looking for a mine
            look_for_ore();
        }
    }

    private void look_for_ore() {
        Coord c = sensor.is_there_mineral_around();
        System.out.println(c);

        if(c != null){ // mineral around the robot, we go to the cell
            // go to mineral
            this.setCoord(c);
            is_mining = true;

            this.planet.getCells()[c.getX()][c.getY()].setIs_marked_mine(true);
            this.marked_coord = c;

        } else { // go random but not from where we come from
            //TODO
            this.setCoord(new Coord(this.getCoord().getX()+1, this.getCoord().getY()));
        }
    }

    public byte getBit(int position, byte b)
    {
        return (byte) ((byte) (b >> position) & 1);
    }

}

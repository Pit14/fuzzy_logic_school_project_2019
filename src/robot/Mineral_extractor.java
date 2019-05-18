package robot;
import planet.Planet;
import util.Cell;
import util.Coord;

public class Mineral_extractor extends Robot {

    private boolean is_mining;
    private boolean is_going_to_base;
    private Coord marked_coord;
    private int ore;
    public Mineral_extractor(Base s_base, int s_life, String name, CEO_robot chief, Planet planet) {

        super(s_life, s_base, name, planet, chief);
        this.Name = name;
        is_mining = false;
        is_going_to_base = false;
        ore = 0;
        System.out.println("Agent " + Name + " au rapport !");
    }


    public void communicate () {
        //TODO
//        chief.sendData();
    }

    /**
     * The robot will move directly toward the destination, but for the moment, it cannot avoid obstacle
     * @param destination
     */
    public void move(Coord destination) {
        if (this.getCoord().getX() < destination.getX()) { // robot north
//            System.out.println("NORTH");
            if (this.getPlanet().is_available(this.getCoord().getX() + 1, this.getCoord().getY())) {
                this.setCoord(new Coord(this.getCoord().getX() + 1, this.getCoord().getY()));
            }

        }

        if (this.getCoord().getX() > destination.getX()) { // robot south
//            System.out.println("south");

            if (this.getPlanet().is_available(this.getCoord().getX() - 1, this.getCoord().getY())) {
                this.setCoord(new Coord(this.getCoord().getX() - 1, this.getCoord().getY()));
            }

        }

        if (this.getCoord().getY() < destination.getY()) { // robot west
//            System.out.println("WEST");
            if (this.getPlanet().is_available(this.getCoord().getX(), this.getCoord().getY()+1)) {
                this.setCoord(new Coord(this.getCoord().getX(), this.getCoord().getY()+1));
            }

        }

        if (this.getCoord().getY() > destination.getY()) { // robot east
//            System.out.println("east");

            if (this.getPlanet().is_available(this.getCoord().getX(), this.getCoord().getY()-1)) {
                this.setCoord(new Coord(this.getCoord().getX(), this.getCoord().getY()-1));
            }

        }


    }

    public void mine() {
        Cell mine = this.planet.getCells()[this.coord.getX()][this.coord.getY()];
        mine.setOre(mine.getOre()-2);
        is_going_to_base = true;
        this.ore += 2;
        this.planet.setExtraction(this.planet.getExtraction() + 2);
    }

    public void turn() {
        if(is_mining) { // we found an mine and are currently mining it

            if(this.ore > 0){ // we got some ore to deposit at the base
//                System.out.println(this.getCoord().getX() + this.base.getCoord().getX());

                if((this.getCoord().getX() == this.base.getCoord().getX())
                && (this.getCoord().getY() == this.base.getCoord().getY())
                ){

                    this.base.setMineral(this.base.getMineral() + this.ore);
                    this.ore = 0;
                }
                move(this.base.getCoord());


            } else {
                if ((this.getCoord().getX() == marked_coord.getX())
                 && (this.getCoord().getY() == marked_coord.getY())) {
                    mine();
                } else {
                    move(marked_coord);
                }
            }
        } else { // looking for a mine
            look_for_ore();
        }
//        System.out.println(this.getPlanet().getCells()[this.getCoord().getX()][this.getCoord().getY()].getState());

    }

    private void look_for_ore() {
        Coord c = sensor.is_there_mineral_around();

        if(c != null){ // mineral around the robot, we go to the cell
            // go to mineral
            this.setCoord(c);
            is_mining = true;

            this.planet.getCells()[c.getX()][c.getY()].setIs_marked_mine(true);
            this.marked_coord = c;

        } else { // go random but not from where we come from
            Coord rc = new Coord(0,0);
            do {
                rc = Coord.random_coord(this.getCoord());
            } while(!this.getPlanet().is_available(rc.getX(),rc.getY()));
            this.setCoord(rc);
        }
    }

    public byte getBit(int position, byte b)
    {
        return (byte) ((byte) (b >> position) & 1);
    }

}

package robot;
import util.Cell;
import util.Coord;
import util.State;

public class Sensor {

    private Robot robot;

    public Sensor(Robot robot) {
        this.robot = robot;
    }

    /**
     * return the coord of the first mineral cell found nearby
     * @return coord to mineral cell nearby
     */
    public Coord is_there_mineral_around() {
        Coord c = this.robot.getCoord();
        int x = c.getX();
        int y = c.getY();
        //System.out.println(this.robot.getPlanet().getCells()[x][y].getState());


        if(x-1 >= 0 && y-1 >= 0) {

            if (this.robot.getPlanet().getCells()[x-1][y-1].getState() == State.MINERAI) {
                return new Coord(x - 1, y - 1);
            }
        }

        if(x-1 >= 0) {

            if(this.robot.getPlanet().getCells()[x-1][y].getState() == State.MINERAI) {
                return new Coord(x - 1, y);
            }
        }

        if(x-1 >= 0 && y+1 <= 21) {

            if(this.robot.getPlanet().getCells()[x-1][y+1].getState() == State.MINERAI) {
                return new Coord(x - 1, y + 1);
            }
        }

        if(y-1 <= 0) {

            if(this.robot.getPlanet().getCells()[x][y-1].getState() == State.MINERAI) {
                return new Coord(x, y - 1);
            }
        }
        if( y+1 <= 21) {

            if(this.robot.getPlanet().getCells()[x][y+1].getState() == State.MINERAI) {
                return new Coord(x, y + 1);
            }
        }
        if(x+1 <= 21 && y-1 <= 0) {

            if(this.robot.getPlanet().getCells()[x+1][y-1].getState() == State.MINERAI) {
                return new Coord(x + 1, y - 1);
            }
        }
        if(x+1 <= 21) {

            if(this.robot.getPlanet().getCells()[x+1][y].getState() == State.MINERAI) {
                return new Coord(x + 1, y);
            }        }

        if(x+1 <= 21 && y+1 <= 21) {

            if(this.robot.getPlanet().getCells()[x+1][y+1].getState() == State.MINERAI) {
                return new Coord(x + 1, y + 1);
            }
        }

        return null;
    }

    public byte get_environment() {
        byte b = 0b00000000;
        int x, y;
        x = this.robot.getCoord().getX();
        y = this.robot.getCoord().getY();

        if(this.robot.getPlanet().is_available(x-1,y-1) && !this.robot.getChief().is_there_robot(x,y) ) { // NW
            b = (byte) (b & 0b00000001);
        }


        return b;
    }

}
package robot;

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
        System.out.println(this.robot.getPlanet().getCells()[x][y].getState());

        if(this.robot.getPlanet().getCells()[x-1][y-1].getState() == State.MINERAI) {
            return new Coord(x - 1, y - 1);
        }
        if(this.robot.getPlanet().getCells()[x-1][y].getState() == State.MINERAI) {
            return new Coord(x - 1, y);
        }
        if(this.robot.getPlanet().getCells()[x-1][y+1].getState() == State.MINERAI) {
            return new Coord(x - 1, y + 1);
        }
        if(this.robot.getPlanet().getCells()[x][y-1].getState() == State.MINERAI) {
            return new Coord(x, y - 1);
        }
        if(this.robot.getPlanet().getCells()[x][y+1].getState() == State.MINERAI) {
            return new Coord(x, y + 1);
        }
        if(this.robot.getPlanet().getCells()[x+1][y-1].getState() == State.MINERAI) {
            return new Coord(x + 1, y - 1);
        }
        if(this.robot.getPlanet().getCells()[x+1][y].getState() == State.MINERAI) {
            return new Coord(x + 1, y);
        }
        if(this.robot.getPlanet().getCells()[x+1][y+1].getState() == State.MINERAI) {
            return new Coord(x + 1, y + 1);
        }

        return null;
    }


//on doit passer une referénce a la planette lors de la création du robot pour pouvoir agier dessus
  /*  public State getScan() {
        return .....
    }*/
}

 // lib pour logique flou, faire fctn d'appartenance, la lib calcul en fonction de nos règles
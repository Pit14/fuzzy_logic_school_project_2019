package util;

public class Cell {
    private Coord coord;
    private State state;

    public Cell(Coord coord, State state) {
        this.coord = coord;
        this.state = state;
    }

    public Coord getCoord() {
        return coord;
    }

    public State getState() {
        return state;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public void setState(State state) {
        this.state = state;
    }
}

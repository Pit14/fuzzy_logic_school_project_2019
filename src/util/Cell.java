package util;

public class Cell {
    private Coord coord;
    private State state;
    private int ore;
    private boolean is_marked_mine;

    public Cell(Coord coord, State state) {
        this.coord = coord;
        this.state = state;
        if (this.state == State.MINERAI) {
            this.ore = 100;
        } else { this.ore = 0;}
        is_marked_mine = false;
    }

    public boolean isIs_marked_mine() {
        return is_marked_mine;
    }

    public void setIs_marked_mine(boolean is_marked_mine) {
        this.is_marked_mine = is_marked_mine;
    }

    public int getOre() {
        return ore;
    }

    public void setOre(int ore) {
        this.ore = ore;
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

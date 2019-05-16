package util;

import java.util.Random;

public class Coord {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean is_valid_coord(){
        if(this.getX() < 0 || this.getX() > 21 ||
                this.getY() < 0 || this.getY() >21){
            return false;
        }
        return true;
    }

    public static Coord random_coord(Coord coord) {

        Random rand = new Random();
        int n = rand.nextInt(8) + 1;

        switch (n){
            case 1:
                return new Coord(coord.getX()-1,coord.getY()-1);
            case 2:
                return new Coord(coord.getX()-1,coord.getY());
            case 3:
                return new Coord(coord.getX()-1,coord.getY()+1);
            case 4:
                return new Coord(coord.getX(),coord.getY()-1); // s
            case 5:
                return new Coord(coord.getX()+1,coord.getY()-1); // se
            case 6:
                return new Coord(coord.getX()+1,coord.getY()); // e
            case 7:
                return new Coord(coord.getX()+1,coord.getY()+1); // ne
            case 8:
                return new Coord(coord.getX(),coord.getY()+1); // n
            default:
                return new Coord(coord.getX(),coord.getY());


        }
    }
}

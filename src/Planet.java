public class Planet {

    private static final int HEIGHT = 22;
    private static final int WIDTH = 22;

    Cell[][] cells;

    public Planet() {
        this.cells = new Cell[HEIGHT][WIDTH];
        int x,y;

        for(y=0;y<HEIGHT;y++){
            for(x=0;x<WIDTH;x++){
                cells[y][x] = new Cell(new Coord(y,x),State.MINERAL);
            }
        }

        //top left lake :
        for(x=0;x<4;x++){
            cells[0][x].setState(State.LAKE);
        }
        for(y=1;y<4;y++){
            cells[y][0].setState(State.LAKE);
        }
        cells[1][1].setState(State.LAKE);

        //Desert
        for(x=6;x<12;x++){
            cells[0][x].setState(State.DESERT);
        }
        for(x=6;x<10;x++){
            cells[1][x].setState(State.DESERT);
        }
        for(x=6;x<9;x++){
            cells[2][x].setState(State.DESERT);
        }
        for(x=6;x<8;x++){
            cells[3][x].setState(State.DESERT);
        }
        cells[4][7].setState(State.DESERT);


    }

    void display_map() {
        int x,y;
        for(y=0;y<HEIGHT;y++){
            for(x=0;x<WIDTH;x++){
//                System.out.print(cells[y][x].getState().toString());
                display_cell(cells[y][x].getState());
            }
            System.out.println("");
        }
    }

    void display_cell(State s){
        switch(s){
            case MINERAL:
                System.out.print("[M] ");
                break;
            case LAKE:
                System.out.print("[L] ");
                break;
            case DESERT:
                System.out.print("[D] ");
                break;
            default:
                System.out.print("[x] ");
                break;



        }
    }
}

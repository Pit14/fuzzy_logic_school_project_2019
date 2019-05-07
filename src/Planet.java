public class Planet {

    private static final int HEIGHT = 22;
    private static final int WIDTH = 22;

    Cell[][] cells;

    public Planet() {
        System.out.println("Instanciation de la planète.");
        this.cells = new Cell[HEIGHT][WIDTH];
        int x,y;

        for(y=0;y<HEIGHT;y++){
            for(x=0;x<WIDTH;x++){
                cells[y][x] = new Cell(new Coord(y,x),State.MINERAL);
            }
        }

        State[][] states = {
            {State.LAKE,State.LAKE,State.LAKE,State.LAKE,State.DRY_LAND,State.WET_LAND,State.DESERT,State.DESERT,State.DESERT,State.DESERT,State.DESERT,State.DESERT,State.WET_LAND,State.DRY_LAND,State.DRY_LAND,State.DRY_LAND,State.WET_LAND,State.DRY_LAND,State.DRY_LAND,State.MINERAL,State.USELESS_ROCK},
            {State.LAKE,State.LAKE,State.DRY_LAND,State.DRY_LAND,State.DRY_LAND,State.WET_LAND,State.DESERT,State.DESERT,State.DESERT,State.DESERT,State.DRY_LAND,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.DRY_LAND,State.WET_LAND,State.DRY_LAND,State.DRY_LAND,State.MINERAL,State.USELESS_ROCK,State.USELESS_ROCK},
            {State.LAKE,State.DRY_LAND,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.DRY_LAND,State.DESERT,State.DESERT,State.DESERT,State.DRY_LAND,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.MINERAL,State.USELESS_ROCK,State.LAKE,State.USELESS_ROCK},
            {State.LAKE,State.USELESS_ROCK,State.WET_LAND,State.WET_LAND,State.DRY_LAND,State.DRY_LAND,State.DESERT,State.DESERT,State.MINERAL,State.DRY_LAND,State.WET_LAND,State.LAKE,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.MINERAL,State.USELESS_ROCK,State.USELESS_ROCK,State.MINERAL},
            {State.DRY_LAND,State.USELESS_ROCK,State.LAKE,State.USELESS_ROCK,State.USELESS_ROCK,State.USELESS_ROCK,State.DRY_LAND,State.DESERT,State.DRY_LAND,State.DRY_LAND,State.WET_LAND,State.LAKE,State.LAKE,State.WET_LAND,State.WET_LAND,State.MINERAL,State.MINERAL,State.MINERAL,State.LAKE,State.LAKE,State.LAKE},
            {State.DRY_LAND,State.DRY_LAND,State.USELESS_ROCK,State.USELESS_ROCK,State.USELESS_ROCK,State.MINERAL,State.MINERAL,State.DRY_LAND,State.DRY_LAND,State.DRY_LAND,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.MINERAL,State.MINERAL,State.LAKE,State.LAKE,State.LAKE,State.MINERAL},
            {State.WET_LAND,State.DRY_LAND,State.USELESS_ROCK,State.LAKE,State.USELESS_ROCK,State.USELESS_ROCK,State.USELESS_ROCK,State.USELESS_ROCK,State.MINERAL,State.MINERAL,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.USELESS_ROCK,State.LAKE,State.LAKE,State.MINERAL,State.WET_LAND},
            {State.DRY_LAND,State.DRY_LAND,State.LAKE,State.LAKE,State.MINERAL,State.USELESS_ROCK,State.USELESS_ROCK,State.USELESS_ROCK,State.MINERAL,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.USELESS_ROCK,State.USELESS_ROCK,State.MINERAL,State.LAKE,State.MINERAL,State.WET_LAND,State.WET_LAND},
            {State.WET_LAND,State.DRY_LAND,State.DRY_LAND,State.DRY_LAND,State.DRY_LAND,State.MINERAL,State.MINERAL,State.USELESS_ROCK,State.MINERAL,State.DRY_LAND,State.USELESS_ROCK,State.DRY_LAND,State.MINERAL,State.USELESS_ROCK,State.USELESS_ROCK,State.MINERAL,State.WET_LAND,State.MINERAL,State.WET_LAND,State.MINERAL,State.MINERAL},
            {State.DRY_LAND,State.LAKE,State.DRY_LAND,State.DRY_LAND,State.DRY_LAND,State.DRY_LAND,State.DRY_LAND,State.USELESS_ROCK,State.USELESS_ROCK,State.MINERAL,State.MINERAL,State.USELESS_ROCK,State.USELESS_ROCK,State.MINERAL,State.MINERAL,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.MINERAL,State.MINERAL},
            {State.LAKE,State.DRY_LAND,State.LAKE,State.DRY_LAND,State.WET_LAND,State.WET_LAND,State.MINERAL,State.MINERAL,State.USELESS_ROCK,State.MINERAL,State.USELESS_ROCK,State.USELESS_ROCK,State.MINERAL,State.MINERAL,State.MINERAL,State.MINERAL,State.MINERAL,State.WET_LAND,State.MINERAL,State.MINERAL,State.MINERAL},
            {State.LAKE,State.LAKE,State.LAKE,State.DRY_LAND,State.MINERAL,State.MINERAL,State.WET_LAND,State.DRY_LAND,State.WET_LAND,State.WET_LAND,State.USELESS_ROCK,State.USELESS_ROCK,State.MINERAL,State.MINERAL,State.MINERAL,State.MINERAL,State.MINERAL,State.MINERAL,State.MINERAL,State.MINERAL,State.MINERAL},
            {State.LAKE,State.WET_LAND,State.DRY_LAND,State.LAKE,State.DRY_LAND,State.DRY_LAND,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.MINERAL,State.USELESS_ROCK,State.WET_LAND,State.USELESS_ROCK,State.MINERAL,State.MINERAL,State.MINERAL,State.MINERAL,State.MINERAL,State.MINERAL,State.MINERAL,State.WET_LAND},
            {State.WET_LAND,State.WET_LAND,State.WET_LAND,State.LAKE,State.MINERAL,State.MINERAL,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.MINERAL,State.USELESS_ROCK,State.MINERAL,State.MINERAL,State.MINERAL,State.MINERAL,State.WET_LAND,State.MINERAL,State.WET_LAND,State.MINERAL},
            {State.WET_LAND,State.LAKE,State.LAKE,State.LAKE,State.MINERAL,State.MINERAL,State.WET_LAND,State.MINERAL,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.USELESS_ROCK,State.USELESS_ROCK,State.MINERAL,State.MINERAL,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.MINERAL,State.MINERAL,State.MINERAL},
            {State.DRY_LAND,State.DRY_LAND,State.LAKE,State.LAKE,State.DRY_LAND,State.DRY_LAND,State.WET_LAND,State.WET_LAND,State.USELESS_ROCK,State.USELESS_ROCK,State.USELESS_ROCK,State.USELESS_ROCK,State.USELESS_ROCK,State.USELESS_ROCK,State.MINERAL,State.MINERAL,State.MINERAL,State.WET_LAND,State.MINERAL,State.DRY_LAND,State.DRY_LAND},
            {State.LAKE,State.LAKE,State.LAKE,State.LAKE,State.MINERAL,State.USELESS_ROCK,State.USELESS_ROCK,State.USELESS_ROCK,State.USELESS_ROCK,State.USELESS_ROCK,State.WET_LAND,State.MINERAL,State.MINERAL,State.USELESS_ROCK,State.USELESS_ROCK,State.USELESS_ROCK,State.DRY_LAND,State.MINERAL,State.LAKE,State.LAKE,State.LAKE},
            {State.WET_LAND,State.LAKE,State.USELESS_ROCK,State.USELESS_ROCK,State.USELESS_ROCK,State.USELESS_ROCK,State.USELESS_ROCK,State.WET_LAND,State.MINERAL,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.USELESS_ROCK,State.USELESS_ROCK,State.USELESS_ROCK,State.MINERAL,State.LAKE,State.LAKE},
            {State.LAKE,State.USELESS_ROCK,State.USELESS_ROCK,State.LAKE,State.MINERAL,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.LAKE,State.LAKE,State.MINERAL,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.MINERAL,State.USELESS_ROCK,State.USELESS_ROCK,State.LAKE,State.LAKE},
            {State.LAKE,State.USELESS_ROCK,State.USELESS_ROCK,State.LAKE,State.MINERAL,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.LAKE,State.LAKE,State.MINERAL,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.MINERAL,State.USELESS_ROCK,State.USELESS_ROCK,State.LAKE,State.LAKE},
            {State.USELESS_ROCK,State.USELESS_ROCK,State.LAKE,State.WET_LAND,State.MINERAL,State.MINERAL,State.WET_LAND,State.MINERAL,State.DRY_LAND,State.DRY_LAND,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.WET_LAND,State.DRY_LAND,State.LAKE,State.LAKE,State.LAKE,State.LAKE}
        };


        for(y=0;y<HEIGHT-1;y++){
            for(x=0;x<WIDTH-1;x++){
                cells[y][x].setState(states[y][x]);
            }
        }

//        //top left State.LAKE :
//        for(x=0;x<4;x++){
//            cells[0][x].setState(State.State.LAKE);
//        }
//        for(y=1;y<4;y++){
//            cells[y][0].setState(State.State.LAKE);
//        }
//        cells[1][1].setState(State.State.LAKE);
//
//        //State.DESERTsert
//        for(x=6;x<12;x++){
//            cells[0][x].setState(State.State.DESERTSERT);
//        }
//        for(x=6;x<10;x++){
//            cells[1][x].setState(State.State.DESERTSERT);
//        }
//        for(x=6;x<9;x++){
//            cells[2][x].setState(State.State.DESERTSERT);
//        }
//        for(x=6;x<8;x++){
//            cells[3][x].setState(State.State.DESERTSERT);
//        }
//        cells[4][7].setState(State.State.DESERTSERT);


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

package planet;

import util.Cell;
import util.Coord;
import util.State;

public class Planet {

    private static final int HEIGHT = 21;
    private static final int WIDTH = 21;

    private Cell[][] cells;

    public Cell[][] getCells() {
        return cells;
    }

    public Planet() {
        System.out.println("Instanciation de la planète.");
        this.cells = new Cell[HEIGHT][WIDTH];
        int x,y;

        for(y=0;y<HEIGHT;y++){
            for(x=0;x<WIDTH;x++){
                cells[y][x] = new Cell(new Coord(y,x), State.MINERAI);
            }
        }

        State[][] states = {
                {State.LAC,State.LAC,State.LAC,State.LAC,State.PRAIRIE_SECHE,State.PRAIRIE_GRASSE,State.DESERT,State.DESERT,State.DESERT,State.DESERT,State.DESERT,State.DESERT,State.PRAIRIE_GRASSE,State.PRAIRIE_SECHE,State.PRAIRIE_SECHE,State.PRAIRIE_SECHE,State.PRAIRIE_GRASSE,State.PRAIRIE_SECHE,State.PRAIRIE_SECHE,State.MINERAI,State.PIERRAILLE},
                {State.LAC,State.LAC,State.PRAIRIE_SECHE,State.PRAIRIE_SECHE,State.PRAIRIE_SECHE,State.PRAIRIE_GRASSE,State.DESERT,State.DESERT,State.DESERT,State.DESERT,State.PRAIRIE_SECHE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_SECHE,State.PRAIRIE_GRASSE,State.PRAIRIE_SECHE,State.PRAIRIE_SECHE,State.NOURRITURE,State.PIERRAILLE,State.PIERRAILLE},
                {State.LAC,State.PRAIRIE_SECHE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_SECHE,State.DESERT,State.DESERT,State.DESERT,State.PRAIRIE_SECHE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_NORMALE,State.PIERRAILLE,State.LAC,State.PIERRAILLE},
                {State.LAC,State.PIERRAILLE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_SECHE,State.PRAIRIE_SECHE,State.DESERT,State.DESERT,State.ZONE_INFRANCHISSABLE,State.PRAIRIE_SECHE,State.PRAIRIE_GRASSE,State.LAC,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_NORMALE,State.PIERRAILLE,State.PIERRAILLE,State.NOURRITURE},
                {State.PRAIRIE_SECHE,State.PIERRAILLE,State.PIERRAILLE,State.PIERRAILLE,State.PRAIRIE_SECHE,State.PRAIRIE_SECHE,State.PRAIRIE_SECHE,State.DESERT,State.PRAIRIE_SECHE,State.PRAIRIE_SECHE,State.PRAIRIE_GRASSE,State.LAC,State.LAC,State.PRAIRIE_GRASSE,State.NOURRITURE,State.PRAIRIE_NORMALE,State.PRAIRIE_NORMALE,State.PRAIRIE_NORMALE,State.LAC,State.LAC,State.LAC},
                {State.PRAIRIE_SECHE,State.PRAIRIE_SECHE,State.PRAIRIE_GRASSE,State.PIERRAILLE,State.PIERRAILLE,State.PIERRAILLE,State.PRAIRIE_GRASSE,State.PRAIRIE_SECHE,State.PRAIRIE_SECHE,State.PRAIRIE_SECHE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.NOURRITURE,State.PRAIRIE_GRASSE,State.PRAIRIE_NORMALE,State.ZONE_INFRANCHISSABLE,State.LAC,State.LAC,State.LAC,State.PRAIRIE_NORMALE},
                {State.PRAIRIE_GRASSE,State.PRAIRIE_SECHE,State.PIERRAILLE,State.PIERRAILLE,State.PIERRAILLE,State.MINERAI,State.PRAIRIE_GRASSE,State.PRAIRIE_NORMALE,State.PRAIRIE_NORMALE,State.PRAIRIE_NORMALE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.LAC,State.LAC,State.LAC,State.PRAIRIE_NORMALE,State.PRAIRIE_GRASSE},
                {State.PRAIRIE_SECHE,State.PRAIRIE_SECHE,State.PIERRAILLE,State.MINERAI,State.PIERRAILLE,State.PIERRAILLE,State.PIERRAILLE,State.PIERRAILLE,State.PRAIRIE_NORMALE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PIERRAILLE,State.LAC,State.PRAIRIE_NORMALE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE},
                {State.PRAIRIE_GRASSE,State.PRAIRIE_SECHE,State.PRAIRIE_SECHE,State.PRAIRIE_SECHE,State.PRAIRIE_SECHE,State.PIERRAILLE,State.PIERRAILLE,State.PIERRAILLE,State.PRAIRIE_GRASSE,State.PRAIRIE_SECHE,State.PRAIRIE_NORMALE,State.PRAIRIE_SECHE,State.PRAIRIE_NORMALE,State.PRAIRIE_NORMALE,State.PIERRAILLE,State.PIERRAILLE,State.PRAIRIE_GRASSE,State.NOURRITURE,State.PRAIRIE_GRASSE,State.PRAIRIE_NORMALE,State.PRAIRIE_NORMALE},
                {State.PRAIRIE_SECHE,State.PRAIRIE_GRASSE,State.PRAIRIE_SECHE,State.PRAIRIE_SECHE,State.PRAIRIE_SECHE,State.PRAIRIE_SECHE,State.PRAIRIE_SECHE,State.PIERRAILLE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PIERRAILLE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PIERRAILLE,State.PIERRAILLE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_NORMALE,State.PRAIRIE_NORMALE},
                {State.FORET,State.PRAIRIE_SECHE,State.PRAIRIE_GRASSE,State.PRAIRIE_SECHE,State.PRAIRIE_SECHE,State.PRAIRIE_SECHE,State.ZONE_INFRANCHISSABLE,State.PIERRAILLE,State.PIERRAILLE,State.PRAIRIE_GRASSE,State.BASE,State.PIERRAILLE,State.PIERRAILLE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_SECHE,State.PRAIRIE_SECHE,State.PRAIRIE_GRASSE,State.PRAIRIE_NORMALE,State.LAC,State.LAC},
                {State.FORET,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_SECHE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_SECHE,State.PRAIRIE_SECHE,State.PIERRAILLE,State.LAC,State.PIERRAILLE,State.PIERRAILLE,State.PRAIRIE_NORMALE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_NORMALE,State.LAC,State.PRAIRIE_NORMALE,State.LAC,State.LAC,State.PRAIRIE_NORMALE},
                {State.FORET,State.PRAIRIE_GRASSE,State.PRAIRIE_SECHE,State.LAC,State.PRAIRIE_SECHE,State.PRAIRIE_SECHE,State.PRAIRIE_GRASSE,State.PRAIRIE_SECHE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PIERRAILLE,State.PIERRAILLE,State.PRAIRIE_NORMALE,State.PRAIRIE_NORMALE,State.NOURRITURE,State.LAC,State.PRAIRIE_NORMALE,State.PRAIRIE_NORMALE,State.LAC,State.FORET,State.FORET},
                {State.FORET,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_NORMALE,State.NOURRITURE,State.LAC,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.NOURRITURE,State.PIERRAILLE,State.PRAIRIE_GRASSE,State.PIERRAILLE,State.PRAIRIE_NORMALE,State.PRAIRIE_NORMALE,State.NOURRITURE,State.FORET,State.FORET,State.FORET,State.FORET,State.FORET},
                {State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.NOURRITURE,State.NOURRITURE,State.LAC,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.MINERAI,State.PIERRAILLE,State.PRAIRIE_NORMALE,State.PRAIRIE_SECHE,State.FORET,State.FORET,State.FORET,State.FORET,State.FORET,State.PRAIRIE_GRASSE},
                {State.PRAIRIE_GRASSE,State.NOURRITURE,State.NOURRITURE,State.PRAIRIE_GRASSE,State.LAC,State.LAC,State.PRAIRIE_GRASSE,State.ZONE_INFRANCHISSABLE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PIERRAILLE,State.PIERRAILLE,State.PRAIRIE_SECHE,State.PRAIRIE_NORMALE,State.FORET,State.FORET,State.PRAIRIE_GRASSE,State.FORET,State.PRAIRIE_GRASSE,State.PRAIRIE_NORMALE},
                {State.LAC,State.LAC,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_SECHE,State.PRAIRIE_SECHE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PIERRAILLE,State.PIERRAILLE,State.PIERRAILLE,State.PIERRAILLE,State.PIERRAILLE,State.PIERRAILLE,State.PRAIRIE_NORMALE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.NOURRITURE,State.PRAIRIE_SECHE,State.PRAIRIE_SECHE},
                {State.PRAIRIE_NORMALE,State.PRAIRIE_NORMALE,State.PRAIRIE_NORMALE,State.PRAIRIE_NORMALE,State.PRAIRIE_NORMALE,State.PIERRAILLE,State.PIERRAILLE,State.PIERRAILLE,State.PIERRAILLE,State.PIERRAILLE,State.PRAIRIE_GRASSE,State.PRAIRIE_NORMALE,State.PRAIRIE_NORMALE,State.PIERRAILLE,State.PIERRAILLE,State.PIERRAILLE,State.PRAIRIE_SECHE,State.PRAIRIE_GRASSE,State.PRAIRIE_NORMALE,State.PRAIRIE_NORMALE,State.LAC},
                {State.PRAIRIE_GRASSE,State.PRAIRIE_NORMALE,State.PIERRAILLE,State.PIERRAILLE,State.PIERRAILLE,State.PIERRAILLE,State.PIERRAILLE,State.PRAIRIE_GRASSE,State.PRAIRIE_NORMALE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PIERRAILLE,State.PIERRAILLE,State.PIERRAILLE,State.LAC,State.LAC,State.LAC},
                {State.LAC,State.PIERRAILLE,State.PIERRAILLE,State.LAC,State.LAC,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.LAC,State.LAC,State.PRAIRIE_NORMALE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.MINERAI,State.PIERRAILLE,State.PIERRAILLE,State.LAC,State.LAC},
                {State.PIERRAILLE,State.PIERRAILLE,State.LAC,State.PRAIRIE_GRASSE,State.ZONE_INFRANCHISSABLE,State.NOURRITURE,State.PRAIRIE_GRASSE,State.PRAIRIE_NORMALE,State.PRAIRIE_SECHE,State.PRAIRIE_SECHE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_GRASSE,State.PRAIRIE_SECHE,State.LAC,State.LAC,State.LAC,State.LAC}
        };


        for(y=0;y<HEIGHT;y++){
            for(x=0;x<WIDTH;x++){
                cells[y][x].setState(states[y][x]);
            }
        }
    }

    public void metamorphose(int transformation_percentage){
        int x,y,rand;

        for(y=0;y<HEIGHT;y++){
            for(x=0;x<WIDTH;x++){
                rand = (int)(Math.random() * 101);
//                System.out.println(rand);
                if(rand < transformation_percentage){
                    cells[y][x].setState(pick_state(cells[y][x].getState()));
                }
            }
        }
    }

    private State pick_state(State s) {
        int rand = (int)(Math.random() * 100);

        switch (s){
            case FORET:
                return pick_state_foret(rand);
            case PRAIRIE_SECHE:
                return pick_state_prairie_seche(rand);
            case PRAIRIE_NORMALE:
                return pick_state_prairie_normal(rand);
            case PRAIRIE_GRASSE:
                return pick_state_prairie_grasse(rand);
            case DESERT:
                return pick_state_desert(rand);
            case NOURRITURE:
                return pick_state_nourriture(rand);
            case ZONE_INFRANCHISSABLE:
                return pick_state_zone_infranchissable(rand);
            case PIERRAILLE:
                return pick_state_pierralle(rand);
            case MINERAI:
                return pick_state_minerai(rand);
            case LAC:
                return State.LAC;
                default:
                    return State.BASE;
        }
    }

    private State pick_state_foret(int rand) {
        if(rand < 20) {
            return State.PRAIRIE_SECHE;
        } else if (rand < 50) {
            return State.PRAIRIE_NORMALE;
        } else if(rand < 90) {
            return State.PRAIRIE_GRASSE;
        } else if(rand < 99) {
            return State.DESERT;
        } else {
            return State.ZONE_INFRANCHISSABLE;
        }
    }

    private State pick_state_prairie_seche(int rand) {
        if(rand < 80) {
            return State.DESERT;
        } else if (rand < 99) {
            return State.NOURRITURE;
        } else {
            return State.ZONE_INFRANCHISSABLE;
        }
    }

    private State pick_state_prairie_normal(int rand) {
        if(rand < 10) {
            return State.DESERT;
        } else if (rand < 70) {
            return State.PRAIRIE_SECHE;
        } else {
            return State.NOURRITURE;
        }
    }

    private State pick_state_prairie_grasse(int rand) {
        if(rand < 5) {
            return State.DESERT;
        } else if (rand < 45) {
            return State.PRAIRIE_NORMALE;
        } else if (rand < 75) {
            return State.PRAIRIE_SECHE;
        }else {
            return State.NOURRITURE;
        }
    }

    private State pick_state_desert(int rand) {
        if(rand < 30) {
            return State.PRAIRIE_SECHE;
        } else {
            return State.ZONE_INFRANCHISSABLE;
        }
    }
    private State pick_state_nourriture(int rand) {
        if(rand < 50) {
            return State.PRAIRIE_GRASSE;
        } else if (rand < 80) {
            return State.PRAIRIE_NORMALE;
        } else if (rand < 90) {
            return State.PRAIRIE_SECHE;
        }else {
            return State.FORET;
        }
    }

    private State pick_state_zone_infranchissable(int rand) {
        if(rand < 30) {
            return State.DESERT;
        } else {
            return State.ZONE_INFRANCHISSABLE;
        }
    }

    private State pick_state_pierralle(int rand) {
        if(rand < 2) {
            return State.MINERAI;
        } else {
            return State.PIERRAILLE;
        }
    }

    private State pick_state_minerai(int rand) {
        if(rand < 5) {
            return State.PIERRAILLE;
        } else {
            return State.MINERAI;
        }
    }



}

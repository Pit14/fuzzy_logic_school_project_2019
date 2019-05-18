package util;

import javafx.scene.image.Image;

public class Images_manager {

    Image la = new Image ("img/lake.PNG");
    Image mi = new Image ("img/minerai.png");
    Image gr = new Image ("img/prairie_grasse.png");
    Image de = new Image ("img/desert.png");
    Image dr = new Image ("img/prairie_seche.png");
    Image ro = new Image ("img/pierraille.png");
    Image fo = new Image ("img/food.png");
    Image zo = new Image ("img/zone_infranchissable.png");
    Image di = new Image ("img/prairie_normale.png");
    Image ba = new Image ("img/base.png");
    Image ar = new Image ("img/foret.png");
    public static Image robot = new Image("img/robot.PNG");

    public void Images_manager(){

    }

    public Image StateToImage(State s){

        switch (s){
            case PIERRAILLE:
                return ro;
            case PRAIRIE_GRASSE:
                return gr;
            case MINERAI:
                return mi;
            case LAC:
                return la;
            case DESERT:
                return de;
            case PRAIRIE_SECHE:
                return dr;
            case NOURRITURE:
                return fo;
            case ZONE_INFRANCHISSABLE:
                return zo;
            case PRAIRIE_NORMALE:
                return di;
            case BASE:
                return ba;
            case FORET:
                return ar;
            default:
                return mi;
        }
    }
}

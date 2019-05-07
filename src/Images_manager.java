import javafx.scene.image.Image;

public class Images_manager {

    Image la = new Image ("img/lake.jpg");
    Image mi = new Image ("img/mineral.png");
    Image gr = new Image ("img/grass.png");
    Image de = new Image ("img/desert.png");
    Image dr = new Image ("img/dry_land.jpg");
    Image ro = new Image ("img/useless_rock.jpg");

    public void Images_manager(){

    }

    public Image StateToImage(State s){

        switch (s){
            case USELESS_ROCK:
                return ro;
            case WET_LAND:
                return gr;
            case MINERAL:
                return mi;
            case LAKE:
                return la;
            case DESERT:
                return de;
            case DRY_LAND:
                return dr;
            default:
                return mi;
        }
    }
}

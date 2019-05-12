import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import planet.Planet;
import robot.Base;
import robot.CEO_robot;
import robot.Mineral_extractor;
import util.Coord;
import util.Images_manager;

public class Simulation {

    private static final int MAX_DAY = 2922;
    private static final int HEIGHT = 21;
    private static final int WIDTH = 21;
    Image[][] grid; // = new Image[HEIGHT][WIDTH];
    GridPane gridPane = new GridPane();

    Planet planet = new Planet();
    Images_manager i = new Images_manager();

    public Simulation() {
        this.grid = initalizing_grid();
    }

    public void run_simulation() {

        display_map();

        int x = 1;
        int metamorphose_factor;
        Base base = new Base();

        CEO_robot ceo_robot = new CEO_robot(base, 100, "CEO", planet);

        Mineral_extractor extractor_1 = new Mineral_extractor(base, 100, "Extractor 1", ceo_robot, planet);


        while(x <= MAX_DAY) {
            System.out.println("\n\n\nBeginning of day : " + x);

            ceo_robot.turn();

            metamorphose_factor = fuzzy_lite();
            planet.metamorphose(metamorphose_factor);
            display_map();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            x ++;
        }
    }

    public void display_map(){
        int x,y;

        for(y=0;y<HEIGHT;y++){
            for(x=0;x<WIDTH;x++){
                grid[y][x] = i.StateToImage(planet.getCells()[y][x].getState());
            }
        }
        for (y = 0 ; y < grid.length ; y++) {
            for (x = 0 ; x < grid[y].length ; x++) {
                ((ImageView)gridPane.getChildren().get(y*21 + x)).setImage(grid[y][x]);
            }
        }

        ((ImageView)gridPane.getChildren().get(0)).setImage(new Image ("img/food2.PNG"));

    }

    public Image[][] initalizing_grid() {
        Images_manager i = new Images_manager();
        Image[][] grid = new Image[HEIGHT][WIDTH];

        int y,x;
        for(y=0;y<HEIGHT;y++){
            for(x=0;x<WIDTH;x++){
                grid[y][x] = i.StateToImage(planet.getCells()[y][x].getState());
            }
        }
        return grid;
    }

    public int fuzzy_lite(){
        return 15;
    }
}

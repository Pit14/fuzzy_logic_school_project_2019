import fuzzyLogic.fuzzyClass;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import planet.Planet;
import robot.Base;
import robot.CEO_robot;
import robot.Mineral_extractor;
import util.Images_manager;

public class Simulation {

    private boolean running;

    private static final int MAX_DAY = 2922;
    public static  int HEIGHT = 21;
    public static final int WIDTH = 21;
    Image[][] grid; // = new Image[HEIGHT][WIDTH];
    GridPane gridPane = new GridPane();
    Mineral_extractor extractor_1;
    Mineral_extractor extractor_2;
    Mineral_extractor extractor_3;
    fuzzyClass fuzzy = new fuzzyClass();
    CEO_robot ceo_robot;

    Planet planet = new Planet();
    Images_manager i = new Images_manager();

    private int extraction;



    /**
     * In the constructor of the simulation we implement the robots, the base, and the Images grid
     */
    public Simulation() {
        Base base = new Base();
        this.ceo_robot = new CEO_robot(base, 100, "CEO", planet);
        this.extractor_1 = new Mineral_extractor(base, 100, "Extractor 1", ceo_robot, planet);
        this.extractor_2 = new Mineral_extractor(base, 100, "Extractor 2", ceo_robot, planet);
        this.extractor_3 = new Mineral_extractor(base, 100, "Extractor 3", ceo_robot, planet);
        this.grid = initalizing_grid();
        this.setRunning(true);
    }

    /**
     * simple while loop in which we make action for everyday of the simulation
     */
    public void run_simulation() {

        display_map();

        int x = 1;
        int metamorphose_factor;

        while(x <= MAX_DAY && isRunning()) {
            System.out.println("\n\n\nBeginning of day : " + x);
            planet.setExtraction(0);

            ceo_robot.turn();
            extractor_1.turn();
            extractor_2.turn();
            extractor_3.turn();

            metamorphose_factor = fuzzy_logic(0,planet.getExtraction());
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

    /**
     * display the map and the robot in the javafx window
     */
    public void display_map(){
        flush();
        int x,y;

        for(x=0;x<HEIGHT;x++){
            for(y=0;y<WIDTH;y++){
                grid[x][y] = i.StateToImage(planet.getCells()[x][y].getState());
            }
        }
        for (x = 0 ; x < grid.length ; x++) {
            for (y = 0 ; y < grid[x].length ; y++) {
                ((ImageView) ((Group)gridPane.getChildren().get(x*21 + y)).getChildren().get(0)).setImage(grid[x][y]);
            }
        }

        ((ImageView) ((Group)gridPane.getChildren().get(ceo_robot.getCoord().getX()*21 + ceo_robot.getCoord().getY()))
                .getChildren().get(1)).setImage(Images_manager.robot);

        ((ImageView) ((Group)gridPane.getChildren().get(extractor_1.getCoord().getX()*21 + extractor_1.getCoord().getY()))
                .getChildren().get(1)).setImage(Images_manager.robot);
        ((ImageView) ((Group)gridPane.getChildren().get(extractor_2.getCoord().getX()*21 + extractor_2.getCoord().getY()))
                .getChildren().get(1)).setImage(Images_manager.robot);
        ((ImageView) ((Group)gridPane.getChildren().get(extractor_3.getCoord().getX()*21 + extractor_3.getCoord().getY()))
                .getChildren().get(1)).setImage(Images_manager.robot);

    }

    private void flush() {
        int x,y;

        for (x = 0 ; x < grid.length ; x++) {
            for (y = 0 ; y < grid[x].length ; y++) {
                ((ImageView) ((Group)gridPane.getChildren().get(x*21 + y)).getChildren().get(1)).setImage(null);
            }
        }
    }

    /**
     * initialise the image grid depending on the state of the cell
     * @return array of images
     */
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

    public int fuzzy_logic(int prelev, int extract){
        return fuzzy.getMeta(prelev,extract);
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }


}

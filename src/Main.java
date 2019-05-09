import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import planet.Planet;
import util.Images_manager;

public class Main extends Application {

    private static final int HEIGHT = 21;
    private static final int WIDTH = 21;
    GridPane gridPane = new GridPane();
    private final int tileSize = 45 ;
    Planet planet = new Planet();
    Image[][] grid = new Image[HEIGHT][WIDTH];
    Images_manager i = new Images_manager();


    @Override
    public void start(Stage primaryStage) throws Exception{
        int x,y;
        grid = initalizing_grid();

        // for visualizing the different squares:
        gridPane.setHgap(0);
        gridPane.setVgap(0);
        gridPane.setStyle("-fx-background-color: grey;");

        for (y = 0 ; y < grid.length ; y++) {
            for (x = 0 ; x < grid[y].length ; x++) {
                ImageView imageView = new ImageView(grid[y][x]);
                imageView.setFitWidth(tileSize);
                imageView.setFitHeight(tileSize);
                gridPane.add(imageView, x, y);
            }
        }
        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();

        display_map(grid, i, planet);

        new Thread(new Runnable() {
            @Override
            public void run() {
                int x = 0;
                while(x < 1000) {
                    planet.metamorphose(50);
                    display_map(grid, i, planet);

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                    x ++;
                }

            }
        }).start();

    }

    private Image[][] initalizing_grid() {
        Image[][] grid = new Image[HEIGHT][WIDTH];

        int y,x;
        for(y=0;y<HEIGHT;y++){
            for(x=0;x<WIDTH;x++){
                grid[y][x] = i.StateToImage(planet.getCells()[y][x].getState());
            }
        }
        return grid;
    }

    public static void main(String[] args) {
        launch(args);


    }

    public void display_map(Image[][] grid, Images_manager i, Planet planet){
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

    }
}

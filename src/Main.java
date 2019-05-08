import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.concurrent.TimeUnit;

public class Main extends Application {

    private static final int HEIGHT = 21;
    private static final int WIDTH = 21;

    private final int tileSize = 45 ;

    @Override
    public void start(Stage primaryStage) throws Exception{

        Planet planet = new Planet();
        Images_manager i = new Images_manager();
        Image[][] grid = new Image[HEIGHT][WIDTH];
        int x =0;
//        while(x < 100) {
            planet.metamorphose(50);

            display_map(primaryStage,grid,planet,i);


            x ++;
//        }

    }

    public static void main(String[] args) {
        launch(args);
    }

    public void display_map(Stage primaryStage, Image[][] grid, Planet planet, Images_manager i){

        int x,y;

        for(y=0;y<HEIGHT;y++){
            for(x=0;x<WIDTH;x++){
                grid[y][x] = i.StateToImage(planet.cells[y][x].getState());
            }
        }

        GridPane gridPane = new GridPane();

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
    }
}

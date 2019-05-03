package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    private final int tileSize = 45 ;

    @Override
    public void start(Stage primaryStage) throws Exception{

        Image la = new Image ("img/lake.jpg");
        Image mi = new Image ("img/mineral.png");
        Image gr = new Image ("img/grass.png");
        Image de = new Image ("img/desert.png");
        Image dr = new Image ("img/dry_land.jpg");
        Image ro = new Image ("img/useless_rock.jpg");

        Image[][] grid = {
                {la,la,la,la,dr,gr,de,de,de,de,de,de,gr,dr,dr,dr,gr,dr,dr,mi,ro},
                {la,la,dr,dr,dr,gr,de,de,de,de,dr,gr,gr,gr,dr,gr,dr,dr,mi,ro,ro},
                {la,dr,gr,gr,gr,dr,de,de,de,dr,gr,gr,gr,gr,gr,gr,gr,mi,ro,la,ro},
                {la,ro,gr,gr,dr,dr,de,de,mi,dr,gr,la,gr,gr,gr,gr,gr,mi,ro,ro,mi},
                {dr,ro,la,ro,ro,ro,dr,de,dr,dr,gr,la,la,gr,gr,mi,mi,mi,la,la,la},
                {dr,dr,ro,ro,ro,mi,mi,dr,dr,dr,gr,gr,gr,gr,gr,mi,mi,la,la,la,mi},
                {gr,dr,ro,la,ro,ro,ro,ro,mi,mi,gr,gr,gr,gr,gr,gr,ro,la,la,mi,gr},
                {dr,dr,la,la,mi,ro,ro,ro,mi,gr,gr,gr,gr,gr,ro,ro,mi,la,mi,gr,gr},
                {gr,dr,dr,dr,dr,mi,mi,ro,mi,dr,ro,dr,mi,ro,ro,mi,gr,mi,gr,mi,mi},
                {dr,la,dr,dr,dr,dr,dr,ro,ro,mi,mi,ro,ro,mi,mi,gr,gr,gr,gr,mi,mi},
                {la,dr,la,dr,dr,dr,mi,mi,ro,mi,ro,ro,mi,mi,mi,mi,mi,gr,mi,mi,mi},
                {la,la,la,dr,mi,mi,dr,dr,mi,mi,ro,ro,mi,mi,mi,mi,mi,mi,mi,mi,mi},
                {la,gr,dr,la,dr,dr,mi,dr,mi,mi,ro,mi,ro,mi,mi,mi,mi,mi,mi,mi,mi},
                {gr,gr,gr,la,mi,mi,mi,mi,mi,mi,mi,mi,ro,mi,mi,mi,mi,mi,mi,mi,mi},
                {gr,la,la,la,mi,mi,mi,mi,mi,mi,mi,ro,ro,mi,mi,mi,mi,mi,mi,mi,mi},
                {dr,dr,la,la,dr,dr,mi,mi,ro,ro,ro,ro,ro,ro,mi,mi,mi,mi,mi,dr,dr},
                {la,la,la,la,mi,ro,ro,ro,ro,ro,gr,mi,mi,ro,ro,ro,dr,mi,la,la,la},
                {gr,la,ro,ro,ro,ro,ro,gr,mi,gr,gr,gr,gr,gr,gr,ro,ro,ro,mi,la,la},
                {la,ro,ro,la,mi,gr,gr,gr,la,la,mi,gr,gr,gr,gr,gr,mi,ro,ro,la,la},
                {ro,ro,la,gr,mi,mi,gr,mi,dr,dr,gr,gr,gr,gr,gr,gr,dr,la,la,la,la}
        };

        GridPane gridPane = new GridPane();

        // for visualizing the different squares:
        gridPane.setHgap(0);
        gridPane.setVgap(0);
        gridPane.setStyle("-fx-background-color: grey;");

        for (int y = 0 ; y < grid.length ; y++) {
            for (int x = 0 ; x < grid[y].length ; x++) {
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




    public static void main(String[] args) {
        launch(args);
    }
}

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.stage.WindowEvent;

public class Main extends Application {

    private final int tileSize = 45 ;

    @Override
    public void start(Stage primaryStage) throws Exception{

        Simulation simulation = new Simulation();

        int x,y;

        // for visualizing the different squares:
        simulation.gridPane.setHgap(0);
        simulation.gridPane.setVgap(0);
        simulation.gridPane.setStyle("-fx-background-color: none;");

        for (y = 0 ; y < simulation.grid.length ; y++) {
            for (x = 0 ; x < simulation.grid[y].length ; x++) {
                ImageView imageView = new ImageView(simulation.grid[y][x]);
                ImageView imageView2 = new ImageView(simulation.grid[y][x]);
                Group group = new Group(imageView,imageView2);
                imageView.setFitWidth(tileSize);
                imageView.setFitHeight(tileSize);
                imageView2.setFitWidth(tileSize);
                imageView2.setFitHeight(tileSize);
//                simulation.gridPane.add(imageView, x, y);
                simulation.gridPane.add(group, x, y);
            }
        }

        Scene scene = new Scene(simulation.gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.setOnHiding(event -> simulation.setRunning(false));

        new Thread(new Runnable() {
            @Override
            public void run() {

                simulation.run_simulation();

            }
        }).start();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

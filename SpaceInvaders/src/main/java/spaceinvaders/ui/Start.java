package spaceinvaders.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import spaceinvaders.Invader;
import spaceinvaders.Shot;
import spaceinvaders.Spaceship;

public class Start extends Application {

    public static int WIDTH = 500;
    public static int HEIGHT = 500;


    @Override
    public void start(Stage stage) throws Exception {
        Pane board = new Pane();
        board.setPrefSize(WIDTH, HEIGHT);

        Spaceship ship = new Spaceship(WIDTH / 2, HEIGHT-10);
        Shot ammo = new Shot(WIDTH /2, HEIGHT/2);
        Invader enemy = new Invader(WIDTH/2 , 40);
        
        board.getChildren().add(ship.getCharacter());
        board.getChildren().add(ammo.getCharacter());
        board.getChildren().add(enemy.getCharacter());

        Scene scene = new Scene(board);

        stage.setTitle("!! Space invaders !!");
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

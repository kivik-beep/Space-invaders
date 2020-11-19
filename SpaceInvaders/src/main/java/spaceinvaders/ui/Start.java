package spaceinvaders.ui;

import java.util.HashMap;
import java.util.Map;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
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

        Spaceship ship = new Spaceship(WIDTH / 2, HEIGHT - 10);

        Invader enemy = new Invader(WIDTH / 2, 40);

        board.getChildren().add(ship.getCharacter());

        board.getChildren().add(enemy.getCharacter());

        Scene scene = new Scene(board);

        Map<KeyCode, Boolean> buttons = new HashMap<>();
        scene.setOnKeyPressed(event -> {
            buttons.put(event.getCode(), Boolean.TRUE);
        });
        scene.setOnKeyReleased(event -> {
            buttons.put(event.getCode(), Boolean.FALSE);
        });

        new AnimationTimer() {
            @Override
            public void handle(long l) {
                if (buttons.getOrDefault(KeyCode.LEFT, false)) {
                    ship.move(-2);
                }
                if (buttons.getOrDefault(KeyCode.RIGHT, false)) {
                    ship.move(2);
                }
                if (buttons.getOrDefault(KeyCode.SPACE, false)) {
                    Shot ammo = new Shot((int) ship.getCharacter().getTranslateX(), HEIGHT - 60);
                    board.getChildren().add(ammo.getCharacter());
                    ammo.moveUp();
                }

            }

        }.start();

        stage.setTitle(
                "! ! Space invaders ! !");
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

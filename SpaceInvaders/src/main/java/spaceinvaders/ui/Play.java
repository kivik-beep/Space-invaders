package spaceinvaders.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import spaceinvaders.domain.Game;
import spaceinvaders.domain.Invader;
import spaceinvaders.domain.Shot;
import spaceinvaders.domain.Spaceship;

public class Play {

    private int level;
    boolean gameOver;
    Game game;
    ArrayList<Invader> invaders;
    List<Shot> bullets = new ArrayList<>();
    Spaceship player;

    public Play() {

    }

    public void getPlayer() {
        this.player = game.getPlayer();
    }

    public void getInvaders() {
        this.invaders = game.getInvaders();
    }

    Scene getScene() {
        this.level = 1;
        Pane gameBoard = new Pane();
        gameBoard.setPrefSize(500, 500);
        this.game = new Game(level);
        game.start();

        gameBoard.getChildren().add(game.getPlayer().getCharacter());
        game.getInvaders().forEach((Invader invader) -> gameBoard.getChildren().add(invader.getCharacter()));

        Scene scene = new Scene(gameBoard);
        animate(scene, gameBoard);

        return scene;
    }

    public void animate(Scene scene, Pane gameBoard) {

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
                    game.getPlayer().move(-2);
                }
                if (buttons.getOrDefault(KeyCode.RIGHT, false)) {
                    game.getPlayer().move(2);
                }
                if (buttons.getOrDefault(KeyCode.SPACE, false)) {
                    int height = 500;

                    Shot bullet = new Shot((int) game.getPlayer().getCharacter().getTranslateX(), height - 60);
                    gameBoard.getChildren().add(bullet.getCharacter());
                    bullets.add(bullet);
                }

                game.getInvaders().forEach((Invader invader) -> invader.move());
                bullets.forEach(shot -> shot.moveUp());

                if (game.getInvaders().get(game.getInvaders().size() - 1).getY() > 420) {
                    stop();
                }
            }

        }.start();
    }

}

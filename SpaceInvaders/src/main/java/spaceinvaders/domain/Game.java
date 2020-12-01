package spaceinvaders.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import static spaceinvaders.ui.Start.height;

public class Game {

    private final int level;
    boolean gameOver = false;
    private final Pane board;
    private final Spaceship player;
    List<Invader> enemies = new ArrayList<>();
    List<Shot> bullets = new ArrayList<>();


    public Game(int level, Pane board, Spaceship player) {
        this.level = level;
        this.board = board;
        this.player = player;
    }

    public void createInvaders() {

        for (int a = 0; a < level; a++) {
            int y = 40 + a * 50;
            for (int i = 0; i < 5; i++) {
                Invader enemy = new Invader((460 - i * 50), y);
                enemies.add(enemy);
            }
        }
        enemies.forEach(enemy -> board.getChildren().add(enemy.getCharacter()));

    }

    public void start() {
        createInvaders();
    }

    public void animate(Scene scene) {

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
                    player.move(-2);
                }
                if (buttons.getOrDefault(KeyCode.RIGHT, false)) {
                    player.move(2);
                }
                if (buttons.getOrDefault(KeyCode.SPACE, false)) {

                    Shot bullet = new Shot((int) player.getCharacter().getTranslateX(), height - 60);
                    board.getChildren().add(bullet.getCharacter());
                    bullets.add(bullet);
                }
                enemies.forEach(enemy -> enemy.move());
                bullets.forEach(shot -> shot.moveUp());
                
                if (enemies.get(enemies.size() - 1).character.getTranslateY() > 420) {
                    stop();
                }
            }

        }.start();
    }

}

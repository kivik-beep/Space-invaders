package spaceinvaders.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
    List<Shot> shots = new ArrayList<>();
    Spaceship player;

    /**
     * Gets a spaceship for the player from domain.
     */
    public void getPlayer() {
        this.player = game.getPlayer();
    }

    /**
     * Gets the invaders from domain.
     */
    public void getInvaders() {
        this.invaders = game.getInvaders();
    }

    /**
     * Creates scene.
     *
     * @return scene that contains all characters
     */
    Scene getScene() {
        this.level = 3;
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

    /**
     * Animates the game.
     *
     * @param scene scene for the game
     * @param gameBoard Pane for the game
     */
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
                if (buttons.getOrDefault(KeyCode.SPACE, false) && shots.size() < 15) {
                    Shot shot = new Shot((int) game.getPlayer().getCharacter().getTranslateX(), 500 - 60);
                    shots.add(shot);
                    gameBoard.getChildren().add(shot.getCharacter());
                }
                game.getInvaders().forEach((Invader invader) -> invader.move());
                shots.forEach(shot -> shot.moveUp());

                shots.forEach((Shot shot) -> {
                    game.getInvaders().forEach(invader -> {
                        if (shot.collapse(invader)) {
                            shot.setAlive(false);
                            invader.setAlive(false);
                        }
                    });
                });

                shots.stream()
                        .filter(shot -> shot.alive() == false)
                        .forEach(shot -> gameBoard.getChildren().remove(shot.getCharacter()));
                shots.removeAll(shots.stream()
                        .filter(shot -> shot.alive() == false)
                        .collect(Collectors.toList()));

                game.getInvaders().stream()
                        .filter(invader -> invader.alive() == false)
                        .forEach(invader -> gameBoard.getChildren().remove(invader.getCharacter()));

                game.getInvaders().removeAll(game.getInvaders().stream()
                        .filter(invader -> invader.alive() == false)
                        .collect(Collectors.toList()));

                if (game.getInvaders().isEmpty()) {
                    stop();
                } else if (game.getInvaders().get(game.getInvaders().size() - 1).getY() > 420) {
                    game.getPlayer().setAlive(false);
                    stop();
                }

            }
        }
                .start();

    }
}

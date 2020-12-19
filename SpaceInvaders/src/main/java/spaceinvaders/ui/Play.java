package spaceinvaders.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import spaceinvaders.domain.Game;
import spaceinvaders.domain.Invader;
import spaceinvaders.domain.Shot;
import spaceinvaders.domain.Spaceship;

public class Play {

    int level;
    boolean gameOver;
    Game game;
    ArrayList<Invader> invaders;
    List<Shot> shots = new ArrayList<>();
    Spaceship player;
    End end;
    Stage stage;

    Play(End end, Stage stage) {
        this.end = end;
        this.stage = stage;
    }

    /**
     * Gets a spaceship for the player from domain.
     */
    public void getPlayer() {
        this.player = game.getPlayer();
    }

    public Play() {
        this.gameOver = false;
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
    public Scene getScene() {
        this.gameOver = false;
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
                    if (game.getPlayer().alive() == true) {

                        game.setLevel(1);
                        game.createInvaders();
                        game.getInvaders().forEach((Invader invader) -> gameBoard.getChildren().add(invader.getCharacter()));

                    } else {
                        game.endGame(true);
      //                  stage.setScene(end.getScene());
                        stop();
                    }
                } else if (game.getInvaders().get(game.getInvaders().size() - 1).getY() > 420) {
                    game.getPlayer().setAlive(false);
                    game.endGame(true);
   //                 stage.setScene(end.getScene());
                    stop();
                }

            }
        }
                .start();
        if (game.gameOver() == true) {
            this.gameOver = true;
        }

    }

    public boolean gameOver() {
        return this.gameOver;
    }

}

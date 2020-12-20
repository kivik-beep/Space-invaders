package spaceinvaders.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import spaceinvaders.domain.Game;
import spaceinvaders.domain.Invader;
import spaceinvaders.domain.Shot;

public class Play {

    int level;
    Game game;
    List<Shot> shots = new ArrayList<>();
    Stage stage;
    String name;

    Play(Stage stage) {
        this.stage = stage;
    }

    /**
     * Creates scene.
     *
     * @param level
     * @return scene that contains all characters
     */
    public Scene getScene(int level) {
        this.level = level;
        this.game = new Game(level);

        Pane gameBoard = new Pane();
        gameBoard.setPrefSize(500, 500);

        game.start();
        gameBoard.getChildren().add(game.getPlayer().getCharacter());
        game.getInvaders().forEach((Invader invader) -> gameBoard.getChildren().add(invader.getCharacter()));

        End end = new End(stage);
        Scene scene = new Scene(gameBoard);
        animate(scene, gameBoard, end);

        return scene;
    }

    /**
     * Animates the game.
     *
     * @param scene scene for the game
     * @param gameBoard Pane for the game
     * @param end end to move to the next scene
     */
    public void animate(Scene scene, Pane gameBoard, End end) {

        Map<KeyCode, Boolean> buttons = new HashMap<>();

        scene.setOnKeyPressed(event -> {
            buttons.put(event.getCode(), Boolean.TRUE);
        });

        scene.setOnKeyReleased(event -> {
            buttons.put(event.getCode(), Boolean.FALSE);
        });

        new AnimationTimer() {
            /**
             * Handles animations for the game.
             *
             * @param l how keyboard is read
             */
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
                if (buttons.getOrDefault(KeyCode.Q, false)) {
                    endGame(end);
                    stop();
                }
                game.getInvaders().forEach((Invader invader) -> invader.move());
                shots.forEach(shot -> shot.moveUp());

                removeDead(shots, game, gameBoard);
                
                if (game.getInvaders().isEmpty()) {
                    if (game.getPlayer().alive() == true) {
                        if (game.getLevel() < 8) {
                            game.setLevel(1);
                        }
                        game.createInvaders();
                        game.getInvaders().forEach((Invader invader) -> gameBoard.getChildren().add(invader.getCharacter()));
                    } else {
                        stop();
                    }
                } else if (game.getInvaders().get(game.getInvaders().size() - 1).getY() > 420) {
                    game.getPlayer().setAlive(false);
                    endGame(end);
                    stop();
                }

            }
        }
                .start();

    }

    /**
     * This method shows the next scene, End-scene.
     *
     * @param end defined in getScene()
     */
    public void endGame(End end) {
        end.player(name, game.points());
        Scene endS = end.getScene();
        stage.setScene(endS);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void removeDead(List<Shot> shots, Game game, Pane gameBoard) {
        shots.forEach((Shot shot) -> {
            game.getInvaders().forEach(invader -> {
                if (shot.collapse(invader)) {
                    shot.setAlive(false);
                    invader.setAlive(false);
                    game.destroyEnemy();
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
    }

}

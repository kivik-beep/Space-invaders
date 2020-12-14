package spaceinvaders.ui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Start {

   // Scene playScene;
    Play play;
    Stage stage;

    /**
     * Creates starting scene.
     *
     * @param play class Play that contains the game
     * @param stage stage needed for the scene
     */
    public Start( Play play, Stage stage) {
       // this.playScene = playScene;
        this.play = play;
        this.stage = stage;
    }

    /**
     * Creates scene to staring stage, contains instructions to play and a
     * button to start.
     *
     * @return startScene
     */
    public Scene getScene() {

        Button startGame = new Button("Start");
        GridPane board = new GridPane();
        board.add(startGame, 0, 2);
        board.setAlignment(Pos.CENTER);

        Scene scene = new Scene(board, 500, 500);

        startGame.setOnAction((event) -> {
            Scene playScene = play.getScene();
            stage.setScene(playScene);
        });

        return scene;
    }
}

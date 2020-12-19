/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.ui;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import spaceinvaders.dao.Records;

/**
 * Scene for high scores.
 *
 * @author kxkivi
 */
public class End {

    private final Records list;
    private final Stage stage;

    End(Stage stage) {
        this.stage = stage;
        this.list = new Records();
    }

    /**
     * This method creates scene for this class.
     *
     * @return scene
     */
    public Scene getScene() {

        //list.addScore("winnie", 150);
        ArrayList scores = list.getHighScores();

        VBox score = new VBox();
        score.setSpacing(20);
        score.getChildren().addAll(topTenLabel(), scoreList(scores));

        BorderPane board = new BorderPane();
        Button newGame = newGame();
        board.setRight(newGame);
        board.setCenter(score);

        board.setPrefSize(500, 500);
        board.setPadding(new Insets(40, 40, 40, 40));

        Scene scene = new Scene(board);

        newGame.setOnAction((ActionEvent event) -> {

            End end = new End(stage);
            Play play = new Play(stage);
            Start start = new Start(play, stage);
            stage.setScene(start.getScene());
        });

        return scene;

    }

    /**
     * Creates and styles button for new game.
     *
     * @return button to start new game
     */
    public Button newGame() {
        Button newGame = new Button("new game");
        newGame.setMaxSize(100, 50);
        newGame.setStyle("-fx-border-color: #DAA520; -fx-border-width: 3px; -fx-background-color: #FFD700; ");

        return newGame;
    }

    /**
     * Creates and styles label for the top10 list.
     *
     * @return heading for top10
     */
    public Label topTenLabel() {
        Label label = new Label("Top10:");
        label.setFont(new Font(28));
        return label;
    }

    /**
     * Creates top10.
     *
     * @param scores list containing all the players
     * @return VBox with top10 players
     */
    public VBox scoreList(ArrayList scores) {
        VBox scoreList = new VBox();
        for (int i = 0; i < scores.size(); i++) {
            scoreList.getChildren().add(new Label(i + 1 + ".  " + scores.get(i).toString()));
        }
        return scoreList;
    }
}

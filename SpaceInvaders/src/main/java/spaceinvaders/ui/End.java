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

    private Records list;
    private final Stage stage;

    End(Stage stage) {
        this.stage = stage;

    }

    public Scene getScene() {

        Button newGame = new Button("new game");
        newGame.setMaxSize(100, 50);
        newGame.setStyle("-fx-border-color: #DAA520; -fx-border-width: 3px; -fx-background-color: #FFD700; ");

        Label highScores = new Label("Top10:");
        highScores.setFont(new Font(28));
        VBox scoreList = new VBox();

        this.list = new Records();
        //list.addScore("minnie", 50);

        ArrayList scores = list.getHighScores();

        for (int i = 0; i < scores.size(); i++) {
            scoreList.getChildren().add(new Label(i + 1 + ".  " + scores.get(i).toString()));
        }

        BorderPane board = new BorderPane();

        VBox score = new VBox();
        score.setSpacing(20);
        score.getChildren().addAll(highScores, scoreList);

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

}

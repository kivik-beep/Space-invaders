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
import spaceinvaders.dao.Player;
import spaceinvaders.dao.Records;

/**
 * Scene for high scores.
 *
 * @author kxkivi
 */
public class End {

    private final Records list;
    private final Stage stage;
    private Player player;

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

        list.addScore(this.player);
        ArrayList scores = list.getHighScores();

        VBox score = new VBox();
        score.setSpacing(20);
        score.getChildren().addAll(topTenLabel(), scoreList(scores), playerInfo(scores));

        BorderPane board = new BorderPane();
        Button newGame = createButton("play again");
        Button startscene = createButton("to start");
        buttonsOnAction(startscene, newGame);

        VBox buttons = new VBox();
        buttons.getChildren().addAll(startscene, newGame);
        buttons.setMaxSize(100, 400);
        board.setRight(buttons);
        board.setCenter(score);

        board.setPrefSize(500, 500);
        board.setPadding(new Insets(40, 40, 40, 40));

        Scene scene = new Scene(board);

        return scene;

    }

    /**
     * Creates and styles button for new game.
     *
     * @param text typed on the button
     * @return button to start new game
     */
    public Button createButton(String text) {
        Button create = new Button(text);
        create.setMaxSize(100, 50);
        create.setStyle("-fx-border-color: #DAA520; -fx-border-width: 3px; -fx-background-color: #FFD700; ");

        return create;
    }

    /**
     * Sets action for each button.
     * 
     * @param startscene creates new start scene and puts it on
     * @param newGame starts new game with same name from level 3
     */
    public void buttonsOnAction(Button startscene, Button newGame) {
        startscene.setOnAction((ActionEvent event) -> {

            End end = new End(stage);
            Play play = new Play(stage);
            Start start = new Start(play, stage);
            stage.setScene(start.getScene());
        });

        newGame.setOnAction((ActionEvent event) -> {

            End end = new End(stage);
            Play play = new Play(stage);
            play.setName(player.getName());

            Scene playScene = play.getScene(3);
            stage.setScene(playScene);

        });
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

    void player(String name, int points) {
        this.player = new Player(name, points);

    }

    /**
     * This method creates VBox containing all data from the game.
     * 
     * @param scores needed to compare players result to top10 list
     * @return all the information in a VBox
     */
    public VBox playerInfo(ArrayList scores) {

        VBox info = new VBox();
        Label label = new Label();
        label.setText("You got " + this.player.getScore() + " points.");
        label.setFont(new Font(20));
        Label place = new Label();

        int counter = 0;
        while (counter < 10) {
            if (this.player.toString().equals(scores.get(counter).toString())) {
                place.setText("you get place No." + (counter + 1) + "!");
                break;
            } else {
                place.setText("you did not make it to top10 :(");
            }
            counter++;
        }
        Label invadercount = new Label("Destroed invaders: " + (player.getScore() / 10) + " invaders");

        info.getChildren().addAll(label, place, invadercount);

        return info;
    }
}

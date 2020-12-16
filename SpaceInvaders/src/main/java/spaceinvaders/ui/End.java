/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.ui;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Scene for high scores.
 *
 * @author kxkivi
 */
public class End {

    Scene getScene() {
       
        Button newGame = new Button("new game");
        newGame.setMaxSize(100, 50);
        newGame.setStyle("-fx-border-color: #DAA520; -fx-border-width: 3px; -fx-background-color: #FFD700; ");
        
        Label highScores = new Label("See your score:");
        Label first = new Label("1.:");
        Label second = new Label("2. :");
        Label third = new Label("3. : ");

        BorderPane board = new BorderPane();

        VBox score = new VBox();
        score.setSpacing(20);
        score.getChildren().addAll(highScores, first, second, third);

        board.setRight(newGame);
        board.setCenter(score);

        board.setPrefSize(500, 500);
        board.setPadding(new Insets(40, 40, 40, 40));

        Scene scene = new Scene(board);
        
        newGame.setOnAction((ActionEvent event) -> {
            Spaceinvaders again = new Spaceinvaders();
            Stage stage = new Stage();
            try {
                again.start(stage);
            } catch (Exception ex) {
                Logger.getLogger(End.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        return scene;

    }
    // get result from Game
    // player can set name
    // player can get to start-scene

    // High score list shown - adds player 

}

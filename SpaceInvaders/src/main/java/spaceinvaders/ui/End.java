/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Scene for high scores. 
 * 
 * @author kxkivi
 */
public class End extends Application {

    Scene getScene() {
        
        TextField name = new TextField("yourName");
        Button startNew = new Button("new game");
        Label highScores = new Label("See your score:");
        Label first = new Label("1.:");
        Label second = new Label("2. :");
        Label third = new Label ("3. : ");
        
        BorderPane board = new BorderPane();
        
        VBox score = new VBox();
        score.setSpacing(20);
        score.getChildren().addAll(highScores, first, second, third);
       
        board.setTop(startNew);
        board.setCenter(score);
        board.setBottom(name);
        
        board.setPrefSize(500, 500);
        board.setPadding(new Insets(40, 40, 40, 40));
                
        
        Scene scene = new Scene(board);

        return scene;
    
    }
    // get result from Game
    // player can set name
    // player can get to start-scene
    
    // High score list shown - adds player 

    @Override
    public void start(Stage stage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

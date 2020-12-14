/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.ui;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * Scene for high scores. 
 * 
 * @author kxkivi
 */
public class End {

    Scene getScene() {
        BorderPane board = new BorderPane();
        Scene scene = new Scene(board, 500, 500);

        return scene;
    
    }
    // get result from Game
    // player can set name
    // player can get to start-scene
    
    // High score list shown - adds player 
}

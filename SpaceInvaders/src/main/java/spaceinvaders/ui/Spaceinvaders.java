package spaceinvaders.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Space Invaders Game.
 * 
 * @version 3 - FINAL
 * @author kxkivi
 */
public class Spaceinvaders extends Application {
//initial setup

    private Play play;
    private Start start;
    private End end;

    /**
     * Starts the user interface.
     * 
     * @param args 
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("! ! Space invaders ! !");
        this.play = new Play(end, stage);
        
        this.start = new Start(play, stage);
        Scene startScene = start.getScene();
        
        this.end = new End(start, stage);
        Scene endScene = end.getScene();
        //stage.setScene(endScene);
        stage.setScene(startScene);
        stage.show();
    }


}

package spaceinvaders.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
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
    public Start(Play play, Stage stage) {
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

        VBox guide = getGuide();
        
        TextField nameField = new TextField("yourName");
        nameField.setMaxSize(100, 50);
        nameField.setStyle("-fx-background-color: #40E0D0; ");
        
        
        Button startGame = new Button("START");
        startGame.setMaxSize(100, 50);
        startGame.setStyle("-fx-border-color: #DAA520; -fx-border-width: 3px; -fx-background-color: #FFD700; ");
        
        GridPane board = new GridPane();
        board.add(nameField, 0, 1);
        board.add(guide, 0, 0);
        board.add(startGame, 0, 2);
        board.setAlignment(Pos.CENTER);
        board.setVgap(20);

        Scene scene = new Scene(board, 500, 500);

        startGame.setOnAction((event) -> {
            Scene playScene = play.getScene();
            stage.setScene(playScene);
        });

        return scene;
    }
    
    public VBox getGuide() {
        VBox guide = new VBox();
        guide.getChildren().add(new Label("Use arrows [<] and [>] to move your ship"));
        guide.getChildren().add(new Label(" & hit SPACE to shoot!"));
        guide.getChildren().add(new Label(" "));
        guide.getChildren().add(new Label("Set your name and press START when you're ready."));
        guide.setSpacing(20);
        guide.setPadding(new Insets(40, 40, 40, 40));
        
        return guide;
    }
}

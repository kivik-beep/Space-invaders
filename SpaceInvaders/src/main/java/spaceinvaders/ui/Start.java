package spaceinvaders.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Start {

    // Scene playScene;
    Play play;
    Stage stage;
    TextField nameField;
    ChoiceBox<Integer> box;

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

        Button startGame = new Button("START");
        startGame.setStyle("-fx-border-color: #DAA520; -fx-border-width: 3px; -fx-background-color: #FFD700; ");

        GridPane board = new GridPane();
        board.add(nameAndLevel(), 0, 1);
        board.add(getGuide(), 0, 0);
        board.add(startGame, 0, 2);

        board.setAlignment(Pos.TOP_CENTER);
        board.setPadding(new Insets(40, 40, 40, 40));

        Scene scene = new Scene(board, 500, 500);

        startGame.setOnAction((event) -> {
            play.setName(nameField.getText());
            if (box.getValue() == null) {
                stage.setScene(play.getScene(3));
            } else {
                stage.setScene(play.getScene(box.getValue()));
            }

        });

        return scene;
    }

    /**
     * Creates guide that contains all the important instructions.
     *
     * @return VBox containing instructions
     */
    public VBox getGuide() {
        VBox guide = new VBox();
        Label label = new Label("How to play:");
        label.setFont(new Font(25));
        guide.getChildren().add(label);
        guide.getChildren().add(new Label("Use arrows [<] and [>] to move your ship"));
        guide.getChildren().add(new Label(" & hit SPACE to shoot!"));
        guide.getChildren().add(new Label(" "));
        guide.getChildren().add(new Label("Quit at any time by pressing 'q'"));
        guide.getChildren().add(new Label("Set your name and press START when you're ready."));
        guide.setSpacing(20);
        guide.setPadding(new Insets(20, 20, 20, 20));
        guide.setMaxSize(500, 100);
        guide.setStyle("-fx-border-color: #F0E68C; -fx-border-width: 3px; -fx-background-color: #FFFFE0 ;");

        return guide;
    }

    /**
     * This method creates text field for name and drop box for level.
     * @return name and level in HBox
     */
    public HBox nameAndLevel() {
        HBox data = new HBox();
        nameField = new TextField("yourName");
        nameField.setMaxSize(200, 40);
        nameField.setStyle("-fx-border-color: #DAA520; -fx-border-width: 3px; -fx-background-color: #F0E68C;");

        box = new ChoiceBox<>();
        for (int i = 1; i < 6; i++) {
            box.getItems().add(i);
        }

        box.setStyle("-fx-border-color: #DAA520; -fx-border-width: 3px; -fx-background-color: #F0E68C; ");
        TilePane tilePane = new TilePane();
        tilePane.getChildren().add(new Label("start level:"));
        tilePane.getChildren().add(box);

        data.getChildren().addAll(nameField, tilePane);
        data.setSpacing(20);
        data.setPadding(new Insets(40, 40, 40, 40));
        return data;
    }
}

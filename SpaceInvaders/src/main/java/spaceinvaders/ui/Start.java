package spaceinvaders.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import spaceinvaders.domain.Game;
import spaceinvaders.domain.Spaceship;

public class Start extends Application {

    public static int width = 500;
    public static int height = 500;
    private final Pane board = new Pane();
    private final Spaceship player = new Spaceship(width / 2, height - 10);
    public int level = 3;
    public Game game = new Game(level, board, player);

    public void create() {
        board.setPrefSize(width, height);
        board.getChildren().add(player.getCharacter());
        
    }

    @Override
    public void start(Stage stage) throws Exception {
        create();
        Scene scene = new Scene(board);
        
        game.start();        

        game.animate(scene);

        stage.setTitle(
                "! ! Space invaders ! !");
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

  /*  public void animate(Scene scene) {

        Map<KeyCode, Boolean> buttons = new HashMap<>();
        scene.setOnKeyPressed(event -> {
            buttons.put(event.getCode(), Boolean.TRUE);
        });
        scene.setOnKeyReleased(event -> {
            buttons.put(event.getCode(), Boolean.FALSE);
        });
        new AnimationTimer() {
            @Override
            public void handle(long l) {
                if (buttons.getOrDefault(KeyCode.LEFT, false)) {
                    player.move(-2);
                }
                if (buttons.getOrDefault(KeyCode.RIGHT, false)) {
                    player.move(2);
                }
                if (buttons.getOrDefault(KeyCode.SPACE, false)) {

                    Shot bullet = new Shot((int) player.getCharacter().getTranslateX(), height - 60);
                    board.getChildren().add(bullet.getCharacter());
                    bullet.moveUp();
                }
            }
        }.start();
    }*/
}

package spaceinvaders.domain;

import javafx.scene.layout.Pane;

public class Board {

    public static int width;
    public static int height;
    private final Pane board = new Pane();

    public void Board() {
        Board.width = 500;
        Board.height = 500;
    }

    public Pane getBoard() {
        board.setPrefSize(width, height);
        return this.board;
    }
}

package spaceinvaders;

import javafx.scene.shape.Polygon;

public class Shot extends Character {

    public Shot(int x, int y) {
    super(new Polygon(-5, -5, -5, 5, 5, 5, 5,-5), x, y);

    }
}
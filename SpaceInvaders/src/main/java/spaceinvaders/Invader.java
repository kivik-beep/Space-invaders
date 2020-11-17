package spaceinvaders;

import javafx.scene.shape.Polygon;


public class Invader extends Character {

    public Invader(int x, int y) {
    super(new Polygon(-20, -20, -20, 20, 20, 20, 20,-20), x, y);
    }
}

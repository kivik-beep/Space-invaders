
package spaceinvaders.domain;

import javafx.scene.shape.Polygon;

public class Spaceship extends Character {
    

    public Spaceship(int x, int y) {
        super(new Polygon(-20, 0, 20, 0, 0, -45), x, y);
    }
}

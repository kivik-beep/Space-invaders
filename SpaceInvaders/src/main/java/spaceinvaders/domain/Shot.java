package spaceinvaders.domain;

import javafx.scene.shape.Polygon;

public class Shot extends Character {
     /**
     * Creates polygon to create new ammo-character.
     * @param x the x coordinates for ammo
     * @param y the y coordinates for ammo
     */  
    public Shot(int x, int y) {
        super(new Polygon(-3, -3, -3, 3, 3, 3, 3, -3), x, y);
    }
}

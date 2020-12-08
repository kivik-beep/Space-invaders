package spaceinvaders.domain;

import javafx.scene.shape.Polygon;

public class Spaceship extends Character {

    //private List<Shot> shots = new ArrayList<>();
    /**
     * Creates polygon to create new player-character.
     * @param x the x coordinates for player
     * @param y the y coordinates for player
     */
    public Spaceship(int x, int y) {
        super(new Polygon(-20, 0, 20, 0, 0, -45), x, y);

        //    createShots();
    }

    /* private void createShots() {
        for (int i = 0; i < 20; i++) {
            Shot shot = new Shot(250, 250);
            shots.add(shot);
        }
    }*/
}

package spaceinvaders.domain;

import javafx.scene.shape.Polygon;

public class Invader extends Character {

    private int way = -2;
    private int range = 0;

    /**
     * Creates polygon to create new invader-character.
     *
     * @param x the x coordinates for invader
     * @param y the y coordinates for invader
     */
    public Invader(int x, int y) {
        super(new Polygon(-20, -20, -20, 20, 20, 20, 20, -20), x, y);
    }

    /**
     * method to make invader move in right way.
     */
    public void move() {
        this.move(way);
        this.range++;

        if (this.range > 110) {
            this.way = this.way * -1;
            this.range = 0;

            moveDown(25);
        }
    }

    /**
     * invaders y coordinate is needed to end the game when invaders get to earth.
     * @return y
     */
    public double getY() {
        return this.character.getTranslateY();
    }

}

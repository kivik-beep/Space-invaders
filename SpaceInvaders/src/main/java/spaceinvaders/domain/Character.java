package spaceinvaders.domain;

import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public abstract class Character {

    Polygon character;
    private Point2D movement;
    private boolean alive;

    /**
     * Creates new character.
     *
     * @param shape characters shape
     * @param x characters location on the x-axis
     * @param y characters location on the y-axis
     */
    public Character(Polygon shape, int x, int y) {
        this.character = shape;
        this.character.setTranslateX(x);
        this.character.setTranslateY(y);
        this.movement = new Point2D(0, 2);
        this.alive = true;
    }

    public Polygon getCharacter() {
        return character;
    }

    /**
     * Moves characters on the x-axis.
     *
     * @param way <0 goes left, >0 goes right
     */
    public void move(int way) {
        //way<0 = left
        //way>0 = right
        this.character.setTranslateX(this.character.getTranslateX() + way);

        if (this.character.getTranslateX() > 480) {
            this.character.setTranslateX(480);
        }

        if (this.character.getTranslateX() < 20) {
            this.character.setTranslateX(20);
        }
    }

    /**
     * Moves the character up in the y-axis, used by players ammo.
     */
    public void moveUp() {
        this.character.setTranslateY(this.character.getTranslateY() - 2);
    }

    /**
     * Moves the character down in the y-axis, used by invaders.
     *
     * @param y how much movement needed
     */
    public void moveDown(int y) {
        this.character.setTranslateY(this.character.getTranslateY() + y);
        if (this.character.getTranslateY() > 500) {
            this.character.setTranslateY(500);
        }
    }

    /**
     * Returns is the character alive or not.
     *
     * @return how alive this character is
     */
    public boolean alive() {
        if (this.character.getTranslateY() < 0) {
            this.alive = false;
        }
        return this.alive;
    }
    
    public boolean collapse(Character another){
        Shape collapseArea = Shape.intersect(character, another.getCharacter());
        return collapseArea.getBoundsInLocal().getWidth() != -1;
    }
    
    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}

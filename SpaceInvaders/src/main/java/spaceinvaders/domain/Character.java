package spaceinvaders.domain;

import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;

public abstract class Character {

    Polygon character;
    Point2D movement;
    boolean alive;

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

    public void moveUp() {
        this.character.setTranslateY(this.character.getTranslateY() - 2);
    }

    public void moveDown(int y) {
        //invader (&invader ammo?)
        this.character.setTranslateY(this.character.getTranslateY() + y);
        if (this.character.getTranslateY() > 500) {
            this.character.setTranslateY(500);
        }
    }
    
 

    public boolean alive() {
        if (this.character.getTranslateY() < 0) {
            this.alive = false;
        }
        return this.alive;
    }
    

}

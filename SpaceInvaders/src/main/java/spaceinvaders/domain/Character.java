package spaceinvaders.domain;

import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;

public abstract class Character {

    private Polygon character;
    private Point2D movement;
    private boolean alive;

    public Character(Polygon shape, int x, int y) {
        this.character = shape;
        this.character.setTranslateX(x);
        this.character.setTranslateY(y);
        this.movement = new Point2D(0, 0);
        this.alive = true;
    }

    public Polygon getCharacter() {
        return character;
    }

    public void move(int way) {
        //way<0 = left
        //way>0 = right
        this.character.setTranslateX(this.character.getTranslateX() + way);    
    }

    public void moveUp() {
        this.character.setTranslateY(this.character.getTranslateY() - 5); 
    }

    public void moveDown() {
        //invader (&invader ammo?)
        this.character.setTranslateY(this.character.getTranslateY() + 2);
    }
    
 

    public boolean alive() {
        return this.alive;
    }

}


package spaceinvaders;

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
    
    public void moveLeft() {
        //player &invader
        
        this.character.setTranslateX(this.character.getTranslateX()-1);
    }
    public void moveRight() {
        //player &invader
        
        this.character.setTranslateX(this.character.getTranslateX()+1);
    }
    
    public void moveUp() {
        // ammo
    }
    
    public void moveDown(){
        //invader (&invader ammo?)
    }
    
    public boolean alive() {
        return this.alive;
    }

}

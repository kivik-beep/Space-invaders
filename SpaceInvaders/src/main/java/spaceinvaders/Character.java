/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;


public abstract class Character {
    private Polygon character;
    private Point2D movement;
    
    public Character(Polygon shape, int x, int y) {
        this.character = shape;
        this.character.setTranslateX(x);
        this.character.setTranslateY(y);
        this.movement=new Point2D(0,0);
    }
    
    public Polygon getCharacter() {
        return character;
    }
    
}

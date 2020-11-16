/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

import java.awt.Polygon;
import java.awt.geom.Point2D;

/**
 *
 * @author kxkivi
 */
public abstract class Character {
    private final Polygon character;
    private Point2D movement;
    
    public Character(Polygon shape, int x, int y) {
        this.character = shape;

    }
    
}

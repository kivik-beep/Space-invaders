/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.scene.shape.Polygon;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import spaceinvaders.Invader;
import spaceinvaders.Shot;
import spaceinvaders.Spaceship;

public class CharacterTest {
    Spaceship spaceship;
    Shot shot;
    Invader invader;
    private static final double DELTA = 1e-15;
    
    @Before
    public void setUp() {
        spaceship = new Spaceship(0, 0);
        shot = new Shot(0, 0);
        invader = new Invader(0, 0);
    }
    
    @After
    public void tearDown() {
    }

     @Test
     public void hello() {}
     
     @Test
     public void getCharacterWorks(){

         Polygon ship = new Polygon(-20, 0, 20, 0, 0, -45);
         Polygon testShip = spaceship.getCharacter();
     }
     
     
     @Test
     public void moveWorksToLeft() {
         spaceship.move(-2);
         spaceship.move(-2);
         assertEquals(-4, spaceship.getCharacter().getTranslateX(), DELTA);
     }
     
     @Test
     public void moveWorkstoRight() {
         spaceship.move(2);
         spaceship.move(2);
         assertEquals(4, spaceship.getCharacter().getTranslateX(), DELTA);
         
     }

     

}

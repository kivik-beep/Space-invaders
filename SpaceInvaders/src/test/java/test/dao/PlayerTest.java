/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.dao;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import spaceinvaders.dao.Player;

/**
 *
 * @author kxkivi
 */
public class PlayerTest {

    private Player player;
    private Player other;

    @Before
    public void setUp() {
        this.player = new Player("testman", 100);
        this.other = new Player("otherPlayer", 200);
    }

    
    @Test
    public void stringToSaveWorks() {
        String string = player.toSave();
        
        assertEquals("testman,100", string);
    }

    @Test
    public void compareToWorks() {
        assertEquals(1, player.compareTo(other));
        assertEquals(-1, other.compareTo(player));
    }

    @Test
    public void toStringWorks() {
        String string = player.toString();

        assertEquals("100 p.   testman", string);
    }

    @Test
    public void getScoreWorks() {
        int score = player.getScore();
        assertEquals(100, score);
        score = other.getScore();
        assertEquals(200, score);
    }
}

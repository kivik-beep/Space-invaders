package spaceinvaders.domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
import javafx.scene.layout.Pane;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author kxkivi
 */
public class GameTest {

    private Game game;
    private int level;
    boolean gameOver = false;
    private Pane board;
    Spaceship player;
    List<Invader> enemies = new ArrayList<>();
    private static final double DELTA = 1e-15;

    @Before
    public void setUp() {
        this.level = 1;
        this.board = new Pane();
        this.player = new Spaceship(250, 250);
        this.game = new Game(this.level);
        this.enemies = game.getInvaders();
    }

    @Test
    public void startWorks() {
        game.start();
        this.player = game.getPlayer();

        assertEquals(5, enemies.size());
        assertEquals(490, player.getCharacter().getTranslateY(), DELTA);
    }

    @Test
    public void getPlayerWorks() {
        this.player = game.getPlayer();
        assertEquals(player, game.getPlayer());
    }

    @Test
    public void getInvadersWorks() {
        game.createInvaders();
        assertEquals(enemies, game.getInvaders());
    }


    @Test
    public void createInvadersWorks() {
        game.createInvaders();
        assertEquals(level * 5, enemies.size());
    }
    
    @Test
    public void setLevelWorks() {
        this.game.setLevel(5);
        Game other = new Game(6);
        assertEquals(game.getInvaders().size(), other.getInvaders().size());
    }
    
    @Test
    public void getLevelWorks(){
        game.setLevel(10);
        assertEquals(11, game.getLevel());
    }
    
    @Test
    public void pointsWorks(){
        game.createInvaders();
        game.createInvaders();
        game.createInvaders();
        game.getInvaders().removeAll(enemies);

        assertEquals(game.getLevel()*5*3*10, game.points());
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
import javafx.scene.layout.Pane;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import spaceinvaders.domain.Game;
import spaceinvaders.domain.Invader;
import spaceinvaders.domain.Spaceship;

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
    public void getInvaderWorks() {
        game.createInvaders();
        assertEquals(enemies.get(1), game.invader(1));
    }

    @Test
    public void createInvadersWorks() {
        game.createInvaders();
        assertEquals(level * 5, enemies.size());
    }

    @Test
    public void returnGameStatusWorks() {
        assertFalse(game.gameOver());
    }

    @Test
    public void changeGameStatusWorks() {
        game.endGame(true);
        assertTrue(game.gameOver());
    }

    @Test
    public void returnLevelWorks() {
        assertEquals(level, game.getLevel());
    }

}

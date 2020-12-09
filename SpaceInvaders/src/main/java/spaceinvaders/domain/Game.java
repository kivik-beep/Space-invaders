package spaceinvaders.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {

    int level;
    boolean gameOver = false;
    Spaceship player;
    List<Invader> enemies = new ArrayList<>();

    /**
     * Creates new game.
     *
     * @param level defines how many invaders is needed.
     */
    public Game(int level) {
        this.level = level;
    }

    /**
     * Creates set of invaders based on the current level.
     */
    public void createInvaders(int level) {
        for (int a = 0; a < level; a++) {
            int y = 40 + a * 50;
            for (int i = 0; i < 5; i++) {
                Invader enemy = new Invader((460 - i * 50), y);
                enemies.add(enemy);
            }
        }
    }

    /**
     * Creates new invaders and spaceship for the game.
     */
    public void start() {
        createInvaders(this.level);
        this.player = new Spaceship(250, 490);
    }

    public Spaceship getPlayer() {
        return this.player;
    }

    public ArrayList<Invader> getInvaders() {
        return (ArrayList<Invader>) this.enemies;
    }

    /**
     * Returns invader from the invader list.
     *
     * @param i number of the invader
     * @return the invader i
     */
    public Invader invader(int i) {
        return this.enemies.get(i);
    }

    public int getLevel() {
        return this.level;
    }

    /**
     * Sets new value to gameOver.
     *
     * @param t value for is game over
     */
    public void endGame(boolean t) {
        this.gameOver = t;
    }

    /**
     * Tells has the player died or not.
     *
     * @return is the game over
     */
    public boolean gameOver() {
        return this.gameOver;
    }

}

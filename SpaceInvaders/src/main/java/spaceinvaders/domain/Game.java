package spaceinvaders.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {

    int level;
    Spaceship player;
    List<Invader> enemies = new ArrayList<>();

    /**
     * Creates new game.
     *
     * @param level defines how many rows of invaders is needed.
     */
    public Game(int level) {
        this.level = level;
    }

    /**
     * Creates set of invaders based on the current level.
     */
    public void createInvaders() {
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
        createInvaders();
        this.player = new Spaceship(250, 490);
    }

    public Spaceship getPlayer() {
        return this.player;
    }

    public ArrayList<Invader> getInvaders() {
        return (ArrayList<Invader>) this.enemies;
    }

    public void setLevel(int t) {
        this.level = this.level + t;
    }

}

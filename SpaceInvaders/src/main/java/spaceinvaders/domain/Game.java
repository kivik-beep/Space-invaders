package spaceinvaders.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {

    int level;
    boolean gameOver = false;
    Spaceship player;
    List<Invader> enemies = new ArrayList<>();

    public Game(int level) {
        this.level = level;
    }

    public void createInvaders() {

        for (int a = 0; a < level; a++) {
            int y = 40 + a * 50;
            for (int i = 0; i < 5; i++) {
                Invader enemy = new Invader((460 - i * 50), y);
                enemies.add(enemy);
            }
        }
    }

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

    public Invader invader(int i) {
        return this.enemies.get(i);
    }
    
    public int getLevel() {
        return this.level;
    }
    
    public void endGame(boolean t) {
        this.gameOver = t;
    }
    
    public boolean gameOver() {
        return this.gameOver;
    }

}

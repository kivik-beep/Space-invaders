/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.dao;

/**
 *
 * @author kxkivi
 */
public class Player implements Comparable<Player> {

    private int score;
    private String name;

    public Player(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public String toSave() {
        return name + "," + score;
    }

    public Integer getScore() {
        return this.score;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return score + " p.   " + name;
    }

    @Override
    public int compareTo(Player t) {
        if (this.score == t.getScore()) {
            return 0;
        } else if (this.score > t.getScore()) {
            return -1;
        } else {
            return 1;
        }
    }
}

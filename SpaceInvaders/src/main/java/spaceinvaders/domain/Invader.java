package spaceinvaders.domain;

import javafx.scene.shape.Polygon;

public class Invader extends Character {

    private int way = -2;
    private int range = 0;

    public Invader(int x, int y) {
        super(new Polygon(-20, -20, -20, 20, 20, 20, 20, -20), x, y);
    }

    public void move() {
        this.move(way);
        this.range++;

        if (this.range > 110) {
            this.way = this.way * -1;
            this.range = 0;
            
            moveDown(25);
        }
    }
    
    public double getY() {
        return this.character.getTranslateY();
    }

}

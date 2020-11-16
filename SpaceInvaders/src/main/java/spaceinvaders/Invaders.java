package spaceinvaders;

import java.awt.Polygon;

public class Invaders extends Character {

    public Invaders(int x, int y) {
        super(new Polygon(), x, y);
        /*vihollisten checklist:
    - ovat olemassa
    - 3x 10 vihollista lähtee liikkeelle vas.yläkulmasta
    - osaavat liikkua
    - osaavat liikkua sivulle
    - kun pääsevät reunaan, laskeutuu rivin alaspäin + vaihtaa suuntaa
    - eivät poistu kentältä
    - kun viholliseen osuu ammus se katoaa
         */
    }
}

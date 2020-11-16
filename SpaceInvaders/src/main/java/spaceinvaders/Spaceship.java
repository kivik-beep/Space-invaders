
package spaceinvaders;
import java.awt.Polygon;

public class Spaceship extends Character {

    public Spaceship(int x, int y) {
        super(new Polygon(), x, y);

        /* pelaajan checklist:
    - alus on olemassa
    - lähtee liikkeelle keskeltä
    - liikkuu vasemmalle
    - liikkuu oikealle
    - ei voi poistua kentältä
    - osaa ampua
         */
    }
}

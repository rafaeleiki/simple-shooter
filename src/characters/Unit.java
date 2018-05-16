package characters;

import java.awt.*;

public interface Unit {

    Rectangle getArea();
    boolean hasCollided(Unit u);

}

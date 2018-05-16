package control;

import characters.GameCharacter;
import characters.Unit;

public class GameControl {

    private static final int SPEED_PIXELS_PER_SECOND = 50;
    private static final int ONE_SECOND = 1000;

    private Unit[] units;
    private GameCharacter player;
    private int dx;
    private int dy;

    public GameControl(Unit[] units, GameCharacter player) {
        this.units = units;
        this.player = player;
        dx = 0;
        dy = 0;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public void move(long timeGap) {
        float speed = ((float) SPEED_PIXELS_PER_SECOND * timeGap / ONE_SECOND);
        float distanceX = speed * dx;
        float distanceY = speed * dy;
        player.walk(distanceX, distanceY);
    }

    public Unit[] getUnits() {
        return units;
    }
}

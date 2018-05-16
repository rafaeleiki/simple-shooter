import characters.GameCharacter;
import characters.Unit;
import control.GameControl;
import control.ImageBank;
import visual.GameFrame;

public class Main {

    public static void main(String[] args) {
        Unit[] units = new Unit[1];
        addUnits(units);
        GameControl game = new GameControl(units, (GameCharacter) units[0]);
        new GameFrame(game);
    }

    private static void addUnits(Unit[] units) {
        units[0] = new GameCharacter(0 ,0, ImageBank.getImage("./assets/ship.png"));
    }
}

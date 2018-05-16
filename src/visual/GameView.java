package visual;

import characters.GameCharacter;
import characters.Unit;
import control.GameControl;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {

    private GameControl game;

    public GameView(GameControl game) {
        this.game = game;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.drawRect(0, 0, this.getWidth(), this.getHeight());

        for (Unit unit : game.getUnits()) {
            if (unit instanceof GameCharacter) {
                GameCharacter character = (GameCharacter) unit;
                character.draw(g);
            }
        }
    }
}

package visual;

import control.GameControl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameFrame extends JFrame {

    private static final String GAME_TITLE = "Meu jogo";
    private GameView view;
    private GameControl game;

    public GameFrame(GameControl game) {
        this.game = game;
        this.view = new GameView(game);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(GAME_TITLE);

        this.setContentPane(view);
        this.setPreferredSize(new Dimension(500, 500));
        this.setVisible(true);

        addKeyListeners();
        startDrawThread();

        pack();
    }

    private void addKeyListeners() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:    game.setDy(-1); break;
                    case KeyEvent.VK_DOWN:  game.setDy(+1); break;
                    case KeyEvent.VK_LEFT:  game.setDx(-1); break;
                    case KeyEvent.VK_RIGHT: game.setDx(+1); break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:    game.setDy(0); break;
                    case KeyEvent.VK_DOWN:  game.setDy(0); break;
                    case KeyEvent.VK_LEFT:  game.setDx(0); break;
                    case KeyEvent.VK_RIGHT: game.setDx(0); break;
                }
            }
        });
    }

    private void startDrawThread() {
        Thread drawThread = new Thread(new Runnable() {

            @Override
            public void run() {
                long before = System.currentTimeMillis();
                long now;

                while (true) {
                    repaint();
                    now = System.currentTimeMillis();
                    long timeGap = now - before;
                    game.move(timeGap);
                    before = now;

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        });
        drawThread.start();
    }

}

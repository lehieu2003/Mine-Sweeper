package gameUI;

import control.World;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.BitSet;

public class GamePanel extends JPanel implements MouseListener {
    private World world;
    private PanelNotification panel1;
    private PanelPlayer panel2;
    private GameFrame gameFrame;
    private int w;
    private int h;
    private int boom;

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getBoom() {
        return boom;
    }

    public void setBoom(int boom) {
        this.boom = boom;
    }

    public GamePanel(int w, int h, int bombNumber, GameFrame gameFrame) {
        this.w = w;
        this.h = h;
        this.gameFrame = gameFrame;

        // get size of this panel
//        setHeight(500);
//        setWidth(500);

        world = new World(w, h, bombNumber);
        setLayout(new BorderLayout());
        panel1 = new PanelNotification(this);
        add(panel1, BorderLayout.NORTH);
        panel2 = new PanelPlayer(this);
        add(panel2, BorderLayout.CENTER);


    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public GameFrame getGameFrame() {
        return gameFrame;
    }

    public void setGameFrame(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        ButtonPlay[][] buttons = panel2.getButtons();
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                if (e.getButton() == 1 && e.getSource() == buttons[i][j]) {
                    if (!world.open(i, j)) {
                        int opt = JOptionPane.showConfirmDialog(null, "You lose! Do you want to play again?", "Game Over", JOptionPane.YES_NO_OPTION);
                        if (opt == JOptionPane.YES_OPTION) {
                            gameFrame.setVisible(false);
                            int w = this.getW();
                            int h = this.getH();
                            new GameFrame(w, h, boom);
                        }else {
                            world.fullTrue();
                        }
                    }
                }
            }
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}


package gameUI;

import control.World;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private World world;
    private PanelNotification panel1;
    private PanelPlayer panel2;
    private GameFrame gameFrame;
    private int width;
    private int height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public GamePanel(int width, int height, int bombNumber, GameFrame gameFrame) {


        this.width = width;
        this.height = height;
        this.gameFrame = gameFrame;

        world = new World(width, height, bombNumber);
        setLayout(new BorderLayout());
        panel1 = new PanelNotification(this);
        add(panel1, BorderLayout.NORTH);
        // get size of this panel
        setHeight(500);
        setWidth(500);
        panel2 = new PanelPlayer(this);
//        panel2.setPreferredSize(new Dimension(500, 200));
        var tem = new JPanel();
        // set color of tem to red
        tem.setBackground(Color.RED);
        add(panel2,BorderLayout.CENTER);


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
}

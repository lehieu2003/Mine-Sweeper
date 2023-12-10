package gameUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelNotification extends JPanel{
    private GamePanel gamePanel;
    private JPanel panel1,panel2;
    private JLabel lbTime,lbBoom;

    public PanelNotification(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        // use BorderLayout to set the direction of the panel
        setLayout(new BorderLayout());

        // creat an empty space under the panel
        setBorder(BorderFactory.createLoweredBevelBorder());

        // add each panel into the main panel and set the direction
        add(panel1 = new JPanel(),BorderLayout.WEST);
        add(panel2 = new JPanel(),BorderLayout.EAST);

        lbTime = gamePanel.getWorld().getTime();
        lbBoom= gamePanel.getWorld().getLbBoom();

        String boom = String.valueOf(gamePanel.getWorld().getBoom());
        if (boom.length() == 1 || boom.length() == 2) boom = "0" + boom;
        else boom = boom;

        panel1.add(lbBoom = new LabelNumber(this,"000"));
        panel2.add(lbTime = new LabelNumber(this,"000"));
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
}
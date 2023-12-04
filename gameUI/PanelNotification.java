package gameUI;

import javax.swing.*;
import java.awt.*;

public class PanelNotification extends JPanel{
    private GamePanel gamePanel;
    private JPanel panel1,panel2,panel3;
    private ButtonSmile buttonSmile;
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
        add(panel3 = new JPanel(),BorderLayout.CENTER);

        lbTime = gamePanel.getWorld().getTime();
        lbBoom= gamePanel.getWorld().getLbBoom();

        panel1.add(lbBoom = new LabelNumber(this,"000"));
        panel2.add(lbTime = new LabelNumber(this,"121"));
        buttonSmile = gamePanel.getWorld().getButtonSmile();
        panel3.add(buttonSmile = new ButtonSmile(this));
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
}

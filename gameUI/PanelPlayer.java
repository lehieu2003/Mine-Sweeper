package gameUI;

import javax.swing.*;
import java.awt.*;

public class PanelPlayer extends JPanel {
    private GamePanel gamePanel;
    public PanelPlayer(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        setLayout(new GridLayout(9, 9));

        JButton[][] buttons = gamePanel.getWorld().getButtons();
        setBorder(BorderFactory.createLoweredBevelBorder());
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {

                    add(buttons[i][j] = new ButtonPlay(this));

            }
        }
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
}

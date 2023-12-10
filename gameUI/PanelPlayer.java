package gameUI;

import javax.swing.*;
import java.awt.*;

public class PanelPlayer extends JPanel {
    private GamePanel gamePanel;
    private ButtonPlay[][] buttons;
    public PanelPlayer(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        setLayout(new GridLayout(gamePanel.getW(), gamePanel.getH()));

        buttons = gamePanel.getWorld().getButtons();
        setBorder(BorderFactory.createLoweredBevelBorder());
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                add(buttons[i][j] = new ButtonPlay(this));
                buttons[i][j].addMouseListener(gamePanel); // adding a MouseListener to each ButtonPlay object in the grid
            }
        }
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public ButtonPlay[][] getButtons() {
        return buttons;
    }

    public void setButtons(ButtonPlay[][] buttons) {
        this.buttons = buttons;
    }
}

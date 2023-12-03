package gameUI;

import javax.swing.*;
import java.awt.*;

public class ButtonSmile extends JButton {
    private PanelNotification panelNotification;

    public ButtonSmile(PanelNotification panelNotification) {
        this.panelNotification = panelNotification;
        setPreferredSize(new Dimension(46, 46));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//        paint(g);
        g.drawImage(panelNotification.getGamePanel().getGameFrame().getLoadData().getListImage().get("smile"), 0, 0, getWidth(), getHeight(), null);
    }
}

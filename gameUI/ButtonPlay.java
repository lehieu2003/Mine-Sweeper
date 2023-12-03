package gameUI;

import model.LoadData;
import javax.swing.*;
import java.awt.*;

public class ButtonPlay extends JButton {
    private PanelPlayer panelPlayer;
    public ButtonPlay(PanelPlayer panelPlayer){
        this.panelPlayer = panelPlayer;
        setPreferredSize(new Dimension(54, 45));

    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
//        paint(g);
        g.drawImage(panelPlayer.getGamePanel().getGameFrame().getLoadData().getListImage().get("rectangle"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);
    }


}

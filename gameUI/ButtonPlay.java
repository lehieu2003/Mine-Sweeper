/*
Lê Nguyễn Quang Hiếu - ITITIU21201
Phạm Văn Mạnh - ITITIU21241
Phạm Hữu Duy Khánh - ITITIU19019
 */
package gameUI;

import javax.swing.*;
import java.awt.*;

public class ButtonPlay extends JButton {
    private int number;
    private PanelPlayer panelPlayer;
    public ButtonPlay(PanelPlayer panelPlayer){
        number = -1;
        this.panelPlayer = panelPlayer;
        setPreferredSize(new Dimension(30, 30));
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        switch (number){
            case -1:
                g.drawImage(panelPlayer.getGamePanel().getGameFrame().getLoadData().getListImage().get("rectangle"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);
                break;
            case 0:
                g.drawImage(panelPlayer.getGamePanel().getGameFrame().getLoadData().getListImage().get("b0"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);
                break;
            case 1:
                g.drawImage(panelPlayer.getGamePanel().getGameFrame().getLoadData().getListImage().get("b1"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);
                break;
            case 2:
                g.drawImage(panelPlayer.getGamePanel().getGameFrame().getLoadData().getListImage().get("b2"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);
                break;
            case 3:
                g.drawImage(panelPlayer.getGamePanel().getGameFrame().getLoadData().getListImage().get("b3"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);
                break;
            case 4:
                g.drawImage(panelPlayer.getGamePanel().getGameFrame().getLoadData().getListImage().get("b4"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);
                break;
            case 5:
                g.drawImage(panelPlayer.getGamePanel().getGameFrame().getLoadData().getListImage().get("b5"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);
                break;
            case 6:
                g.drawImage(panelPlayer.getGamePanel().getGameFrame().getLoadData().getListImage().get("b6"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);
                break;
            case 7:
                g.drawImage(panelPlayer.getGamePanel().getGameFrame().getLoadData().getListImage().get("b7"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);
                break;
            case 8:
                g.drawImage(panelPlayer.getGamePanel().getGameFrame().getLoadData().getListImage().get("b8"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);
                break;
            case 9:
                g.drawImage(panelPlayer.getGamePanel().getGameFrame().getLoadData().getListImage().get("flag"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);
                break;
            case 10:
                g.drawImage(panelPlayer.getGamePanel().getGameFrame().getLoadData().getListImage().get("boomRed"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);
                break;
            default:
                break;
        }
    }
    public void setNumber(int number){
        this.number = number;
    }
}

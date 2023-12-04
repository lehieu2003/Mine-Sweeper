package gameUI;
import javax.swing.*;
import java.awt.*;

public class LabelNumber extends JLabel{
    private PanelNotification panelNotification;
    private String number;

    public LabelNumber(PanelNotification panelNotification, String number){
        this.number = number;
        this.panelNotification = panelNotification;
        setPreferredSize(new Dimension(78, 46));
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if (number.equals("infinity")){
            g.drawImage(panelNotification.getGamePanel().getGameFrame().getLoadData().getListImage().get("infinity"), 0, 0, 26, 46, null);
            g.drawImage(panelNotification.getGamePanel().getGameFrame().getLoadData().getListImage().get("infinity"), 26, 0, 26, 46, null);
            g.drawImage(panelNotification.getGamePanel().getGameFrame().getLoadData().getListImage().get("infinity"), 52, 0, 26, 46, null);
        }
        g.drawImage(panelNotification.getGamePanel().getGameFrame().getLoadData().getListImage().get(String.valueOf(number.charAt(0))), 0, 0, 26,46,null);
        g.drawImage(panelNotification.getGamePanel().getGameFrame().getLoadData().getListImage().get(String.valueOf(number.charAt(1))), 26, 0,26,46, null);
        g.drawImage(panelNotification.getGamePanel().getGameFrame().getLoadData().getListImage().get(String.valueOf(number.charAt(2))), 52, 0,26,46, null);
    }

    public PanelNotification getPanelNotification() {
        return panelNotification;
    }

    public void setPanelNotification(PanelNotification panelNotification) {
        this.panelNotification = panelNotification;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

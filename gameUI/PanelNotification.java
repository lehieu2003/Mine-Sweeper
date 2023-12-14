package gameUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelNotification extends JPanel{
    private static final long serialVersionUID = 1L;
    private GamePanel gamePanel;
    private JPanel panel1,panel2;
    private LabelNumber lbTime,lbBoom;
    private Timer time;
    private int nowTime;

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
        this.time = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ++PanelNotification.this.nowTime;
                PanelNotification.this.updateLbTime();
            }
        });
    }
    public void updateLbTime() {
        if (this.nowTime > 999) {
            this.lbTime.setNumber("infinty");
        } else {
            String cTime = String.valueOf(this.nowTime);
            if (cTime.length() == 1) {
                this.lbTime.setNumber("00" + cTime);
            } else if (cTime.length() == 2) {
                this.lbTime.setNumber("0" + cTime);
            } else {
                this.lbTime.setNumber(cTime);
            }

            this.lbTime.repaint();
        }

    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public Timer getTime() {
        return time;
    }

    public void setTime(Timer time) {
        this.time = time;
    }

    public int getNowTime() {
        return nowTime;
    }

    public void setNowTime(int nowTime) {
        this.nowTime = nowTime;
    }
}
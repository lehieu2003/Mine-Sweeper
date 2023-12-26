/*
Lê Nguyễn Quang Hiếu - ITITIU21201
Phạm Văn Mạnh - ITITIU21241
Phạm Hữu Duy Khánh - ITITIU19019
 */
package gameUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelNotification extends JPanel{
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

        this.time = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ++PanelNotification.this.nowTime;
                PanelNotification.this.updateLbTime();
            }
        });


        panel1.add(lbBoom = new LabelNumber(this,"000"));
        panel2.add(lbTime = new LabelNumber(this,"000"));
        this.updateLbBoom();

    }
    public void updateLbTime() {
        if (this.nowTime > 999) {
            this.lbTime.setNumber("infinity");
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

    public void updateLbBoom(){
        String boom = String.valueOf(gamePanel.getBoom() - gamePanel.getWorld().getFlag());
        if (boom.length() == 1){
            lbBoom.setNumber("00"+boom);
        }else if (boom.length() == 2) {
            lbBoom.setNumber("0" + boom);
        }else {
            if (boom.length() == 3)
                lbBoom.setNumber(boom);
        }
        lbBoom.repaint();
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
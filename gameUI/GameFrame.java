package gameUI;
import model.LoadData;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame{
    private LoadData loadData;
    private GamePanel gamePanel;

    public GameFrame(){
        loadData = new LoadData();
        // set icon for the gameFrame
        setIconImage(loadData.getListImage().get("icon"));

        // add gamePanel into the gameFrame
        gamePanel = new GamePanel(9, 9, 10,this);
        setLayout(new BorderLayout());

        add(gamePanel,BorderLayout.CENTER);
        setPreferredSize(new Dimension(500, 500));
        setTitle("Mine Sweeper");


        pack();
        setLocationRelativeTo(null); // set the gameFrame to the center of the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    } 

    public static void main(String[] args){
        GameFrame gameFrame = new GameFrame();
    }

    public LoadData getLoadData() {
        return loadData;
    }
    public void setLoadData(LoadData loadData) {
        this.loadData = loadData;
    }
}
package gameUI;
import model.LoadData;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame{
    private LoadData loadData;
    private GamePanel gamePanel;
    private JMenu menu;
    private JMenuBar menuBar;
    private JMenuItem basic, normal, hard, exit, newGame;

    public GameFrame(int width, int height, int boom){

        loadData = new LoadData();
        setIconImage(loadData.getListImage().get("icon"));

        setJMenuBar(menuBar = new JMenuBar());
        menuBar.add(menu = new JMenu("Game"));
        menu.add(newGame = new JMenuItem("New Game"));
        menu.addSeparator();
        menu.add(basic = new JMenuItem("Basic"));
        menu.add(normal = new JMenuItem("Normal"));
        menu.add(hard = new JMenuItem("Hard"));
        menu.addSeparator();
        menu.add(exit = new JMenuItem("Exit"));


        if ( width == 8){
            basic.setIcon(new ImageIcon(loadData.getListImage().get("tick")));
        }else if (width == 16) {
            normal.setIcon(new ImageIcon(loadData.getListImage().get("tick")));
        }else {
            if (width == 30) {
                hard.setIcon(new ImageIcon(loadData.getListImage().get("tick")));
            }
        }

        basic.addActionListener(e -> {
            setVisible(false);
            new GameFrame(8,8,10);
        });

        normal.addActionListener(e -> {
            setVisible(false);
            new GameFrame(16,16,40);
        });

        hard.addActionListener(e -> {
            setVisible(false);
            new GameFrame(16,30,99);
        });

        exit.addActionListener(e -> System.exit(0));

        newGame.addActionListener(e -> {
            setVisible(false);
            new GameFrame(width,height,boom);
        });

        // add gamePanel into the gameFrame
        gamePanel = new GamePanel(width, height, boom,this);
//        setLayout(new BorderLayout());
        add(gamePanel);
//        setPreferredSize(new Dimension(500, 500));
        setTitle("Mine Sweeper");

        pack();
        setResizable(true);
        setLocationRelativeTo(null); // set the gameFrame in the center of the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    } 

    public static void main(String[] args){
        new GameFrame(8,8,10);
    }

    public LoadData getLoadData() {
        return loadData;
    }
    public void setLoadData(LoadData loadData) {
        this.loadData = loadData;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public JMenu getMenu() {
        return menu;
    }

    public void setMenu(JMenu menu) {
        this.menu = menu;
    }

    public void setMenuBar(JMenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public JMenuItem getBasic() {
        return basic;
    }

    public void setBasic(JMenuItem basic) {
        this.basic = basic;
    }

    public JMenuItem getNormal() {
        return normal;
    }

    public void setNormal(JMenuItem normal) {
        this.normal = normal;
    }

    public JMenuItem getHard() {
        return hard;
    }

    public void setHard(JMenuItem hard) {
        this.hard = hard;
    }

    public JMenuItem getExit() {
        return exit;
    }

    public void setExit(JMenuItem exit) {
        this.exit = exit;
    }

    public JMenuItem getNewGame() {
        return newGame;
    }

    public void setNewGame(JMenuItem newGame) {
        this.newGame = newGame;
    }
}
package control;

import gameUI.ButtonPlay;
import gameUI.ButtonSmile;
import gameUI.LabelNumber;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class World extends JPanel {
    private ButtonPlay[][] buttons;
    private ButtonSmile buttonSmile;
    private LabelNumber time,boom;
    private Random rand;
    private int[][] arrayBom;

    public World(int width, int height,int bombNumber) {
        buttons = new ButtonPlay[ width][height];
        arrayBom = new int[width][height];

        rand = new Random();

        createArrayBom(bombNumber,width,height);

        for (int i = 0; i < buttons.length; i++){
            for (int j = 0; j < buttons[i].length; j++){
                System.out.print(arrayBom[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void createArrayBom(int bombNumber, int width, int height) {
        int locationX = rand.nextInt(width);
        int locationY = rand.nextInt(height);

        arrayBom[locationX][locationY] = -1;
        int count = 1;
        while (count < bombNumber){
            locationX = rand.nextInt(width);
            locationY = rand.nextInt(height);
            if (arrayBom[locationX][locationY] != -1){
                arrayBom[locationX][locationY] = -1;
                count++;
            }
        }
    }

    public ButtonPlay[][] getButtons() {
        return buttons;
    }

    public void setButtons(ButtonPlay[][] buttons) {
        this.buttons = buttons;
    }

    public ButtonSmile getButtonSmile() {
        return buttonSmile;
    }
    public void setButtonSmile(ButtonSmile buttonSmile) {
        this.buttonSmile = buttonSmile;
    }

    public LabelNumber getTime() {
        return time;
    }

    public void setTime(LabelNumber time) {
        this.time = time;
    }

    public LabelNumber getBoom() {
        return boom;
    }

    public void setBoom(LabelNumber boom) {
        this.boom = boom;
    }
}

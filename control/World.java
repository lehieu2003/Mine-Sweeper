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
    private boolean isComplete;
    private boolean isEnd;
    private LabelNumber time;
    private LabelNumber lbBoom;
    private Random rand;
    private int[][] arrayBom;
    private boolean[][] arrayBoolean;
    private int boom; // check whether the player has won or not

    public World(int width, int height,int bombNumber) {
        this.boom = bombNumber;

        buttons = new ButtonPlay[ width][height];
        arrayBom = new int[width][height];
        arrayBoolean = new boolean[width][height];


        rand = new Random();

        createArrayBom(bombNumber,width,height);
        fillNumber();

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

    public void fillNumber(){
        for (int i = 0; i < arrayBom.length; i++) {
            for (int j = 0; j < arrayBom[i].length; j++) {
                if (arrayBom[i][j] == 0) {
                    int count = 0;
                    for (int l = i - 1; l <= i + 1; l++) {
                        for (int k = j - 1; k <= j + 1; k++) {
                            if (l >= 0 && l <= arrayBom.length - 1 && k >= 0 && k <= arrayBom[i].length - 1)
                                if (arrayBom[l][k] == -1) {
                                    count++;
                                }
                        }
                    }
                    arrayBom[i][j] = count;
                }
            }
        }
    }

    public boolean open(int i, int j){
        if (checkWin()){
            isComplete = true;
            return true;
        }
        if (!isComplete && !isEnd){
            if (!arrayBoolean[i][j]){
                if(arrayBom[i][j] == 0) {

                    arrayBoolean[i][j] = true;
                    buttons[i][j].setNumber(arrayBom[i][j]);
                    buttons[i][j].repaint();
                    for (int l = i - 1; l <= i + 1; l++) {
                        for (int k = j - 1; k <= j + 1; k++) {
                            if (l >= 0 && l <= arrayBom.length - 1 && k >= 0 && k <= arrayBom[i].length - 1)
                                open(l, k); // use recursion until the number is not 0
                        }
                    }
                }else{
                    arrayBoolean[i][j] = true;
                    int number = arrayBom[i][j];
                    if (number != -1) {
                        buttons[i][j].setNumber(number);
                        return true;
                    }
                }
            }
            if (arrayBom[i][j] == -1){
                return false;
            }
            else{
                return true;
            }
        }
        return false;
    }

    public void fullTrue(){
        for(int i = 0; i < arrayBoolean.length; i++){
            for (int j = 0; j < arrayBoolean[i].length; j++){
                arrayBoolean[i][j] = true;
            }

        }
    }
    public boolean checkWin(){
        int count = 0;
        for (int i = 0; i < arrayBoolean.length; i++){
            for (int j = 0; j < arrayBoolean[i].length; j++){
                if (arrayBoolean[i][j]){
                    count++;
                }
            }
        }
        if (count == arrayBoolean.length * arrayBoolean[0].length - boom){
            return true;
        }
        return false;
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

    public LabelNumber getLbBoom() {
        return lbBoom;
    }

    public void setLbBoom(LabelNumber lbBoom) {
        this.lbBoom = lbBoom;
    }

    public boolean[][] getArrayBoolean() {
        return arrayBoolean;
    }

    public void setArrayBoolean(boolean[][] arrayBoolean) {
        this.arrayBoolean = arrayBoolean;
    }

    public int getBoom() {
        return boom;
    }

    public void setBoom(int boom) {
        this.boom = boom;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }
}

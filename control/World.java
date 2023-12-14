package control;

import gameUI.ButtonPlay;
import gameUI.LabelNumber;

import javax.swing.*;
import java.util.Random;

public class World extends JPanel {
    private ButtonPlay[][] buttons;
    private boolean isComplete;
    private boolean isEnd;
    private LabelNumber time;
    private LabelNumber lbBoom;
    private Random rand;
    private int[][] arrayBom;
    private boolean[][] arrayBoolean;
    private boolean[][] arrayFlag;
    private int boom;

    public World(int width, int height, int bombNumber) {
        this.boom = bombNumber;

        buttons = new ButtonPlay[width][height];
        arrayBom = new int[width][height];
        arrayBoolean = new boolean[width][height];
        arrayFlag = new boolean[width][height];

        rand = new Random();

        createArrayBom(bombNumber, width, height);
        fillNumber();

        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
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
        while (count < bombNumber) {
            locationX = rand.nextInt(width);
            locationY = rand.nextInt(height);
            if (arrayBom[locationX][locationY] != -1) {
                arrayBom[locationX][locationY] = -1;
                count++;
            }
        }
    }

    public void fillNumber() {
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

    public boolean open(int i, int j) {
        if (canOpenCell(i, j)) {
            if (arrayBom[i][j] == 0) {
                openEmptyCell(i, j);

                if (checkWin()) {
                    handleWin();
                    return false;
                }

            } else {
                openNumberCell(i, j);

                if (checkWin()) {
                    handleWin();
                    return false;
                }

            }
        }
        return false;
    }

    private boolean canOpenCell(int i, int j) {
        return !arrayFlag[i][j] && !isComplete && !isEnd && !arrayBoolean[i][j];
    }

    private void openEmptyCell(int i, int j) {
        arrayBoolean[i][j] = true;
        buttons[i][j].setNumber(0);
        buttons[i][j].repaint();

        for (int l = i - 1; l <= i + 1; l++) {
            for (int k = j - 1; k <= j + 1; k++) {
                if (isValidCell(l, k) && !arrayBoolean[l][k]) {
                    open(l, k);
                }
            }
        }
    }

    private void openNumberCell(int i, int j) {
        int number = arrayBom[i][j];
        if (number != -1) {
            arrayBoolean[i][j] = true;
            buttons[i][j].setNumber(number);
            buttons[i][j].repaint();
        }else{
            if (number == -1){
                buttons[i][j].setNumber(10);
                    buttons[i][j].repaint();
                    isComplete = true;

                    for (int l = 0; l < arrayBom.length; l++) {
                        for (int k = 0; k < arrayBom[l].length; k++) {
                            if (arrayBom[l][k] == -1 && !arrayBoolean[l][k]) {
                                buttons[l][k].setNumber(10);
                                buttons[l][k].repaint();
                            }
                        }
                    }
            }
        }
    }

    private void handleWin() {
        isEnd = true;
        fullTrue();
    }

    private boolean isValidCell(int i, int j) {
        return i >= 0 && i < arrayBom.length && j >= 0 && j < arrayBom[i].length;
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

    public void flag(int i, int j){
        if (!arrayBoolean[i][j]){
            if (arrayFlag[i][j]) {
                arrayFlag[i][j] = false;
                buttons[i][j].setNumber(-1);
                buttons[i][j].repaint();
            }else{
                arrayFlag[i][j] = true;
                buttons[i][j].setNumber(9);
                buttons[i][j].repaint();
            }
        }
    }

    public ButtonPlay[][] getButtons() {
        return buttons;
    }

    public void setButtons(ButtonPlay[][] buttons) {
        this.buttons = buttons;
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

    public boolean[][] getArrayFlag() {
        return arrayFlag;
    }

    public void setArrayFlag(boolean[][] arrayFlag) {
        this.arrayFlag = arrayFlag;
    }
}

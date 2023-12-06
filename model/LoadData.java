package model;

import gameUI.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.HashMap;

public class LoadData {
    private HashMap<String, BufferedImage> listImage;

    public LoadData() {
        listImage = new HashMap<String, BufferedImage>();
        try {
            BufferedImage imageIcon = ImageIO.read(new File("icon.png"));
            listImage.put("icon", imageIcon);

            BufferedImage image = ImageIO.read(new File("minesweeper.png"));
            listImage.put("rectangle", image.getSubimage(0,39,16,16));
            listImage.put("flag", image.getSubimage(16,39,16,16));
            listImage.put("boomRed", image.getSubimage(32,39,16,16));
            listImage.put("boomX", image.getSubimage(48,39,16,16));
            listImage.put("boom", image.getSubimage(64,39,16,16));
            listImage.put("b0", image.getSubimage(0,23,16,16));
            listImage.put("b1", image.getSubimage(16,23,16,16));
            listImage.put("b2", image.getSubimage(32,23,16,16));
            listImage.put("b3", image.getSubimage(48,23,16,16));
            listImage.put("b4", image.getSubimage(64,23,16,16));
            listImage.put("b5", image.getSubimage(80,23,16,16));
            listImage.put("b6", image.getSubimage(96,23,16,16));
            listImage.put("b7", image.getSubimage(112,23,16,16));
            listImage.put("b8", image.getSubimage(128,23,16,16));
            listImage.put("smile", image.getSubimage(0,55,26,26));
            listImage.put("smilePress", image.getSubimage(26,55,26,26));
            listImage.put("smilePressPlay", image.getSubimage(52,55,26,26));
            listImage.put("smileLose", image.getSubimage(78,55,26,26));
            listImage.put("smileWin", image.getSubimage(104,55,26,26));
            listImage.put("0", image.getSubimage(0,0,13,23));
            listImage.put("1", image.getSubimage(13,0,13,23));
            listImage.put("2", image.getSubimage(26,0,13,23));
            listImage.put("3", image.getSubimage(39,0,13,23));
            listImage.put("4", image.getSubimage(52,0,13,23));
            listImage.put("5", image.getSubimage(65,0,13,23));
            listImage.put("6", image.getSubimage(78,0,13,23));
            listImage.put("7", image.getSubimage(91,0,13,23));
            listImage.put("8", image.getSubimage(104,0,13,23));
            listImage.put("9", image.getSubimage(117,0,13,23));
            listImage.put("infinity", image.getSubimage(120,0,13,23));
            listImage.put("tick", image.getSubimage(140,49,7,7));
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    public HashMap<String, BufferedImage> getListImage() {
        return listImage;
    }

    public void setListImage(HashMap<String, BufferedImage> listImage) {
        this.listImage = listImage;
    }
}

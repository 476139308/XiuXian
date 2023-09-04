package com.yj.xiuxian.panel.fulu;

import lombok.Data;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/9/4 9:43
 * 画符功能：
 * 1.在系统中，先定义一系列的简单符纸图片为模版,将其转换成图片矩阵保存，两种颜色，白色是0，黑色是1。
 * 2.画符界面生成一个paint画板，用户在上面画图并记录下来，生成图片矩阵2
 * 3.将图片矩阵与图片矩阵2对比（矩阵2-矩阵1），就会存在0,1,-1三个数，0就是契合，-1表示该画未画，1表示不该画画了
 */
@Data

public class FuLu {


    public static void compareByMatrix() {
        BufferedImage bimg;
        try {
            bimg = ImageIO.read(new File("C:\\Users\\yujin\\Desktop\\temp\\Snipaste_2023-09-04_10-04-09.png"));
        } catch (Exception exception) {
            System.out.println("有文件没有找到,请检查文件是否存在或路径是否正确");
            return;
        }

        int[][] data = new int[bimg.getWidth()][bimg.getHeight()];
        int countEmpty = 0;
        int countFill = 0;
        for (int i = 0; i < bimg.getWidth(); i++) {
            for (int j = 0; j < bimg.getHeight(); j++) {
                if (bimg.getRGB(i, j) == -1) {
                    data[i][j] = 0;
                    countEmpty++;
                } else {
                    data[i][j] = 1;
                    countFill++;
                }
            }
        }

        BufferedImage bimg2;
        try {
            bimg2 = ImageIO.read(new File("C:\\Users\\yujin\\Desktop\\temp\\Snipaste_2023-09-04_10-04-46.png"));
        } catch (Exception exception) {
            System.out.println("有文件没有找到,请检查文件是否存在或路径是否正确");
            return;
        }
        int[][] data2 = new int[bimg2.getWidth()][bimg2.getHeight()];
        for (int i = 0; i < bimg2.getWidth(); i++) {
            for (int j = 0; j < bimg2.getHeight(); j++) {
                if (bimg.getRGB(i, j) == -1) {
                    data[i][j] = 0;
                    countEmpty++;
                } else {
                    data[i][j] = 1;
                    countFill++;
                }
            }
        }

        int[][] data3 = new int[bimg2.getWidth()][bimg2.getHeight()];

        int countEmptyOfResult = 0;
        int count1OfResult = 0;
        int count11OfResult = 0;
        for (int i = 0; i < bimg2.getWidth(); i++) {
            for (int j = 0; j < bimg2.getHeight(); j++) {
                data3[i][j] = data2[i][j] - data[i][j];
                if (data3[i][j] == 0) {
                    countEmptyOfResult++;
                } else if (data3[i][j] == 1) {
                    count1OfResult++;
                } else {
                    count11OfResult++;
                }
            }
        }

//        System.out.println("data = " + data3);
    }

    public static int[] getData(String name) {
        try {
            BufferedImage img = ImageIO.read(new File(name));
            BufferedImage slt = new BufferedImage(100, 100,
                    BufferedImage.TYPE_INT_RGB);
            slt.getGraphics().drawImage(img, 0, 0, 100, 100, null);
            // ImageIO.write(slt,"jpeg",new File("slt.jpg"));
            int[] data = new int[256];
            for (int x = 0; x < slt.getWidth(); x++) {
                for (int y = 0; y < slt.getHeight(); y++) {
                    int rgb = slt.getRGB(x, y);
                    Color myColor = new Color(rgb);
                    int r = myColor.getRed();
                    int g = myColor.getGreen();
                    int b = myColor.getBlue();
                    data[(r + g + b) / 3]++;
                }
            }
            // data 就是所谓图形学当中的直方图的概念
            return data;
        } catch (Exception exception) {
            System.out.println("有文件没有找到,请检查文件是否存在或路径是否正确");
            return null;
        }
    }

    public static float compare(int[] s, int[] t) {
        try {
            float result = 0F;
            for (int i = 0; i < s.length; i++) {
                int abs = Math.abs(s[i] - t[i]);
                int max = Math.max(s[i], t[i]);
                result += (1 - ((float) abs / (max == 0 ? 1 : max)));
            }
            return (result / 256) * 100;
        } catch (Exception exception) {
            return 0;
        }
    }
}

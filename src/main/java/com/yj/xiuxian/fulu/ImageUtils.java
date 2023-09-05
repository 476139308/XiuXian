package com.yj.xiuxian.fulu;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
 
public class ImageUtils{
 
    int[] average1 = new int[65];
    int[] average2 = new int[65];
    boolean b = false;
 
    public int[][] readImagePix(String path){
        // 文件对象
        File file = new File (path);
        BufferedImage readimg = null;
        try {
            readimg = ImageIO.read (file);
        } catch (IOException e) {
            e.printStackTrace ();
        }
        int width = readimg.getWidth ();
        int height = readimg.getHeight ();
        int[][] imgArray = new int[width][height];
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                imgArray[i][j] = readimg.getRGB (i, j);
            }
        }
        return imgArray;
    }
 
    public int getRgbGray(int numPixels){
        // byte -128 127
        int red = (numPixels>>16)&0xFF;
        int green = (numPixels>>8)&255;
        int blue = (numPixels>>0)&255;
        // 灰度 -- 减少计算量 以及 更方便计算
        int gray = (red + green + blue) / 3;
        return gray;
    }
 
    //根据二维数组 绘制图片
    public void drawImage_1(Graphics g,int[][] imgArray){
        BufferedImage buffimg00 = new BufferedImage (imgArray.length, imgArray[0].length, BufferedImage.TYPE_INT_ARGB);
        for(int i = 0; i < imgArray.length; i++){
            for(int j = 0; j < imgArray[i].length; j++){
                buffimg00.setRGB (i,j,imgArray[i][j]);
            }
        }
        // 一次性绘制出来 只占一次IO
        g.drawImage (buffimg00, 30, 100, null);
        b = !b;
        System.out.print("图像1的指纹为：");
    }
 
    public void drawImage_2(Graphics g,int[][] imgArray){
        BufferedImage buffimg00 = new BufferedImage (imgArray.length, imgArray[0].length, BufferedImage.TYPE_INT_ARGB);
        for(int i = 0; i < imgArray.length; i++){
            for(int j = 0; j < imgArray[i].length; j++){
                buffimg00.setRGB (i,j,imgArray[i][j]);
            }
        }
        // 一次性绘制出来 只占一次IO
        g.drawImage (buffimg00, 774, 100, null);
        System.out.println(" ");
        b = !b;
        System.out.print("图像2的指纹为：");
    }
 
    public void zhiwen(int[][] imgArray){
        int width = 8;
        int height = 8;
        int a1 = imgArray.length/width;
        int b1 = imgArray[0].length/height;
        int a2 = imgArray.length - a1 * (width-1);
        int b2 = imgArray[0].length - b1 * (height-1);
        int[][] average = new int[width][height];
 
        int sum0 = 0;
 
        for(int m = 0; m < width; m++){
            for(int n = 0; n < height; n++){
                int sum = 0;
                if(m != (width-1) && n != (height-1)) {
                    for(int i = 0 + m*a1; i < a1 + m*a1; i++){
                        for(int j = 0 + n*b1; j < b1 + n*b1; j++){
                            int num1 = imgArray[i][j];
                            int gray1 = getRgbGray (num1);
                            sum += gray1;
                        }
                    }
                    average[m][n] = sum/(a1 * b1);
 
                }
 
                if(m == (width-1) && n != (height-1)) {
                    for(int i = 0 + m*a1; i < a2 + m*a1; i++){
                        for(int j = 0 + n*b1; j < b1 + n*b1; j++){
                            int num1 = imgArray[i][j];
                            int gray1 = getRgbGray (num1);
                            sum += gray1;
                        }
                    }
                    average[m][n] = sum/(a2 * b1);
 
                }
 
                if(m != (width-1) && n == (height-1)) {
                    for(int i = 0 + m*a1; i < a1 + m*a1; i++){
                        for(int j = 0 + n*b1; j < b2 + n*b1; j++){
                            int num1 = imgArray[i][j];
                            int gray1 = getRgbGray (num1);
                            sum += gray1;
                        }
                    }
                    average[m][n] = sum/(a1 * b2);
 
                }
 
                if(m == (width-1) && n == (height-1)) {
                    for(int i = 0 + m*a1; i < a2 + m*a1; i++){
                        for(int j = 0 + n*b1; j < b2 + n*b1; j++){
                            int num1 = imgArray[i][j];
                            int gray1 = getRgbGray (num1);
                            sum += gray1;
                        }
                    }
                    average[m][n] = sum/(a2 * b2);
 
                }
 
                sum0 += average[m][n];
 
            }
        }
 
        int average0 = sum0/(width*height);
 
        for(int n = 0; n < height; n++){
            for(int m = 0; m < width; m++){
                if(average[m][n] > average0)average[m][n] = 1;
                else average[m][n] = 0;
 
                if(b) {
                    average1[m+width*n] = average[m][n];
                }else {
                    average2[m+width*n] = average[m][n];
                }
 
                System.out.print(average[m][n]);
 
            }
        }
 
    }
 
    public void xiangsidu(){
        double a=0;
 
        for(int i=0;i<64;i++) {
            if(average1[i] == average2[i])a=a+1.5625;
        }
 
        System.out.println(" ");
        System.out.print("两张图像的相似度为："+a);
    }
 
}
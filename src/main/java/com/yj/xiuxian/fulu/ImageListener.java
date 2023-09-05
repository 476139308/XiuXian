package com.yj.xiuxian.fulu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class ImageListener implements ActionListener{
    private Graphics g = null;
    ImageUtils imageUtils;
    int[][] readImagePixArray1;
    int[][] readImagePixArray2;
 
    // set
    public void setGraphics(Graphics g){
        this.g = g;
    }
 
 
    public ImageListener(){
        imageUtils = new ImageUtils();
        readImagePixArray1 = imageUtils.readImagePix ("C:\\Users\\yujin\\Desktop\\temp\\Snipaste_2023-09-04_10-04-09.png");
        readImagePixArray2 = imageUtils.readImagePix ("C:\\Users\\yujin\\Desktop\\temp\\Snipaste_2023-09-04_10-04-46.png");
    }
 
    @Override
    public void actionPerformed(ActionEvent e){
        // 先获取按钮上的字符串 用来判断调用什么代码
        String btnstr = e.getActionCommand ();
        if (btnstr.equals ("加载图片")) {
 
            imageUtils.drawImage_1 (g,readImagePixArray1);
            imageUtils.zhiwen (readImagePixArray1);
            imageUtils.drawImage_2 (g,readImagePixArray2);
            imageUtils.zhiwen (readImagePixArray2);
 
        }else if (btnstr.equals("开始匹配")) {
            imageUtils.xiangsidu();
 
        }
    }
}
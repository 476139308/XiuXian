package com.yj.xiuxian.panel.fulu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
 
public class ImagePad extends JFrame{
    ImageListener imagelistener = new ImageListener ();
 
    String[] btnstrs = new String[] {"加载图片","开始匹配"};
 
 
    public void addButton(JFrame jf, ActionListener al){
        Dimension dimension = new Dimension (120, 40);
        for (int i = 0; i < btnstrs.length; i++) {
            JButton btn = new JButton (btnstrs[i]);
            btn.setBackground (Color.WHITE);
            btn.setPreferredSize (dimension);
            btn.addActionListener (al);
            jf.add(btn);
        }
    }
 
    ImagePad(){
        setTitle ("相似度判别");
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setSize (1540,900);
        setLocationRelativeTo (null);
 
        setLayout (new FlowLayout ());
 
        addButton(this,imagelistener);
        setVisible (true);
 
        imagelistener.setGraphics (this.getGraphics ());
    }
 
    public static void main(String[] args){
        new ImagePad ();
    }
}
package com.mashibing.lianxi.day01;

import java.awt.*;
import java.awt.event.*;

/**
 * @ClassName TankFrame
 * @Description: TODO
 * @Author 李淼
 * @Date 2020/6/9
 * @Version V1.0
 **/
public class TankFrame02 extends Frame {
    int x=200,y=200;

    public TankFrame02(){
        this.setSize(800,600);
        this.setResizable(false);
        this.setVisible(true);
        this.setTitle("Tank war");
        this.addKeyListener(new MyKeyListener());
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }


    @Override
    public void paint(Graphics g) {
        System.out.println("print");
        g.fillRect(x,y,50,50);
        x+=10;
//        y+=10;
    }

    class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("key pressed");
//            x+=200;
//            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("key released");
        }
    }
}

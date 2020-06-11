package com.mashibing.lianxi.day02.code01;

import com.mashibing.lianxi.day02.code01.Direction;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @ClassName TankFrame
 * @Description: TODO
 * @Author 李淼
 * @Date 2020/6/9
 * @Version V1.0
 **/
public class TankFrame01 extends Frame {
    int x=200,y=200;
    Direction direction = Direction.LEFT;
    private static final int SPEED = 10;

    public TankFrame01(){
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
        g.fillRect(x,y,50,50);
        switch (direction){
            case LEFT:
                x-=SPEED;
                break;
            case RIGHT:
                x+=SPEED;
                break;
            case UP:
                y-=SPEED;
                break;
            case DOWN:
                y+=SPEED;
                break;
            default:
                break;
        }

    }

    class MyKeyListener extends KeyAdapter {
        boolean bL = false;
        boolean bR = false;
        boolean bU = false;
        boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode){
                case KeyEvent.VK_LEFT:
                    bL=true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD=true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR=true;
                    break;
                case KeyEvent.VK_UP:
                    bU=true;
                    break;
                default:
                    break;
            }

            setTankMainDirection();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode){
                case KeyEvent.VK_LEFT:
                    bL=false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD=false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR=false;
                    break;
                case KeyEvent.VK_UP:
                    bU=false;
                    break;
                default:
                    break;
            }
            setTankMainDirection();
        }

        private void setTankMainDirection() {
            if(bL) direction = Direction.LEFT;
            if(bR) direction = Direction.RIGHT;
            if(bU) direction = Direction.UP;
            if(bD) direction = Direction.DOWN;
        }
    }
}

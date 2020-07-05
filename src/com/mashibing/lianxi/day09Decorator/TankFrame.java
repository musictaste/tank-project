package com.mashibing.lianxi.day09Decorator;


import com.mashibing.lianxi.day09Decorator.strategy.FourDirectionFireStrategy;

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
public class TankFrame extends Frame {
    GameModel gameModel = GameModel.getInstance();

    static final int GAME_WIDTH= PropertyMgr.getInt("gameWidth"),GAME_HEIGHT= PropertyMgr.getInt("gameHeight");

    public TankFrame(){
        this.setSize(GAME_WIDTH,GAME_HEIGHT);
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

    /*
    * 双缓冲解决闪烁的问题
    */
    Image offScreenImage = null;

    //Graphics g 是系统画笔
    @Override
    public void update(Graphics g) {
        if(offScreenImage==null){
            offScreenImage= this.createImage(GAME_WIDTH,GAME_HEIGHT);
        }

        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0,GAME_WIDTH,GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);

        // 把内存中图片一次性画到屏幕上（**内存的内容复制到显存）
        g.drawImage(offScreenImage,0,0,null);
    }

    /**
    * 首先把该画出来的东西（坦克， 子弹）先画在内存的图片中，图片大小和游戏画面一致
     * paint方法中的g是内存中的画笔，坦克和子弹使用的是内存的画笔
    **/
    @Override
    public void paint(Graphics g) {
        gameModel.paint(g);

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
            new Thread(()->new Audio("audio/tank_move.wav").play()).start();
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
                case KeyEvent.VK_CONTROL:
                    //在键盘释放的时候，发射子弹
                    //方法二：直接使用类名
                    gameModel.getMainTank().fire(FourDirectionFireStrategy.getInstance());
                    break;
                default:
                    break;
            }
            setTankMainDirection();
        }

        private void setTankMainDirection() {
            Tank myTank = gameModel.getMainTank();
            if(!bL && !bR && !bU && !bD ){
                //坦克静止不动
                myTank.setMoving(false);
            }else{
                //坦克移动
                myTank.setMoving(true);
                if(bL) myTank.setDirection(Direction.LEFT);
                if(bR) myTank.setDirection(Direction.RIGHT);
                if(bU) myTank.setDirection(Direction.UP);
                if(bD) myTank.setDirection(Direction.DOWN);
            }
        }
    }
}

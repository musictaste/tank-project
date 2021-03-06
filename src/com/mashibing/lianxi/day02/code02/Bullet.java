package com.mashibing.lianxi.day02.code02;

import java.awt.*;

/**
 * @ClassName Bullet
 * @Description: TODO
 * @Author 李淼
 * @Date 2020/6/9
 * @Version V1.0
 **/
public class Bullet {
    //子弹的x、y坐标
    private int x,y;

    //子弹的方向
    private Direction direction;

    //子弹的速度
    private static final int SPEED = 10;

    //子弹的大小：长、宽
    private int width=30,height=30;

    //游戏界面
    private TankFrame tf =null;

    //子弹是否存活
    public boolean live = true;

    public Bullet(int x, int y, Direction direction,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.tf=tf;
    }

    public void paint(Graphics g){
        //如果子弹不再存活，从容器中移除
        if(!live) tf.bullets.remove(this);

        Color c = g.getColor();
        g.setColor(Color.red);
        g.fillOval(x,y,width,height);
        g.setColor(c);
        move();
    }

    private void move() {
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

        //判断子弹是否还在屏幕边界内，如果不在则子弹不再存活
        if(x<0 || y<0 || x>tf.GAME_WIDTH || y>tf.GAME_HEIGHT) live=false;
    }


}

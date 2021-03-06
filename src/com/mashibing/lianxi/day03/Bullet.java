package com.mashibing.lianxi.day03;

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
    public static int width=ResourceMgr.bulletD.getWidth();
    public static int height=ResourceMgr.bulletD.getHeight();

    //游戏界面
    private TankFrame tf =null;

    //子弹是否存活
    public boolean living = true;

    private Group group;

    public Bullet(int x, int y, Direction direction, Group group,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.group=group;
        this.tf=tf;
    }

    public void paint(Graphics g){
        //如果子弹不再存活，从容器中移除
        if(!living) tf.bullets.remove(this);

        switch (direction){
            case LEFT:
                g.drawImage(ResourceMgr.bulletL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD,x,y,null);
                break;
        }

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
        if(x<0 || y<0 || x>tf.GAME_WIDTH || y>tf.GAME_HEIGHT) living=false;
    }

    /**
    * @MethodName: collideWith
    * @Description: 子弹和坦克碰撞
    **/
    public void collideWith(Tank tank) {
        if(this.group==tank.getGroup()) return;

        //TODO: 用一个rect来记录子弹的位置
        Rectangle bulletRect = new Rectangle(this.x,this.y,width,height);
        Rectangle tankRect = new Rectangle(tank.getX(),tank.getY(),Tank.width,Tank.height);
        if( bulletRect.intersects(tankRect) ){
            this.die();
            tank.die();
        }
    }

    /**
    * @MethodName: die
    * @Description: 子弹死亡
    **/
    private void die() {
        this.living=false;
    }
}

package com.mashibing.lianxi.day08FacadeAndMediator;

import java.awt.*;

/**
 * @ClassName Bullet
 * @Description: TODO
 * @Author 李淼
 * @Date 2020/6/9
 * @Version V1.0
 **/
public class Bullet extends GameObject{
    //子弹的x、y坐标
    private int x,y;

    //子弹的方向
    private Direction direction;

    //子弹的速度
    private static final int SPEED = PropertyMgr.getInt("bulletSpeed");

    //子弹的大小：长、宽
    public static int width= ResourceMgr.getBulletD().getWidth();
    public static int height= ResourceMgr.getBulletD().getHeight();

    //游戏界面
    private GameModel gameModel =null;

    //子弹是否存活
    public boolean living = true;

    public Group group;

    public Rectangle rect = new Rectangle();

    public Bullet(int x, int y, Direction direction, Group group, GameModel gameModel) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.group=group;
        this.gameModel=gameModel;

        rect.x=this.x;
        rect.y=this.y;
        rect.width=width;
        rect.height=height;

        //拿到子弹直接加到列表中
        gameModel.add(this);
    }

    public void paint(Graphics g){
        //如果子弹不再存活，从容器中移除
        if(!living) gameModel.remove(this);

        switch (direction){
            case LEFT:
                g.drawImage(ResourceMgr.getBulletL(),x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.getBulletR(),x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.getBulletU(),x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.getBulletD(),x,y,null);
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

        //移动时，更新rect的坐标
        rect.x=x;
        rect.y=y;

        //判断子弹是否还在屏幕边界内，如果不在则子弹不再存活
        if(x<0 || y<0 || x>TankFrame.GAME_WIDTH || y>TankFrame.GAME_HEIGHT) living=false;
    }

    /**
    * @MethodName: collideWith
    * @Description: 子弹和坦克碰撞
    **/
    public void collideWith(Tank tank) {
        if(this.group==tank.getGroup()) return;

        //用一个rect来记录子弹的位置，避免不停的创建Rectangle对象
        if( rect.intersects(tank.rect) ){
            this.die();
            tank.die();

            //爆炸现在在中心位置
            int explodeX = tank.getX() + Tank.width/2 - Bullet.width/2;
            int explodeY = tank.getY() + Tank.height/2 - Bullet.height/2;

            gameModel.add(new Explode(explodeX,explodeY,gameModel));
        }
    }

    /**
    * @MethodName: die
    * @Description: 子弹死亡
    **/
    public void die() {
        this.living=false;
    }
}

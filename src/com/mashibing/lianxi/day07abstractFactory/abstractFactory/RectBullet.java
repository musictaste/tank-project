package com.mashibing.lianxi.day07abstractFactory.abstractFactory;

import com.mashibing.lianxi.day07abstractFactory.*;

import java.awt.*;

/**
 * @ClassName Bullet
 * @Description: TODO
 * @Author 李淼
 * @Date 2020/6/9
 * @Version V1.0
 **/
public class RectBullet extends BaseBullet {
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
    private TankFrame tf =null;

    //子弹是否存活
    public boolean living = true;

    private Group group;

    public Rectangle rect = new Rectangle();

    public RectBullet(int x, int y, Direction direction, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.group=group;
        this.tf=tf;

        rect.x=this.x;
        rect.y=this.y;
        rect.width=width;
        rect.height=height;

        //拿到子弹直接加到列表中
        tf.bullets.add(this);
    }

    @Override
    public void paint(Graphics g){
        //如果子弹不再存活，从容器中移除
        if(!living) tf.bullets.remove(this);

        Color color = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillRect(x,y,10,10);
        g.setColor(color);
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
        if(x<0 || y<0 || x>tf.GAME_WIDTH || y>tf.GAME_HEIGHT) living=false;
    }

    /**
    * @MethodName: collideWith
    * @Description: 子弹和坦克碰撞
    **/
    public void collideWith(BaseTank tank) {
        if(this.group==tank.getGroup()) return;

        //用一个rect来记录子弹的位置，避免不停的创建Rectangle对象
        if( rect.intersects(tank.rect) ){
            this.die();
            tank.die();

            //爆炸现在在中心位置
            int explodeX = tank.getX() + Tank.width/2 - RectBullet.width/2;
            int explodeY = tank.getY() + Tank.height/2 - RectBullet.height/2;
            tf.explodes.add(tf.gameFactory.createExplode(explodeX,explodeY,tf));
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

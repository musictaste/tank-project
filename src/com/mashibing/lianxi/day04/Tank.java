package com.mashibing.lianxi.day04;


import java.awt.*;
import java.util.Random;

/**
 * @ClassName Tank02
 * @Description: TODO
 * @Author 李淼
 * @Date 2020/6/9
 * @Version V1.0
 **/
public class Tank {
    private int x=200,y=200;
    private Direction direction = Direction.LEFT;
    public static int width = ResourceMgr.tankU.getWidth();
    public static int height = ResourceMgr.tankU.getHeight();
    private static final int SPEED = 2;
    private TankFrame tf = null;
    private boolean living = true;
    private Random random = new Random();
    private Group group;
    private boolean moving =true;//处理静止状态

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Tank(int x, int y, Direction direction, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.group=group;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        if(!living) tf.enemies.remove(this);

        switch (direction){
            case LEFT:
                g.drawImage(ResourceMgr.tankL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD,x,y,null);
                break;
        }
        move();
    }

    private void move() {
        if(!moving) return;

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

        //敌方坦克随机发射子弹
        if(this.group==Group.BAD && random.nextInt(100)>95) this.fire();

        //敌方坦克随机移动
        if(this.group==Group.BAD && random.nextInt(100)>95)  this.randomDirection();

    }

    private void randomDirection() {
        this.direction = Direction.values()[random.nextInt(4)];
    }

    public void fire() {
        //让子弹从坦克的中心位置打出，公式=当前x + 坦克图片的一半  - 子弹图片的一半

        int bulletX = this.x + Tank.width/2 - Bullet.width/2;
        int bulletY = this.y + Tank.height/2 - Bullet.height/2;
        //为了以后的灵活，比如一次发射5个子弹，发射核弹，所以不建议return new Bullet()
        tf.bullets.add(new Bullet(bulletX,bulletY,this.direction,this.group,this.tf));
        if(this.group == Group.GOOD) new Thread(()-> new Audio("audio/tank_fire.wav").play()).start();
    }

    /**
    * @MethodName: die
    * @Description: 坦克死亡
    **/
    public void die() {
        this.living=false;
    }
}

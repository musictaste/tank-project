package com.mashibing.lianxi.day02.code02;


import java.awt.*;

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
    private static final int SPEED = 5;
    private TankFrame tf = null;

    private boolean moving =false;//处理静止状态

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

    public Tank(int x, int y, Direction direction, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.green);
        g.fillRect(x,y,50,50);
        g.setColor(c);
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
    }

    public void fire() {
        //为了以后的灵活，比如一次发射5个子弹，发射核弹，所以不建议return new Bullet()
        tf.bullets.add(new Bullet(this.x,this.y,this.direction,this.tf));
    }
}

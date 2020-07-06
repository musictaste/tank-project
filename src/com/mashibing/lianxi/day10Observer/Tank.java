package com.mashibing.lianxi.day10Observer;


import com.mashibing.lianxi.day10Observer.observer.TankFireEvent;
import com.mashibing.lianxi.day10Observer.observer.TankFireHandler;
import com.mashibing.lianxi.day10Observer.observer.TankFireObserver;
import com.mashibing.lianxi.day10Observer.strategy.DefaultFireStrategy;
import com.mashibing.lianxi.day10Observer.strategy.FireStrategy;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @ClassName Tank02
 * @Description: TODO
 * @Author 李淼
 * @Date 2020/6/9
 * @Version V1.0
 **/
public class Tank extends GameObject {
    //记录坦克移动之前的位置
    private int oldX,oldY;

    private Direction direction = Direction.LEFT;
    public static int width = ResourceMgr.getGoodTankU().getWidth();
    public static int height = ResourceMgr.getGoodTankU().getHeight();
    private static final int SPEED = PropertyMgr.getInt("tankSpeed");
    private boolean living = true;
    private Random random = new Random();
    private Group group;
    private boolean moving =true;//处理静止状态

    public Rectangle rect = new Rectangle();

    public static int getSPEED() {
        return SPEED;
    }
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

    public Tank(int x, int y, Direction direction, Group group) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.group=group;

        rect.x=this.x;
        rect.y=this.y;
        rect.width=width;
        rect.height=height;

        GameModel.getInstance().add(this);
    }

    public void paint(Graphics g) {
        if(!living) GameModel.getInstance().remove(this);

        switch (direction){
            case LEFT:
                g.drawImage(this.group== Group.GOOD ? ResourceMgr.getGoodTankL(): ResourceMgr.getBadTankL(),x,y,null);
                break;
            case RIGHT:
                g.drawImage(this.group== Group.GOOD ? ResourceMgr.getGoodTankR(): ResourceMgr.getBadTankR(),x,y,null);
                break;
            case UP:
                g.drawImage(this.group== Group.GOOD ? ResourceMgr.getGoodTankU(): ResourceMgr.getBadTankU(),x,y,null);
                break;
            case DOWN:
                g.drawImage(this.group== Group.GOOD ? ResourceMgr.getGoodTankD(): ResourceMgr.getBadTankD(),x,y,null);
                break;
        }
        move();
    }

    public void back(){
        x=oldX;
        y=oldY;
    }

    private void move() {
        //记录移动之前的位置
        oldX = x;
        oldY = y;
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
        if(this.group== Group.BAD && random.nextInt(100)>95) {
            //方法二：直接使用类名
            this.fire(DefaultFireStrategy.getInstance());
        }

        //敌方坦克随机移动
        if(this.group== Group.BAD && random.nextInt(100)>95)  this.randomDirection();

        //边界检测
        boundCheck();

        //边界检测以后，移动的时候，更新Rectangle的坐标，用于碰撞检测
        rect.x=x;
        rect.y=y;
    }

    //坦克移动的边界检测
    //减2的原因是坦克别太靠边
    private void boundCheck() {
        if(this.x<2) x=2;
        if(this.x> TankFrame.GAME_WIDTH- Tank.width-2) x= TankFrame.GAME_WIDTH- Tank.width-2;
        if(this.y<28) y=28;
        if(this.y> TankFrame.GAME_HEIGHT- Tank.height-2) y = TankFrame.GAME_HEIGHT- Tank.height-2;
    }

    //坦克的随机方向
    private void randomDirection() {
        this.direction = Direction.values()[random.nextInt(4)];
    }

    /**
     * 坦克发射子弹
     * 可以将FireStrategy 定义为成员变量，也可以作为参数传入
     *  1.将FireStrategy作为成员变量，因为成员变量的作用域是整个类；FireStrategy不需要为单例
     *  2.传参数的话，作用域为一个方法
     *      传参数带来的问题是，每次调用都需要new一个FireStrategy，所以可以将FireStrategy做成单例
     */
    public void fire(FireStrategy fireStrategy) {
        fireStrategy.fire(this);
    }

    /**
    * @MethodName: die
    * @Description: 坦克死亡
    **/
    public void die() {
        this.living=false;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    private List<TankFireObserver> fireObservers = Arrays.asList(new TankFireHandler());

    public void handleFirekey() {
        TankFireEvent event = new TankFireEvent(this);
        for (TankFireObserver o:fireObservers) {
            o.actionOnFire(event);
        }
    }
}

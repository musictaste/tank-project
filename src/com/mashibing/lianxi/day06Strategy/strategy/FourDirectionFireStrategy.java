package com.mashibing.lianxi.day06Strategy.strategy;

import com.mashibing.lianxi.day06Strategy.*;

/**
 * @ClassName FourDirectionFireStrategy
 * @Description: 向四个方向开火--单例
 * @Author 李淼
 * @Date 2020/6/18
 * @Version V1.0
 **/
public class FourDirectionFireStrategy implements FireStrategy {
    private static final FourDirectionFireStrategy INSTANCE = new FourDirectionFireStrategy();

    private FourDirectionFireStrategy(){}

    public static FourDirectionFireStrategy getInstance(){
        return INSTANCE;
    }


    @Override
    public void fire(Tank t) {
        //让子弹从坦克的中心位置打出，公式=当前x + 坦克图片的一半  - 子弹图片的一半

        int bulletX = t.getX() + Tank.width/2 - Bullet.width/2;
        int bulletY = t.getY() + Tank.height/2 - Bullet.height/2;
        //为了以后的灵活，比如一次发射5个子弹，发射核弹，所以不建议return new Bullet()
        Direction[] directions = Direction.values();
        for (Direction dir:directions) {
            new Bullet(bulletX,bulletY, dir,t.getGroup(),t.getTf());
        }
        if(t.getGroup() == Group.GOOD) new Thread(()-> new Audio("audio/tank_fire.wav").play()).start();
    }
}

package com.mashibing.lianxi.day10Observer.strategy;

import com.mashibing.lianxi.day10Observer.*;
import com.mashibing.lianxi.day10Observer.decorator.RectDecorator;
import com.mashibing.lianxi.day10Observer.decorator.TailDecorator;

/**
 * @ClassName DefaultFireStrategy
 * @Description: 默认的开火策略-单例
 * @Author 李淼
 * @Date 2020/6/18
 * @Version V1.0
 **/
public class DefaultFireStrategy implements FireStrategy {
    //通过反射new对象时，会报：Tank can not access a member of class com.mashibing.lianxi.day06Strategy.strategy.DefaultFireStrategy with modifiers "private"
    //因为构造方法是private的
    private static final DefaultFireStrategy INSTANCE=new DefaultFireStrategy();

    private DefaultFireStrategy(){}

    public static DefaultFireStrategy getInstance(){
        return INSTANCE;
    }

    @Override
    public void fire(Tank t) {
        //让子弹从坦克的中心位置打出，公式=当前x + 坦克图片的一半  - 子弹图片的一半

        int bulletX = t.getX() + Tank.width/2 - Bullet.width/2;
        int bulletY = t.getY() + Tank.height/2 - Bullet.height/2;
        //为了以后的灵活，比如一次发射5个子弹，发射核弹，所以不建议return new Bullet()
//        new Bullet(bulletX,bulletY,t.getDirection(),t.getGroup());
        //TODO 遗留bug：new Bullet把自己又加了一遍
//        GameModel.getInstance().add(new RectDecorator(new Bullet(bulletX,bulletY,t.getDirection(),t.getGroup())));

        //装饰者模式经常跟责任链模式组合使用，这样就可以避免下面的代码
        GameModel.getInstance().add(
                new RectDecorator(
                        new TailDecorator(
                            new Bullet(bulletX,bulletY,t.getDirection(),t.getGroup())
                        )
                ));
        if(t.getGroup() == Group.GOOD) new Thread(()-> new Audio("audio/tank_fire.wav").play()).start();
    }
}

package com.mashibing.lianxi.day07abstractFactory.abstractFactory;

import com.mashibing.lianxi.day07abstractFactory.*;

/**
 * @ClassName DefaultFactory
 * @Description: TODO
 * @Author 李淼
 * @Date 2020/6/21
 * @Version V1.0
 **/
public class DefaultFactory extends GameFactory {
    @Override
    public BaseTank createTank(int x, int y, Direction direction, Group group, TankFrame tf) {
        return new Tank(x,y,direction,group,tf);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Direction direction, Group group, TankFrame tf) {
        return new Bullet(x,y,direction,group,tf);
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tf) {
        return new Explode(x,y,tf);
    }
}

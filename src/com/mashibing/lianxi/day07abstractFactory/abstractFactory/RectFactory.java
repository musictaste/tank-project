package com.mashibing.lianxi.day07abstractFactory.abstractFactory;

import com.mashibing.lianxi.day07abstractFactory.Direction;
import com.mashibing.lianxi.day07abstractFactory.Explode;
import com.mashibing.lianxi.day07abstractFactory.Group;
import com.mashibing.lianxi.day07abstractFactory.TankFrame;

/**
 * @ClassName RectFactory
 * @Description: TODO
 * @Author 李淼
 * @Date 2020/6/21
 * @Version V1.0
 **/
public class RectFactory extends GameFactory {
    @Override
    public BaseTank createTank(int x, int y, Direction direction, Group group, TankFrame tf) {
        return new RectTank(x,y,direction,group,tf);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Direction direction, Group group, TankFrame tf) {
        return new RectBullet(x,y,direction,group,tf);
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tf) {
        return new RectExplode(x,y,tf);
    }
}

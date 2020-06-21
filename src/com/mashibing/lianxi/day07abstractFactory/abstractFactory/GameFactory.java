package com.mashibing.lianxi.day07abstractFactory.abstractFactory;

import com.mashibing.lianxi.day07abstractFactory.Direction;
import com.mashibing.lianxi.day07abstractFactory.Group;
import com.mashibing.lianxi.day07abstractFactory.TankFrame;

/**
 * @ClassName GameFactory
 * @Description: TODO
 * @Author 李淼
 * @Date 2020/6/21
 * @Version V1.0
 **/
public abstract class GameFactory {
    public abstract BaseTank createTank(int x, int y, Direction direction, Group group, TankFrame tf);
    public abstract BaseBullet createBullet(int x, int y, Direction direction, Group group, TankFrame tf);
    public abstract BaseExplode createExplode(int x, int y, TankFrame tf);
}

package com.mashibing.lianxi.day10Observer.observer;

import com.mashibing.lianxi.day10Observer.Tank;
import com.mashibing.lianxi.day10Observer.strategy.FourDirectionFireStrategy;

/**
 * @ClassName TankFireHandler
 * @Description: TODO
 * @Author 李淼
 * @Date 2020/7/6
 * @Version V1.0
 **/
public class TankFireHandler implements TankFireObserver{

    @Override
    public void actionOnFire(TankFireEvent event) {
        Tank t = event.getSource();
        t.fire(FourDirectionFireStrategy.getInstance());
    }
}

package com.mashibing.lianxi.day10Observer.observer;

/**
 * @ClassName TankFireObserver
 * @Description: TODO
 * @Author 李淼
 * @Date 2020/7/6
 * @Version V1.0
 **/
public interface TankFireObserver {
    void actionOnFire(TankFireEvent event);
}

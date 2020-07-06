package com.mashibing.lianxi.day10Observer.observer;

import com.mashibing.lianxi.day10Observer.Tank;

/**
 * @ClassName TankFireEvent
 * @Description: 事件本身Event
 * @Author 李淼
 * @Date 2020/7/6
 * @Version V1.0
 **/
public class TankFireEvent {
    Tank tank;
    public Tank getSource(){
        return this.tank;
    }

    public TankFireEvent(Tank tank) {
        this.tank = tank;
    }
}

package com.mashibing.lianxi.day09CodeRefactor.strategy;

import com.mashibing.lianxi.day09CodeRefactor.Tank;

/**
 * @ClassName FireStrategy
 * @Description: 开火策略
 * @Author 李淼
 * @Date 2020/6/18
 * @Version V1.0
 **/
public interface FireStrategy {
    void fire(Tank t);
}

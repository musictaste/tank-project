package com.mashibing.lianxi.day07abstractFactory.abstractFactory;

import com.mashibing.lianxi.day07abstractFactory.Tank;

import java.awt.*;

/**
 * @ClassName BaseBullet
 * @Description: TODO
 * @Author 李淼
 * @Date 2020/6/21
 * @Version V1.0
 **/
public abstract class BaseBullet {
    public abstract void paint(Graphics g);

    public abstract void collideWith(BaseTank tank);
}

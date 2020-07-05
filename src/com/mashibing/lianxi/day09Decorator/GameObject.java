package com.mashibing.lianxi.day09Decorator;

import java.awt.*;

/**
 * @ClassName GameObject
 * @Description: TODO
 * @Author 李淼
 * @Date 2020/7/4
 * @Version V1.0
 **/
public abstract class GameObject {
    //protected修饰符，是为了在子类RectDecorator中可以使用
    public int x,y;
    public abstract void paint(Graphics g);
    public abstract int getWidth();
    public abstract int getHeight();
}

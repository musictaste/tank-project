package com.mashibing.lianxi.day10Observer;

import java.awt.*;
import java.io.Serializable;

/**
 * @ClassName GameObject
 * @Description: TODO
 * @Author 李淼
 * @Date 2020/7/4
 * @Version V1.0
 **/
public abstract class GameObject implements Serializable {
    //protected修饰符，是为了在子类RectDecorator中可以使用
    public int x,y;
    public abstract void paint(Graphics g);
    public abstract int getWidth();
    public abstract int getHeight();
}

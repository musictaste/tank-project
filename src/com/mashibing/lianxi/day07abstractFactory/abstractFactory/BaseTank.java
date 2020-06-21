package com.mashibing.lianxi.day07abstractFactory.abstractFactory;

import com.mashibing.lianxi.day07abstractFactory.Group;

import java.awt.*;

/**
 * @ClassName BaseTank
 * @Description: TODO
 * @Author 李淼
 * @Date 2020/6/21
 * @Version V1.0
 **/
public abstract class BaseTank {
    public Group group;
    public Rectangle rect = new Rectangle();
    public Group getGroup() {
        return this.group;
    }

    public abstract void paint(Graphics g);

    public abstract void die();

    public abstract int getX();

    public abstract int getY();

}

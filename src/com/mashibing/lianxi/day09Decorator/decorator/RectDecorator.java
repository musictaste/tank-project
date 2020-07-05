package com.mashibing.lianxi.day09Decorator.decorator;

import com.mashibing.lianxi.day09Decorator.GameObject;

import java.awt.*;

/**
 * @ClassName RectDecorator
 * @Description: TODO
 * @Author 李淼
 * @Date 2020/7/5
 * @Version V1.0
 **/
public class RectDecorator extends GameObjectDecorator {
    public RectDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        //子弹是不停move，所以需要更新x/y的位置
        this.x=go.x;
        this.y=go.y;

        super.go.paint(g);
        Color color = g.getColor();
        g.setColor(Color.YELLOW);
        g.drawRect(go.x,go.y,go.getWidth(),go.getHeight());
        g.setColor(color);
    }

    @Override
    public int getWidth() {
        return super.go.getWidth();
    }

    @Override
    public int getHeight() {
        return super.go.getHeight();
    }
}

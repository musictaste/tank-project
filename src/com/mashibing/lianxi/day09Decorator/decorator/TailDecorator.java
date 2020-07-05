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
public class TailDecorator extends GameObjectDecorator {
    public TailDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        //为了解决问题1，因为子弹是不停move，所以需要更新x,y的位置
        this.x=go.x;
        this.y=go.y;

        super.go.paint(g);
        Color color = g.getColor();
        g.setColor(Color.WHITE);
        //问题1:，当RectDecorator和TailDecorator组合时，不是没有边框了
//        g.drawLine(super.go.x,super.go.y,super.go.x+super.go.getWidth(),super.go.y+super.go.getHeight());

        g.drawLine(go.x,go.y,go.x+go.getWidth(),go.y+go.getHeight());

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

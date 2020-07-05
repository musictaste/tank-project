package com.mashibing.lianxi.day09Decorator;

import java.awt.*;

/**
 * @ClassName Wall
 * @Description: TODO
 * @Author 李淼
 * @Date 2020/7/5
 * @Version V1.0
 **/
public class Wall extends GameObject {
    int width,height;
    public Rectangle rect;

    public Wall(int x,int y,int width, int height) {
        this.x = x;
        this.y= y;
        this.width = width;
        this.height = height;
        this.rect = new Rectangle(x,y,width,height);

        GameModel.getInstance().add(this);
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x,y,width,height);
        g.setColor(c);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}

package com.mashibing.lianxi.day03;

import java.awt.*;

/**
 * @ClassName Bullet
 * @Description: TODO
 * @Author 李淼
 * @Date 2020/6/9
 * @Version V1.0
 **/
public class Explode {
    private int x,y;
    public static int width=ResourceMgr.explodes[0].getWidth();
    public static int height=ResourceMgr.explodes[0].getHeight();
    private TankFrame tf =null;
    private boolean living =true;

    //记录当前是爆炸的第几步
    private int step=0;


    public Explode(int x, int y,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf=tf;
    }

    public void paint(Graphics g){
        g.drawImage(ResourceMgr.explodes[step++],x,y,null);
        if(step >= ResourceMgr.explodes.length) step=0;
    }

}

package com.mashibing.lianxi.day07abstractFactory;

import com.mashibing.lianxi.day07abstractFactory.abstractFactory.BaseExplode;

import java.awt.*;

/**
 * @ClassName Bullet
 * @Description: TODO
 * @Author 李淼
 * @Date 2020/6/9
 * @Version V1.0
 **/
public class Explode extends BaseExplode {
    private int x,y;
    public static int width= ResourceMgr.getExplodes()[0].getWidth();
    public static int height= ResourceMgr.getExplodes()[0].getHeight();
    private TankFrame tf =null;
    private boolean living =true;

    //记录当前是爆炸的第几步
    private int step=0;


    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf=tf;

        //通过一个线程来启动
        new Thread(()-> new Audio("audio/explode.wav").play()).start();
    }

    @Override
    public void paint(Graphics g){
        g.drawImage(ResourceMgr.getExplodes()[step++],x,y,null);
        if(step >= ResourceMgr.getExplodes().length) tf.explodes.remove(this);
    }

}

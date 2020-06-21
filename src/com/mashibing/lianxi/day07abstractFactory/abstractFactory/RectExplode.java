package com.mashibing.lianxi.day07abstractFactory.abstractFactory;

import com.mashibing.lianxi.day07abstractFactory.Audio;
import com.mashibing.lianxi.day07abstractFactory.ResourceMgr;
import com.mashibing.lianxi.day07abstractFactory.TankFrame;

import java.awt.*;

/**
 * @ClassName Bullet
 * @Description: TODO
 * @Author 李淼
 * @Date 2020/6/9
 * @Version V1.0
 **/
public class RectExplode extends BaseExplode {
    private int x,y;
    public static int width= ResourceMgr.getExplodes()[0].getWidth();
    public static int height= ResourceMgr.getExplodes()[0].getHeight();
    private TankFrame tf =null;
    private boolean living =true;

    //记录当前是爆炸的第几步
    private int step=0;


    public RectExplode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf=tf;

        //通过一个线程来启动
        new Thread(()-> new Audio("audio/explode.wav").play()).start();
    }

    @Override
    public void paint(Graphics g){
        Color color = g.getColor();
        g.setColor(Color.WHITE);
        g.fillRect(x,y,step*10,step*10);
        step++;
        if(step >= 15) tf.explodes.remove(this);

        g.setColor(color);
    }

}

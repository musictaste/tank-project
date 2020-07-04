package com.mashibing.lianxi.day08FacadeAndMediator;

import java.awt.*;

/**
 * @ClassName Bullet
 * @Description: TODO
 * @Author 李淼
 * @Date 2020/6/9
 * @Version V1.0
 **/
public class Explode extends GameObject{
    private int x,y;
    public static int width= ResourceMgr.getExplodes()[0].getWidth();
    public static int height= ResourceMgr.getExplodes()[0].getHeight();
    private GameModel gameModel =null;
    private boolean living =true;

    //记录当前是爆炸的第几步
    private int step=0;


    public Explode(int x, int y, GameModel gameModel) {
        this.x = x;
        this.y = y;
        this.gameModel=gameModel;

        //通过一个线程来启动
        new Thread(()-> new Audio("audio/explode.wav").play()).start();
    }

    public void paint(Graphics g){
        g.drawImage(ResourceMgr.getExplodes()[step++],x,y,null);
        if(step >= ResourceMgr.getExplodes().length) gameModel.remove(this);
    }

}

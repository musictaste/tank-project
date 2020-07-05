package com.mashibing.lianxi.day09CodeRefactor;

import com.mashibing.lianxi.day09CodeRefactor.collider.ColliderChain;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName GameModel
 * @Description: 单例模式
 * @Author 李淼
 * @Date 2020/7/4
 * @Version V1.0
 **/
public class GameModel {
    private static final GameModel instance = new GameModel();
    static {
        instance.init();
    }

    Tank myTank;
    private List<GameObject> objects = new ArrayList<>();

    private ColliderChain colliderChain = new ColliderChain();

    public static GameModel getInstance(){
        return instance;
    }

    public void add(GameObject go){
        objects.add(go);
    }

    public void remove(GameObject go){
        objects.remove(go);
    }

    //单例的构造方法为private
    private GameModel() {
    }

    private void init(){
        //初始化主战坦克
        myTank =new Tank(200,400, Direction.UP, Group.GOOD);

        //初始化敌方坦克
        int initTankCount = PropertyMgr.getInt("initTankCount");
        for (int i = 0; i < initTankCount; i++) {
            new Tank(200+i*80,200, Direction.DOWN, Group.BAD);
        }

        //初始化墙
        new Wall(150,150,200,50);
        new Wall(550,150,200,50);
        new Wall(300,300,50,200);
        new Wall(550,300,50,200);
    }



    public void paint(Graphics g){
        //存在内存泄漏的问题，因为子弹已经消失了，但是list容器中的数量并没有减少
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        /*g.drawString("子弹的数量："+bullets.size(),10,60);
        g.drawString("敌人的数量："+enemies.size(),10,75);
        g.drawString("爆炸的数量："+explodes.size(),10,90);*/
        g.setColor(c);

        myTank.paint(g);
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).paint(g);
        }

        //互相碰撞
        for (int i = 0; i < objects.size(); i++) {
            for (int j = i+1; j < objects.size(); j++) {
                GameObject o1 = objects.get(i);
                GameObject o2 = objects.get(j);
                /*collider.collide(o1,o2,this);
                tankcollider.collide(o1,o2,this);*/
                colliderChain.collide(o1,o2);
            }

        }

    }

    public Tank getMainTank() {
        return myTank;
    }
}

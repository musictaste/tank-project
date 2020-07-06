package com.mashibing.lianxi.day10Observer.decorator;

import com.mashibing.lianxi.day10Observer.GameObject;

/**
 * @ClassName GameObjectDecorator
 * @Description: TODO
 * @Author 李淼
 * @Date 2020/7/5
 * @Version V1.0
 **/
public abstract class GameObjectDecorator extends GameObject {
    GameObject go;

    public GameObjectDecorator(GameObject go) {
        this.go = go;
    }

    /*@Override
    public void paint(Graphics g) {
        go.paint(g);
    }*/

}

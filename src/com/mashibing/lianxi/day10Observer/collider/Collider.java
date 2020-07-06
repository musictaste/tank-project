package com.mashibing.lianxi.day10Observer.collider;

import com.mashibing.lianxi.day10Observer.GameObject;

/**
 * @ClassName Collider
 * @Description: TODO
 * @Author 李淼
 * @Date 2020/7/4
 * @Version V1.0
 **/
public interface Collider {
    boolean collide(GameObject o1, GameObject o2);
}

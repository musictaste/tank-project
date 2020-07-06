package com.mashibing.lianxi.day10Observer.collider;

import com.mashibing.lianxi.day10Observer.Bullet;
import com.mashibing.lianxi.day10Observer.GameObject;
import com.mashibing.lianxi.day10Observer.Tank;

/**
 * @ClassName BulletTankCollider
 * @Description: TODO
 * @Author 李淼
 * @Date 2020/7/4
 * @Version V1.0
 **/
public class TankTankCollider implements Collider {
    /**
     * @MethodName: collideWith
     * @Description: 子弹和坦克碰撞
     **/
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Bullet && o2 instanceof Tank){
            Tank tank1 = (Tank) o1;
            Tank tank2 = (Tank)o2;

            //在坦克碰撞之前进行判断
            //如果两个坦克碰撞，让坦克回到原先的位置
            if(tank1.rect.intersects(tank2.rect)){
                tank1.back();
                tank2.back();
            }
        }
        return true;
    }
}

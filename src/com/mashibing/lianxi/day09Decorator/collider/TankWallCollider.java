package com.mashibing.lianxi.day09Decorator.collider;

import com.mashibing.lianxi.day09Decorator.GameObject;
import com.mashibing.lianxi.day09Decorator.Tank;
import com.mashibing.lianxi.day09Decorator.Wall;

/**
 * @ClassName BulletTankCollider
 * @Description: TODO
 * @Author 李淼
 * @Date 2020/7/4
 * @Version V1.0
 **/
public class TankWallCollider implements Collider {
    /**
     * @MethodName: collideWith
     * @Description: 坦克和墙碰撞
     **/
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Wall && o2 instanceof Tank){
            Wall wall = (Wall) o1;
            Tank tank = (Tank)o2;

            if( wall.rect.intersects(tank.rect) ) {
                tank.back();
            }
        }else if(o1 instanceof Tank && o2 instanceof Wall){
            return collide(o2,o1);
        }
        return true;
    }
}

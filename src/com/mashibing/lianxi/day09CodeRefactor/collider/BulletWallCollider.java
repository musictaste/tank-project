package com.mashibing.lianxi.day09CodeRefactor.collider;

import com.mashibing.lianxi.day09CodeRefactor.*;

/**
 * @ClassName BulletTankCollider
 * @Description: TODO
 * @Author 李淼
 * @Date 2020/7/4
 * @Version V1.0
 **/
public class BulletWallCollider implements Collider {
    /**
     * @MethodName: collideWith
     * @Description: 子弹和墙碰撞
     **/
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
       if (o1 instanceof Bullet && o2 instanceof Wall) {
            Bullet bullet = (Bullet) o1;
            Wall wall = (Wall) o2;
            if (bullet.rect.intersects(wall.rect)) {
                bullet.die();
                //子弹消失以后，墙还需要继续进行碰撞检测，所以没有返回值true或false
            }
        } else if (o1 instanceof Wall && o2 instanceof Bullet) {
            return collide(o2, o1);
        }
        return true;
    }
}
package com.mashibing.lianxi.day09Decorator.collider;

import com.mashibing.lianxi.day09Decorator.Bullet;
import com.mashibing.lianxi.day09Decorator.Explode;
import com.mashibing.lianxi.day09Decorator.GameObject;
import com.mashibing.lianxi.day09Decorator.Tank;

/**
 * @ClassName BulletTankCollider
 * @Description: TODO
 * @Author 李淼
 * @Date 2020/7/4
 * @Version V1.0
 **/
public class BulletTankCollider implements Collider {
    /**
     * @MethodName: collideWith
     * @Description: 子弹和坦克碰撞
     **/
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Bullet && o2 instanceof Tank){
            Bullet bullet = (Bullet) o1;
            Tank tank = (Tank)o2;

            if(bullet.group==tank.getGroup()) return true;
            //用一个rect来记录子弹的位置，避免不停的创建Rectangle对象
            if( bullet.rect.intersects(tank.rect) ) {
                bullet.die();
                tank.die();

                //爆炸现在在中心位置
                int explodeX = tank.getX() + Tank.width / 2 - Bullet.width / 2;
                int explodeY = tank.getY() + Tank.height / 2 - Bullet.height / 2;
                new Explode(explodeX, explodeY);

                return false;
            }
        }else if(o1 instanceof Tank && o2 instanceof Bullet){
            return collide(o2,o1);
        }
        return true;
    }
}

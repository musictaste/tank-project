package com.mashibing.lianxi.day08FacadeAndMediator.collider;

import com.mashibing.lianxi.day08FacadeAndMediator.*;

import java.awt.*;

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
    public boolean collide(GameObject o1, GameObject o2, GameModel gameModel) {
        if(o1 instanceof Bullet && o2 instanceof Tank){
            Bullet bullet = (Bullet) o1;
            Tank tank = (Tank)o2;

            if(bullet.group==tank.getGroup()) return false;
            //用一个rect来记录子弹的位置，避免不停的创建Rectangle对象
            if( bullet.rect.intersects(tank.rect) ) {
                bullet.die();
                tank.die();

                //爆炸现在在中心位置
                int explodeX = tank.getX() + Tank.width / 2 - Bullet.width / 2;
                int explodeY = tank.getY() + Tank.height / 2 - Bullet.height / 2;

                gameModel.add(new Explode(explodeX, explodeY, gameModel));
                return true;
            }
            return false;
        }else if(o1 instanceof Tank && o2 instanceof Bullet){
            return collide(o2,o1,gameModel);
        }else {
            return false;
        }
    }
}
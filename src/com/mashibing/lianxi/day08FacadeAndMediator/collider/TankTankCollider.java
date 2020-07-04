package com.mashibing.lianxi.day08FacadeAndMediator.collider;

import com.mashibing.lianxi.day08FacadeAndMediator.*;

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
    public boolean collide(GameObject o1, GameObject o2, GameModel gameModel) {
        if(o1 instanceof Bullet && o2 instanceof Tank){
            Tank tank1 = (Tank) o1;
            Tank tank2 = (Tank)o2;

            //在坦克碰撞之前进行判断
            if(tank1.rect.intersects(tank2.rect)){
                //如果两个坦克碰撞，让坦克回到原先的位置
                tank1.setX(tank1.getOldX());
                tank1.setY(tank1.getOldY());

                tank2.setX(tank1.getOldX());
                tank2.setY(tank1.getOldY());
            }
        }
        return true;
    }
}

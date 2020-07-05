package com.mashibing.lianxi.day09CodeRefactor.collider;

import com.mashibing.lianxi.day09CodeRefactor.GameModel;
import com.mashibing.lianxi.day09CodeRefactor.GameObject;
import com.mashibing.lianxi.day09CodeRefactor.PropertyMgr;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName CollierChain
 * @Description: TODO
 * @Author 李淼
 * @Date 2020/7/4
 * @Version V1.0
 **/
public class ColliderChain implements Collider {
    private List<Collider> colliders = new LinkedList<>();

    public ColliderChain() {
        /*colliders.add(new BulletTankCollider());
        colliders.add(new TankTankCollider());
        colliders.add(new BulletWallCollider());*/
        colliders =(List<Collider>) PropertyMgr.getColliders("colliders");
    }

    public void add(Collider collider){
        colliders.add(collider);
    }

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        for (int i = 0; i < colliders.size(); i++) {
            if(!colliders.get(i).collide(o1,o2)){
                return false;
            }
        }

        return true;
    }
}

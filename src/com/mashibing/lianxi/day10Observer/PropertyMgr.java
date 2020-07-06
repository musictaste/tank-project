package com.mashibing.lianxi.day10Observer;

import com.mashibing.lianxi.day10Observer.collider.Collider;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 * @ClassName PropertyMgr
 * @Description: TODO
 * @Author 李淼
 * @Date 2020/6/16
 * @Version V1.0
 **/
public class PropertyMgr {
    private static Properties pros = new Properties();

    static {
        try {
            pros.load(PropertyMgr.class.getClassLoader().getResourceAsStream("com/mashibing/lianxi/day10Observer/config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //构造方法为private时，就是一个简单实用的单例模式
    private PropertyMgr(){}

    public static Object get(String key){
        if(pros==null) return null;
        return pros.get(key);
    }

    public static List<Collider> getColliders(String key){
        if(pros==null) return null;
        List<Collider> colliders = new LinkedList<>();
        String string = (String)pros.get(key);
        String[] list = string.split(",");
        for(String className:list){
            Collider c = null;
            try {
                c = (Collider) Class.forName(className).getDeclaredConstructor().newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            colliders.add(c);
        }

//        System.out.println(ToStringBuilder.reflectionToString(colliders));
        return colliders;
    }

    public static int getInt(String key){
        if (pros==null) return 0;
        return Integer.valueOf((String)pros.get(key));
    }

    public static void main(String[] args) {
//        System.out.println(PropertyMgr.get("initTankCount"));
//        System.out.println(PropertyMgr.getInt("gameWidth"));
        System.out.println(PropertyMgr.getColliders("colliders"));
    }
}

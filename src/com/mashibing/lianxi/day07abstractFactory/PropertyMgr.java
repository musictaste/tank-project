package com.mashibing.lianxi.day07abstractFactory;

import java.io.IOException;
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
            pros.load(PropertyMgr.class.getClassLoader().getResourceAsStream("com/mashibing/lianxi/day06Strategy/config"));
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

    public static int getInt(String key){
        if (pros==null) return 0;
        return Integer.valueOf((String)pros.get(key));
    }

    public static void main(String[] args) {
        System.out.println(PropertyMgr.get("initTankCount"));
        System.out.println(PropertyMgr.getInt("gameWidth"));
    }
}

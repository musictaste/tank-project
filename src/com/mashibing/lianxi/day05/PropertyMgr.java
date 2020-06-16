package com.mashibing.lianxi.day05;

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
            pros.load(PropertyMgr.class.getClassLoader().getResourceAsStream("com/mashibing/lianxi/day04/config"));
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

    public static void main(String[] args) {
        System.out.println(PropertyMgr.get("initTankCount"));
    }
}

package com.mashibing.lianxi.day04;

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
    static Properties pros = new Properties();

    static {
        try {
            pros.load(PropertyMgr.class.getClassLoader().getResourceAsStream("com/mashibing/lianxi/day04/config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key){
        if(pros==null) return null;
        return pros.get(key);
    }

    public static void main(String[] args) {
        System.out.println(PropertyMgr.get("initTankCount"));
    }
}

package com.mashibing.lianxi.day01;


/**
 * @ClassName T02
 * @Description: TODO
 * @Author 李淼
 * @Date 2020/6/9
 * @Version V1.0
 **/
public class T02 {
    public static void main(String[] args) throws InterruptedException {
        TankFrame02 tf = new TankFrame02();
        while (true){
            Thread.sleep(50);
            tf.repaint();
        }
    }
}

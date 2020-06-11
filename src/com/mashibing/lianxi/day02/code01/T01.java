package com.mashibing.lianxi.day02.code01;


/**
 * @ClassName T02
 * @Description: TODO
 * @Author 李淼
 * @Date 2020/6/9
 * @Version V1.0
 **/
public class T01 {
    public static void main(String[] args) throws InterruptedException {
        TankFrame01 tf = new TankFrame01();
        //下面的线程必须有，让窗口重新渲染
       while (true){
            Thread.sleep(50);
            tf.repaint();
        }
    }
}

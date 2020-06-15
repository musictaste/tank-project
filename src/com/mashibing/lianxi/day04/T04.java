package com.mashibing.lianxi.day04;


/**
 * @ClassName T02
 * @Description: TODO
 * @Author 李淼
 * @Date 2020/6/9
 * @Version V1.0
 **/
public class T04 {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();
        for (int i = 0; i < 5; i++) {
            tf.enemies.add(new Tank(200+i*50,200, Direction.DOWN, Group.BAD,tf));
        }

        //背景音乐
        new Thread(()-> new Audio("audio/war1.wav").loop()).start();

        //下面的线程必须有，让窗口重新渲染
       while (true){
            Thread.sleep(25);

            //repaint 调用 TankFrame的update()
            tf.repaint();
        }
    }
}

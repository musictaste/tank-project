package com.mashibing.lianxi.day06Strategy;


/**
 * @ClassName T02
 * @Description: TODO
 * @Author 李淼
 * @Date 2020/6/9
 * @Version V1.0
 **/
public class T06 {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();
        int initTankCount = PropertyMgr.getInt("initTankCount");
        for (int i = 0; i < initTankCount; i++) {
            tf.enemies.add(new Tank(200+i*80,200, Direction.DOWN, Group.BAD,tf));
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

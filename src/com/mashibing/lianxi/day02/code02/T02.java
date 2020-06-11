package com.mashibing.lianxi.day02.code02;


/**
 * @ClassName T02
 * @Description: TODO
 * @Author 李淼
 * @Date 2020/6/9
 * @Version V1.0
 **/
public class T02 {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();
        //下面的线程必须有，让窗口重新渲染
       while (true){
            Thread.sleep(50);

            //repaint 调用 TankFrame的update()
            tf.repaint();
        }
    }
}

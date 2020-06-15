package com.mashibing.lianxi.day04;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @ClassName ResourceMgr
 * @Description: 资源文件
 * @Author 李淼
 * @Date 2020/6/11
 * @Version V1.0
 **/
public class ResourceMgr {
    //坦克的方向图片
    public static BufferedImage tankL,tankR,tankU,tankD;

    //子弹的方向图片
    public static BufferedImage bulletL,bulletR,bulletU,bulletD;

    //爆炸的图片
    public static BufferedImage[] explodes=new BufferedImage[16];

    static{
        try {
            tankU= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            tankL= ImageUtil.rotateImage(tankU,-90);
            tankR= ImageUtil.rotateImage(tankU,90);
            tankD= ImageUtil.rotateImage(tankU,180);

            bulletU= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
            bulletL= ImageUtil.rotateImage(bulletU,-90);
            bulletR= ImageUtil.rotateImage(bulletU,90);
            bulletD= ImageUtil.rotateImage(bulletU,180);

            for (int i = 0; i < 16; i++) {
                explodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e"+(i+1)+".gif"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.mashibing.lianxi.day10Observer;

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
    private static BufferedImage goodTankL,goodTankR,goodTankU,goodTankD;
    private static BufferedImage badTankL,badTankR,badTankU,badTankD;

    //子弹的方向图片
    private static BufferedImage bulletL,bulletR,bulletU,bulletD;

    //爆炸的图片
    private static BufferedImage[] explodes=new BufferedImage[16];

    static{
        try {
            goodTankU= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            goodTankL= ImageUtil.rotateImage(goodTankU,-90);
            goodTankR= ImageUtil.rotateImage(goodTankU,90);
            goodTankD= ImageUtil.rotateImage(goodTankU,180);

            badTankU= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            badTankL= ImageUtil.rotateImage(badTankU,-90);
            badTankR= ImageUtil.rotateImage(badTankU,90);
            badTankD= ImageUtil.rotateImage(badTankU,180);

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

    //单例模式的关键就是：构造方法是private的
    private ResourceMgr(){}

    public static BufferedImage getGoodTankL(){
        return goodTankL;
    }

    public static BufferedImage getGoodTankR() {
        return goodTankR;
    }

    public static BufferedImage getGoodTankU() {
        return goodTankU;
    }

    public static BufferedImage getGoodTankD() {
        return goodTankD;
    }

    public static BufferedImage getBadTankL() {
        return badTankL;
    }

    public static BufferedImage getBadTankR() {
        return badTankR;
    }

    public static BufferedImage getBadTankU() {
        return badTankU;
    }

    public static BufferedImage getBadTankD() {
        return badTankD;
    }

    public static BufferedImage getBulletL() {
        return bulletL;
    }

    public static BufferedImage getBulletR() {
        return bulletR;
    }

    public static BufferedImage getBulletU() {
        return bulletU;
    }

    public static BufferedImage getBulletD() {
        return bulletD;
    }

    public static BufferedImage[] getExplodes() {
        return explodes;
    }
}

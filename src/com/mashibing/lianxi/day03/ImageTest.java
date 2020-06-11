package com.mashibing.lianxi.day03;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ImageTest {
    @Test
    void test(){
        try {
            //BufferedImage 是load到内存中
            BufferedImage image = ImageIO.read(new File("D:/ideaWorkspace/mashibing/tank-project/src/images/bulletD.gif"));
            assertNotNull(image);

            BufferedImage image2 = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
//            BufferedImage image2 = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/bulletD.gif"));
            assertNotNull(image2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
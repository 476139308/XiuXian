package com.yj.xiuxian.panel.fulu;

import com.github.romankh3.image.comparison.ImageComparison;
import com.github.romankh3.image.comparison.ImageComparisonUtil;
import com.github.romankh3.image.comparison.model.ImageComparisonResult;

import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/9/4 11:23
 */

public class ImageCompare {

    public static void main(String[] args) {
        //load images to be compared:
        BufferedImage expectedImage = ImageComparisonUtil.readImageFromResources("C:\\Users\\yujin\\Desktop\\temp\\Snipaste_2023-09-04_10-04-09.png");
        BufferedImage actualImage = ImageComparisonUtil.readImageFromResources("C:\\Users\\yujin\\Desktop\\temp\\Snipaste_2023-09-04_10-04-46.png");

        //load images to be compared:

        // where to save the result (leave null if you want to see the result in the UI)
        File resultDestination = new File( "C:\\Users\\yujin\\Desktop\\temp\\result1.png" );

        //Create ImageComparison object with result destination and compare the images.
        ImageComparisonResult imageComparisonResult = new ImageComparison(expectedImage, actualImage, resultDestination).compareImages();
    }

}

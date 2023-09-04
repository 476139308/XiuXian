package com.yj.xiuxian.jingyan;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/9/4 13:50
 */
@AllArgsConstructor
@Data
public class Experience {
    private Integer qualification = 100;

    private Integer exerciseYear = 1;

    private Double exerciseDifficulty = 1D;

    private Integer modifyValue = 0;


    public Double getTotalExperience() {
        double result = qualification * exerciseYear * exerciseDifficulty + modifyValue;

        System.out.println("result = " + result);

        return result;
    }

    public List<Double> getDivideExperience(double totalExperience, int divide) {
        int startMultiply = 1;
        int mediumMultiply = 2;
        int endMultiply = 3;

        ArrayList<Double> experienceList = new ArrayList<>();
        if (divide == 9) {
            double baseExperience = totalExperience / (3 * (startMultiply + mediumMultiply + endMultiply));
            experienceList.add(baseExperience);
            experienceList.add(baseExperience);
            experienceList.add(baseExperience);

            experienceList.add(baseExperience * mediumMultiply);
            experienceList.add(baseExperience * mediumMultiply);
            experienceList.add(baseExperience * mediumMultiply);

            experienceList.add(baseExperience * endMultiply);
            experienceList.add(baseExperience * endMultiply);
            experienceList.add(baseExperience * endMultiply);
        }

        if (divide == 3) {
            double baseExperience = totalExperience / (startMultiply + mediumMultiply + endMultiply);
            experienceList.add(baseExperience);
            experienceList.add(baseExperience * mediumMultiply);
            experienceList.add(baseExperience * endMultiply);
        }

        return experienceList;
    }

    public static void main(String[] args) {
        Experience lianqi = new Experience(100, 45, 1D, 0);
        List<Double> lianqiExperience = lianqi.getDivideExperience(lianqi.getTotalExperience(), 9);
        System.out.println("练气期 =               " + lianqiExperience);

        Experience zhuji = new Experience(100, 180, 2D, 0);
        List<Double> zhujiExperience = zhuji.getDivideExperience(zhuji.getTotalExperience(), 3);
        System.out.println("筑基期 =               " + zhujiExperience);

        Experience jindan = new Experience(100, 240, 5D, 0);
        List<Double> jindanExperience = jindan.getDivideExperience(jindan.getTotalExperience(), 3);
        System.out.println("金丹期 =               " + jindanExperience);

        Experience yuanying = new Experience(100, 480, 10D, 0);
        List<Double> yuanyingExperience = yuanying.getDivideExperience(yuanying.getTotalExperience(), 3);
        System.out.println("元婴期 =               " + yuanyingExperience);


        Experience huashen = new Experience(100, 1500, 100D, 0);
        List<Double> huashenExperience = huashen.getDivideExperience(huashen.getTotalExperience(), 3);
        System.out.println("化神期 =               " + huashenExperience);
    }


}

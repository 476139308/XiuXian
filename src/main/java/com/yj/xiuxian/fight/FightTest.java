package com.yj.xiuxian.fight;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/9/4 15:25
 */
public class FightTest {

    public static void main(String[] args) {
//        battleCalculate();
//    预计5回合结束战斗，采用乘法伤害计算，测试一下乘法伤害的一些计算数值
//    伤害减免率 = 防御 ÷ （防御 + 常数1 x 角色等级 + 常数2）
//    伤害 = 攻击 x（1 - 伤害减免率）

        testBattleValue();


    }

    private static void testBattleValue() {
        int rounds = 5;
        int health = 500;

        int attack = 200;
        int defend = 100;
        int value1 = 10;
        int value2 = 100;

        int level = 1;

        double defendPercentage = BigDecimal.valueOf(defend).divide(BigDecimal.valueOf(defend + value1 * level + value2), 2, RoundingMode.CEILING).doubleValue();
        int damage = (int) (attack * (1 - defendPercentage));
        System.out.println("damage = " + damage);

        double realRounds = (double) health / damage;


        System.out.println("realRounds = " + realRounds);
    }

    private static void battleCalculate() {
        int health = 500;
        int defend = 50;
        int attack = 100;
        Fight player = new Fight(attack, defend, health);

//        Fight enemy = player.generateByOdds(65, 80, 70);
//        Fight enemy = player.generateByOdds(65, 80, 70);
//        Fight enemy = player.generateByOdds(80, 100, 80);
        Fight enemy = player.generateByOdds(100, 100, 150);

        int count = 0;

        while (enemy.isAlive() && player.isAlive()) {
            player.damage(enemy);
            if (enemy.isAlive()) {
                enemy.damage(player);
            }
            count++;
        }

        System.out.println("player = " + player);
        System.out.println("enemy = " + enemy);

        if (player.isAlive()) {
            System.out.println("受伤比例 ： " + (double) player.getHealth() / health * 100);
            System.out.println("战斗总计回合数 = " + count);
        }
    }


}

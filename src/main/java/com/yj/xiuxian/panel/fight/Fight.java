package com.yj.xiuxian.panel.fight;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/9/4 15:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fight {

    private Integer attack;

    private Integer defend;

    private Integer health;


    public void damage(Fight fight) {
        fight.setHealth(fight.health - this.attack - fight.defend);
    }

    //    伤害减免率 = 防御 ÷ （防御 + 常数1 x 角色等级 + 常数2）
//    伤害 = 攻击 x（1 - 伤害减免率）
    public void damageByReal(Fight fight) {
        double defendPercentage = BigDecimal.valueOf(fight.getDefend()).divide(BigDecimal.valueOf(fight.getDefend() + 100), 2, RoundingMode.CEILING).doubleValue();
        int damage = (int) (this.getAttack() * (1 - defendPercentage));
        fight.setHealth(fight.health - this.attack - fight.defend);
    }

    public void damageByDivide(Fight fight) {
        fight.setHealth(fight.health - this.attack - fight.defend);
    }


    public boolean isAlive() {
        return this.health > 0;
    }


    public Fight generateByOdds(double attackPercentage, double defendPercentage, double healthPercentage) {
        Fight fight = new Fight();
        fight.setAttack((int) (attackPercentage * this.getAttack() / 100));
        fight.setDefend((int) (defendPercentage * this.getDefend() / 100));
        fight.setHealth((int) (healthPercentage * this.getHealth() / 100));

        return fight;
    }

}

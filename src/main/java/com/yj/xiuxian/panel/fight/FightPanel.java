package com.yj.xiuxian.panel.fight;

import com.yj.xiuxian.entity.BaseEntity;
import lombok.Data;

import java.util.List;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/9/4 18:39
 */
@Data
public class FightPanel extends BaseEntity {
    //            ### 一级属性
//    武器攻击强度：
    private Double weaponAttack;
    //    术法攻击强度：
    private Double magicArtsAttack;
    //    灵气值：
    private Double lingQiValue;
    //    生命值：
    private Double health;
    //
//    神识值：
    private Double shenShiValue;
    //    神识强度：
    private Double shenShiAttack;
    //    攻击速度：
    private Double attackSpeed;
    // ### 二级属性
//
//            武器攻击加成
    private Double weaponAttackBonus;
    //    术法攻击加成
    private Double magicArtsAttackBonus;

    //    护盾强度加成
    private Double shieldStrengthBonus;
    //            身体强度加成
    private Double bodyStrengthBonus;

    //            神识攻击加成
    private Double shenShiAttackBonus;
    //    神识防御加成
    private Double shenShiShieldBonus;
    //            灵气回复速度
    private Double lingQiRecoverySpeed;
    //    受伤程度：战斗前伤势固定，然后战斗时可能会添加伤势，当生命值改变的时候发生变化
    private Double injuryExtent;

    //    伤势列表：显示当前所有伤势
    private List<Disease> diseaseList;

}

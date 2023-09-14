package com.yj.xiuxian.panel.man;

import com.yj.xiuxian.backpack.Backpack;
import com.yj.xiuxian.entity.BaseEntity;
import com.yj.xiuxian.panel.experienct.ExperiencePanel;
import com.yj.xiuxian.panel.fight.FightPanel;
import com.yj.xiuxian.panel.production.ProductionPanel;
import com.yj.xiuxian.panel.skill.SkillPanel;
import com.yj.xiuxian.panel.zhuangbei.ZhuangBeiPanel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/9/4 18:03
 * 基本信息：
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CharacterPanel extends BaseEntity {
    //    姓名
    private String name;
    //            年龄
    private LocalDate birthday;
    //    剩余寿元
    private LocalDate deadDate;

    //    移动速度：
    private Double moveSpeed;

    //    御器速度
    private Double experienceSpeed;

    //    修炼相关属性
    private ExperiencePanel experiencePanel;

    //    战斗相关数据
    private FightPanel fightProperty;

    //    生产相关数据
    private ProductionPanel productionPanel;

    private SkillPanel skillPanel;

    private ZhuangBeiPanel zhuangBeiPanel;

    private Backpack backpack;

}

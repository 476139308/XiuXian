package com.yj.xiuxian.panel.skill;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/8/31 15:51
 *      种田： 种植          产量          0.3
 *      炼丹： 炼制丹药       速度           0.5
 *
 */
@Data
public class SkillAddition {
    //    关联到人物面板的具体大类，如种植等
    private String additionKey;
    //    关联到人物面板生成的具体面板的具体项目，如产量，速度，回复速度，修炼速度等具体字段
    private String additionalDirection;
    //关联到面板的具体数值，如种田增加产量
    private BigDecimal additionValue;

    private Boolean selected = true;


    public SkillAddition(String additionKey, String additionalDirection, BigDecimal additionValue) {
        this.additionKey = additionKey;
        this.additionalDirection = additionalDirection;
        this.additionValue = additionValue;
    }

    public SkillAddition(String additionKey, String additionalDirection, BigDecimal additionValue, Boolean selected) {
        this.additionKey = additionKey;
        this.additionalDirection = additionalDirection;
        this.additionValue = additionValue;
        this.selected = selected;
    }
}

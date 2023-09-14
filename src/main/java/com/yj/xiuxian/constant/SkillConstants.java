package com.yj.xiuxian.constant;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/8/31 14:17
 */
public abstract class SkillConstants {
    //    技能槽的状态
    public static final Integer CLOSED_SKILL_SLOT = 0;
    public static final Integer OPENED_SKILL_SLOT = 1;
    public static final Integer OCCUPY_SKILL_SLOT = 2;

    //    状态
    public static final Integer DISABLE = 0;
    public static final Integer ENABLE = 1;


    //    技能类型
    public static final String LIFE_SKILL_TYPE = "生活技艺";
    public static final String PRACTICE_SKILL_TYPE = "修炼技艺";
    public static final String FIGHT_SKILL_TYPE = "战斗技艺";
    public static final String OTHER_SKILL_TYPE = "其他技艺";

    //    技能等级
    public static final Integer BASE_ORDER = 0;
    public static final Integer FIRST_ORDER = 1;
    public static final Integer SECOND_ORDER = 2;
    public static final Integer THIRD_ORDER = 3;
    public static final Integer FOURTH_ORDER = 4;
    public static final Integer FIFTH_ORDER = 5;

    //    技能效果关键字
    public static final String PLANT = "种植";
    public static final String PRODUCE = "制造";

    //    技能效果生效目标关键字
    public static final String SPEED = "速度";
    public static final String GROWTH_SPEED = "生长速度";
    public static final String PRODUCTION = "产量";


    private SkillConstants() {
    }
}

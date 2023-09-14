package com.yj.xiuxian.constant;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/8/31 14:17
 */
public abstract class BackpackConstants {
    //    装备槽的状态
    public static final Integer CLOSED_BACKPACK_SLOT = 0;
    public static final Integer OPENED_BACKPACK_SLOT = 1;
    public static final Integer OCCUPY_BACKPACK_SLOT = 2;

    //    主类型
    public static final Integer MATERIAL = 1;
    public static final Integer EQUIPMENT = 2;
    public static final Integer KNOWLEDGE = 3;
    public static final Integer CREATURE = 4;
    public static final Integer USABLE = 5;
    public static final Integer OTHER = 9;

    //    副类型( ((主类型序列号 + 1或10或100 )*10) > 副类型的id序列  >（主类型序列号 * 10） )
    public static final Integer HERBS = 11;
    public static final Integer MINERAL = 12;
    public static final Integer ATTACK = 21;
    public static final Integer DEFEND = 22;


    private BackpackConstants() {
    }
}

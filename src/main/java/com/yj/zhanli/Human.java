package com.yj.zhanli;

import lombok.Data;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/9/8 12:30
 */
@Data
public class Human {

    //    基础属性
    private Integer attack;
    private Integer health;
    private Integer defend;
    private Integer minjie;

    //    战斗属性  ,击晕，暴击，连击，闪避，反击，吸血
    private Double jiyun;
    private Double baoji;
    private Double lianji;
    private Double shanbi;
    private Double fanji;
    private Double xixue;


//    战斗抗性：抗击晕，暴击，连击，闪避，反击，吸血

//    特殊属性 ：最终增伤，最终减伤，
//    强化    爆伤，治疗，灵兽，道法
//    弱化
//    无视    战斗属性，战斗抗性
//    格挡    抗格挡 破甲  抗破甲
}

package com.yj.xiuxian.panel;

import com.yj.xiuxian.panel.skill.SkillBar;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/8/31 12:55
 */
@Data
public class ShenQiPanel {
    //    转生之书（神器名），下面会标注颜色，是对于一些属性的初步重要度思考
    private String name;
    //    神器耐久（神器页数）考虑限制最大转生次数等，高难度可能会比较低，考虑是否有条件获取吧
    private Integer durability;

    //    寿命（预期寿命/寿命上限）当前寿命
    private Integer liftExpectancy;
    private Integer liftMaxLimit;
    private Integer currentLifetimeLimit;
    private Integer lifetime;
    //    命格（命格等级，命格介绍）
    private MingGe mingGe;

    //    灵根（属性，纯度，完整度）
    private List<LingGen> lingGenList;
    //    考虑不同的流派，五行灵根流派，单属性天灵根流派，主副灵根辅助流派
    //    灵魂（等级，特殊）
    //    灵魂存在强度等级，影响修仙者的神识强度，神识上限等
    //    灵魂存在天赋，拥有一些特殊效果，如大日神魂，神识附带炎属性，增强伤害，但降低隐蔽性
    private List<Soul> soul;
    //    体质（等级，天赋）
    //    体质存在等级，影响战斗，修行等方面
    //    体质存在天赋，拥有特殊效果，如天生道体，提高修为提升速度，限定修为提升下限
    private List<Constitution> body;

    private List<Talent> talent;
    //            天赋
    //    可能存在多个天赋，增强除了灵魂天赋，体质天赋之外的，更多跟悟性相关
    //    天赋获取方法待定，
    //    可以考虑长时间接触了某一项事情以后，在随后的转生过程中会携带出来
    //            技艺槽
    //    技艺槽用来放可以提升的技艺等，包括但不限于：功法，技能，种田等技艺
    //    技艺槽有等级之分，低等技艺可以放在高等技艺槽内提高熟练度提升速度、增加加成选项、异变可能性。技艺槽最多只可跨一等级修行高等级技艺，且会降低技艺修炼速度。
    //    技艺槽有数量限制，初始只有2个基础技艺槽，后期可以通过转生天赋点数增加槽位数量及技艺槽等级
    //    技艺槽修炼期间不可拆卸，只有在转生时才会清空技艺槽，或者技艺修炼到达等级上限时自动追加到技艺栏
    private SkillBar skillBar;
    //            技艺列表
    //    已经修炼完成的技艺
    //            刚刚开始修行被技艺烂承认的技艺
    //    以往转生时修行的技艺，但是未修炼完成的技艺

    @Data
    class LingGen {
        private String attribute;
        private BigDecimal purity;
        private BigDecimal proportion;
    }

    @Data
    class Soul {
        private BigDecimal strength;

        private String genius;
    }

    @Data
    class Constitution {
        private BigDecimal strength;

        private String genius;

    }

    @Data
    class Talent {
        private String name;

        private List<Addition> additionList;
    }

}

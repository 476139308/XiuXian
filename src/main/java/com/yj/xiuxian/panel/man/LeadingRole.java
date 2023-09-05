package com.yj.xiuxian.panel.man;

import lombok.Data;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/8/31 23:12
 * 人物属性信息
 * 基本信息：
 * <p>
 * 生成的属性：
 * 基本属性：温度，基础工作这些
 * <p>
 * 修炼属性：
 * <p>
 * 生产属性：
 * <p>
 * 战斗属性：
 * <p>
 * 其他属性：
 */
@Data
public class LeadingRole {
    private String name;

    private Integer age;

    private Integer lifetime;

    private BaseAttribute baseAttribute;

    @Data
    class BaseAttribute {

    }

    @Data
    class PracticeAttribute {

    }

    @Data
    class ProduceAttribute {

    }


    @Data
    class FightAttribute {

    }

    @Data
    class OtherAttribute {

    }

}

package com.yj.xiuxian.backpack;

import lombok.Data;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/9/14 10:19
 * 物品模板：也就可以认为是excel表格，这种表现形式
 * 里面放物品的基本信息
 * 游戏中根据物品的模板生成实际的物品
 * id
 * <p>
 * 名称
 * <p>
 * 主类型
 * <p>
 * 副类型
 * <p>
 * 是否可堆叠
 * <p>
 * 堆叠上限
 * <p>
 * 描述
 * <p>
 * 基础品阶
 * <p>
 * 是否有耐久度
 * <p>
 * 最大耐久度
 * <p>
 * 是否可修复
 * <p>
 * 耐久度消耗方式：时间，战斗，操作使用
 */
@Data
public class BackpackItemTemplate {
    //    id
    private Integer id;

    //	名称
    private String name;

    //	主类型
    private Integer mainType;

    //	副类型
    private Integer subType;
    //	是否可堆叠
    private Boolean stackable;
    //	堆叠上限
    private Integer stackUpperLimit;
    //	描述
    private String description;
    //	品阶
    private Integer level;
    //	是否有耐久度
    private Boolean durable;
    //	最大耐久度
    private Integer maxDurability;
    //	是否可修复
    private Boolean repairable;
    //	耐久度消耗方式：时间，战斗，操作使用
    private String durableConsumeType;

    private Integer value;
}

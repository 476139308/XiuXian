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
 */
@Data
public class BackpackItem {
    private Integer id;

    private String name;

    private Integer currentStack;

    private Integer currentDurability;

    //    计算出来的数值，根据物品的基础价值 * 价值影响因素比例，做动态交易系统需要
    private Integer currentValue;

    private String description;

    private BackpackItemTemplate backpackItemTemplate;


}

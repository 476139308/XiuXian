package com.yj.xiuxian.panel;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/8/31 13:00
 * 命格区分：这里的命格狭义的理解为人物在当前世界的地位等，
 * <p>
 * 命格等级决定了当前人物在当前生存环境的顺利程度，如增加收获，事事顺心，家庭和睦，修为稳固提升等，
 * <p>
 * 命格颜色：命格存在颜色之分，黑色，灰色，白色，黄色，红色，青色，紫色
 * 赤橙黄绿青蓝紫
 * 蜉蝣，众生，超凡，
 * 蜉蝣，云雀，蛇蟒，蛟龙，真龙，大道之子
 */
@Data
@AllArgsConstructor
public class MingGe {
    private String name;

    private Integer level;

    private String description;

    private String effect;


    public static void register() {
        ArrayList<MingGe> mingGeArrayList = new ArrayList<>();
        mingGeArrayList.add(new MingGe("蜉蝣", 0, "最渺小的命格,有实力的时候也有影响，无实力的时候命运发展会由于压制等原因向坏处发展", ""));
        mingGeArrayList.add(new MingGe("众生", 1, "世间最普遍的命格,有实力的时候无影响，无实力的时候能够一定程度上控制自身命格", ""));
        mingGeArrayList.add(new MingGe("超凡", 2, "较稀少命格，众生中百里挑一,算是修仙之才得第一档命格", ""));
        mingGeArrayList.add(new MingGe("仙材", 3, "超凡中万里挑一的命格,大概率命格在金丹期前不会有所影响", ""));
        mingGeArrayList.add(new MingGe("主角", 3, "仙才中万里挑一的命格，几乎注定能够做出一番成就来", ""));
        mingGeArrayList.add(new MingGe("大道之子", 4, "一个星球上才可能出现那么一两个，几乎能够保证命格满足大道这个星球最高修为之前不会受到其他影响", ""));

        Map<String, MingGe> mingGeMap = mingGeArrayList.stream().collect(Collectors.toMap(MingGe::getName, mingGe -> mingGe));
        GeneralManage.registerMingGe(mingGeMap);
    }


}

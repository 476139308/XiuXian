package com.yj.xiuxian.task;

import lombok.Data;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/9/1 15:20
 *      任务系统设计
 *          通过前期设计，确定好归类，后期只需要进行简单配置即可生成相应的任务
 *          id：全局唯一
 *          name：任务名称
 *          limit:  任务接受要求
 *          mainType:主要类型   主线  支线  重复  每日  成就
 *          subType:  子类型   对话  收集  杀怪
 *          target：   对话目标  收集目标    杀怪目标
 *          reward： 任务奖励    修为  灵石  物品
 *          nextTaskId: 下一个任务的Id
 *          completed: 是否完成，可以考虑替换成任务当前进度
 *          sign：   是否标记，做一些特殊底色，提供简略任务信息展示
 *       对话系统：
 *          id：所属的任务id
 *          Type：NPC对话，Npc与玩家互动对话
 *          content:
 *
 *
 */
@Data
public class TaskMain {
    private String id;
    private String name;

    private String mainType;


    private String subType;

//    private  reward;




}

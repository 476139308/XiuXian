package com.yj.xiuxian.task.communicate;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/9/1 16:19
 */
@Getter
@AllArgsConstructor
public enum EnumDialogueType {
    ONLY_NPC("OnlyNpc", "只有npc的对话"),
    NPC_AND_PLAYER("NpcAndPlayer", "Npc和player的对话，由npc开始第一句对话"),

    ;

    private String type;
    private String description;


}

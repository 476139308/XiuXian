package com.yj.xiuxian.task.communicate;

import lombok.Data;

import java.util.List;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/9/1 16:17
 */
@Data
public class Dialogue {

    private String taskId;

    private EnumDialogueType dialogueType;
//    默认Npc对话为index = 0 的text

    private List<DialogueContent> dialogueContentList;


    @Data
    private static class DialogueContent {
        private String dialogueText;
        private EnumDialogueFunction dialogueFunctionType;
        private Integer functionValue;

    }
}

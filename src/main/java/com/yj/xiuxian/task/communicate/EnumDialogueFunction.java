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
public enum EnumDialogueFunction {
    CONTINUE("Continue", "继续"),
    JUMP("Jump", "跳转"),
    END("End", "结束"),
    ACCEPT_TASK("AcceptTask", "接受任务"),
    OPEN_UI("OpenUi", "打开其他ui界面"),

    ;

    private String type;
    private String description;


}

package com.yj.xiuxian.panel.skill;

import lombok.Data;

import java.util.List;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/8/31 13:59
 */
@Data
public class SkillBar {
    private List<SkillSlot> skillSlotList;
    private List<Skill> skillList;

}

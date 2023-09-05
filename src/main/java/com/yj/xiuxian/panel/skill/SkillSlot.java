package com.yj.xiuxian.panel.skill;

import lombok.Data;

import static com.yj.xiuxian.constant.SkillConstants.*;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/8/31 14:00
 */
@Data
public class SkillSlot implements Comparable<SkillSlot> {
    private String id;
    //    开启1，关闭0，占据2
    private Integer state;
    private Integer level;
    private Skill skill;

    @Override
    public int compareTo(SkillSlot skillSlot) {
        //        1.先比较state,占据2 > 开启1  > 关闭0
        //        2.上面相同时在比较level
        int compare = Integer.compare(this.getState(), skillSlot.getState());
        if (compare == 0) {
            compare = Integer.compare(this.getLevel(), skillSlot.getLevel());
            if (compare == 0) {
                compare = this.getId().compareTo(skillSlot.getId());
            }
        }

        return compare;
    }

    public String show() {
        if (CLOSED_SKILL_SLOT.equals(this.getState())) {
            this.setSkill(null);
            return this.toString();
        }

        if (OPENED_SKILL_SLOT.equals(this.getState())) {
            this.setSkill(null);
            return this.toString();
        }


        if (OCCUPY_SKILL_SLOT.equals(this.getState())) {
            return this.toString();
        }
        return "";
    }

    public boolean operable() {
        return OPENED_SKILL_SLOT.equals(this.getState()) || (OCCUPY_SKILL_SLOT.equals(this.getState()) && this.getSkill().getTopLimit());
    }

}

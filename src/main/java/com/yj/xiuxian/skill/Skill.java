package com.yj.xiuxian.skill;

import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import static com.yj.xiuxian.constant.SkillConstants.ENABLE;
import static com.yj.xiuxian.constant.SkillConstants.FIRST_ORDER;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/8/31 13:56
 */
@Data
public class Skill {
    //    技艺名称
    private String name;
    //    技艺类型
    private String type;
    //    技艺难度等级    （对应技艺槽等级，高难度等级对修为，神魂等有要求，对修行速度有特别）
    //    每个技艺有其难度，结合技能槽计算出来的当前速度
    private BigDecimal currentPracticeSpeed;
    //    技艺等级
    //    （技艺的当前等级,及其上限等级，不同等级的技艺有不同数值，数量的加成）
    private Integer level;
    //    当前熟练度/目标熟练度 （熟练度是每一级不相同的，不同的行为增长减少的不同，不同的技艺修炼难度的熟练度也不相同，暂时只考虑熟练度上限不同，不考虑1点熟练度的效果不同）
    private Integer currentProficiency;
    private Integer maxProficiency;

    private Map<Integer, SkillAddition> currentEffectMap;
    private Map<Integer, Integer> proficiencyOfLevel;

    //    技艺的状态，0：禁用，1：可用，2：生效
    private Integer state = 1;


    private Map<BigDecimal, SkillTemplate> skillTemplateMap;

    private Boolean topLimit = false;


    public static Skill generateByTemplate(Map<BigDecimal, SkillTemplate> skillTemplateMap) {
        Skill skill = new Skill();
        skill.setSkillTemplateMap(skillTemplateMap);

//        1.直接设置
        //        后期可以考虑用分词器组合的方式
        skill.setName("技艺");
        skill.setLevel(FIRST_ORDER);
        skill.setCurrentProficiency(0);
        skill.setState(ENABLE);

//        2.遍历得出
        Map<Integer, SkillAddition> currentEffectMap = new HashMap<>();
        Map<Integer, Integer> proficiencyOfLevel = new HashMap<>();
        for (Map.Entry<BigDecimal, SkillTemplate> entry : skillTemplateMap.entrySet()) {
            BigDecimal proportion = entry.getKey();
            SkillTemplate skillTemplate = entry.getValue();
            skill.setType(skillTemplate.getType());
            Map<Integer, SkillTemplate.PracticeNode> practiceNodeMap = skillTemplate.getPracticeNodeMap();
            for (Map.Entry<Integer, SkillTemplate.PracticeNode> practiceNodeEntry : practiceNodeMap.entrySet()) {
                Integer practiceLevel = practiceNodeEntry.getKey();
                SkillTemplate.PracticeNode practiceNode = practiceNodeEntry.getValue();
                int proficientOfLevel = proficiencyOfLevel.get(practiceLevel) == null ? 0 : proficiencyOfLevel.get(practiceLevel);
                proficiencyOfLevel.put(practiceLevel, proficientOfLevel + proportion.multiply(new BigDecimal(practiceNode.getProficiency())).divide(new BigDecimal(100), 0, RoundingMode.DOWN).intValue());

//                SkillAddition skillAddition = currentEffectMap.get(practiceLevel);


            }
        }

//        3.循环计算得出
        skill.setCurrentEffectMap(currentEffectMap);
        skill.setMaxProficiency(Math.toIntExact(proficiencyOfLevel.get(skill.getLevel())));
//        skill.setCurrentPracticeSpeed();
        skill.setProficiencyOfLevel(proficiencyOfLevel);


        return skill;
    }

}

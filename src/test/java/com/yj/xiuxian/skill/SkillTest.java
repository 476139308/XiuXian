package com.yj.xiuxian.skill;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.*;

import static com.yj.xiuxian.constant.SkillConstants.*;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/8/31 16:21
 */
public class SkillTest {

    /**
     * 由模版生成技能的出发点，
     * 1.根据技艺关键字在数据库中挑选出一到多个由关联的模板
     * 2.根据关联模版确定各自的比例
     * 3.最终生成相关的skill
     */
    @Test
    void generateSkill() {
        SkillTemplate skillTemplate1 = SkillTemplate.generateInstance("种田", LIFE_SKILL_TYPE, BASE_ORDER, 1, 3);

        HashMap<Integer, SkillTemplate.PracticeNode> practiceNodeHashMap1 = new HashMap<>();
        practiceNodeHashMap1.put(1, new SkillTemplate.PracticeNode(100L, List.of(new SkillAddition(PLANT, PRODUCTION, BigDecimal.valueOf(0.2))), null));
        practiceNodeHashMap1.put(2, new SkillTemplate.PracticeNode(500L, List.of(new SkillAddition(PLANT, PRODUCTION, BigDecimal.valueOf(0.5))), null));
        ArrayList<SkillAddition> specialEffectOfThree1 = new ArrayList<>();
        specialEffectOfThree1.add(new SkillAddition(PLANT, GROWTH_SPEED, BigDecimal.valueOf(0.5)));
        specialEffectOfThree1.add(new SkillAddition(PLANT, PRODUCTION, BigDecimal.valueOf(1)));
        practiceNodeHashMap1.put(3, new SkillTemplate.PracticeNode(2000L, List.of(new SkillAddition(PLANT, PRODUCTION, BigDecimal.valueOf(1))), specialEffectOfThree1));

        skillTemplate1.setPracticeNodeMap(practiceNodeHashMap1);

        SkillTemplate skillTemplate2 = SkillTemplate.generateInstance("灵药种植", LIFE_SKILL_TYPE, FIRST_ORDER, 15, 5);

        HashMap<Integer, SkillTemplate.PracticeNode> practiceNodeHashMap2 = new HashMap<>();
        practiceNodeHashMap2.put(1, new SkillTemplate.PracticeNode(100L, List.of(new SkillAddition(PLANT, GROWTH_SPEED, BigDecimal.valueOf(0.1))), null));
        practiceNodeHashMap2.put(2, new SkillTemplate.PracticeNode(500L, List.of(new SkillAddition(PLANT, GROWTH_SPEED, BigDecimal.valueOf(0.3))), null));
        ArrayList<SkillAddition> specialEffectOfThree2 = new ArrayList<>();
        specialEffectOfThree2.add(new SkillAddition(PLANT, GROWTH_SPEED, BigDecimal.valueOf(0.3), false));
        specialEffectOfThree2.add(new SkillAddition(PLANT, PRODUCTION, BigDecimal.valueOf(0.5), false));
        practiceNodeHashMap2.put(3, new SkillTemplate.PracticeNode(2000L, List.of(new SkillAddition(PLANT, PRODUCTION, BigDecimal.valueOf(0.5))), specialEffectOfThree2));
        practiceNodeHashMap2.put(4, new SkillTemplate.PracticeNode(4000L, List.of(new SkillAddition(PLANT, PRODUCTION, BigDecimal.valueOf(0.5))), null));
        practiceNodeHashMap2.put(5, new SkillTemplate.PracticeNode(10000L, List.of(new SkillAddition(PLANT, PRODUCTION, BigDecimal.valueOf(0.5))), null));

        skillTemplate1.setPracticeNodeMap(practiceNodeHashMap2);


        Map<BigDecimal, SkillTemplate> skillTemplateMap = SkillTemplate.generateRandomProportion(skillTemplate1, skillTemplate2);

        Skill skill = Skill.generateByTemplate(skillTemplateMap);
        System.out.println("skill = " + skill);

    }


}

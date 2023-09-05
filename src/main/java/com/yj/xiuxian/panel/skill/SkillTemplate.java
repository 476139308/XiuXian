package com.yj.xiuxian.panel.skill;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/8/31 14:32
 */
@Data
public class SkillTemplate {
    private String name;

    private String type;

    //    技艺等级，与修为等级相关联，低修为学习高等阶会提高难度，高修为学习低等阶会降低难度，每个等阶有其固定的最小难度
    private Integer level;

    private Integer difficult;

    private Integer topLimitLevel;

    private Map<Integer, PracticeNode> practiceNodeMap = new HashMap<>();

    private static final Map<Integer, Integer> BASE_DIFFICULT = new HashMap<>();

    static {
        //    凡人0，练气1，筑基2，金丹3，元婴4，化神5
        BASE_DIFFICULT.put(0, 1);
        BASE_DIFFICULT.put(1, 10);
        BASE_DIFFICULT.put(2, 100);
        BASE_DIFFICULT.put(3, 1000);
        BASE_DIFFICULT.put(4, 10000);
        BASE_DIFFICULT.put(5, 1000000);
    }

    @Data
    @AllArgsConstructor
    public static class PracticeNode {
        private Long proficiency;

        private List<SkillAddition> effect;

        private List<SkillAddition> conditionalEffect;

    }

    public static SkillTemplate generateInstance(String name, String type, Integer level, Integer difficult, Integer topLimitLevel) {
        SkillTemplate skillTemplate = new SkillTemplate();
        skillTemplate.setName(name);
        skillTemplate.setType(type);
        skillTemplate.setLevel(level);
        skillTemplate.setDifficult(Math.max(BASE_DIFFICULT.get(level), difficult));
        skillTemplate.setTopLimitLevel(topLimitLevel);

        return skillTemplate;
    }


//    public static void main(String[] args) {
//        SkillTemplate skillTemplate = SkillTemplate.generateInstance("种田", LIFE_SKILL_TYPE, BASE_ORDER, 1, 3);
//
//        HashMap<Integer, PracticeNode> practiceNodeHashMap = new HashMap<>();
//        practiceNodeHashMap.put(1, new PracticeNode(100L, List.of(new SkillAddition(PLANT, PRODUCTION, BigDecimal.valueOf(0.2))), null));
//        practiceNodeHashMap.put(2, new PracticeNode(100L, List.of(new SkillAddition(PLANT, PRODUCTION, BigDecimal.valueOf(0.5))), null));
//        ArrayList<SkillAddition> specialEffectOfThree = new ArrayList<>();
//        specialEffectOfThree.add(new SkillAddition(PLANT, GROWTH_SPEED, BigDecimal.valueOf(0.5)));
//        specialEffectOfThree.add(new SkillAddition(PLANT, PRODUCTION, BigDecimal.valueOf(1)));
//        practiceNodeHashMap.put(3, new PracticeNode(100L, List.of(new SkillAddition(PLANT, PRODUCTION, BigDecimal.valueOf(1))), specialEffectOfThree));
//
//        skillTemplate.setPracticeNodeMap(practiceNodeHashMap);
//
//        System.out.println(JSON.toJSONString(skillTemplate));
//
//    }


    public static Map<BigDecimal, SkillTemplate> generateRandomProportion(SkillTemplate... skillTemplates) {
        HashMap<BigDecimal, SkillTemplate> skillTemplateHashMap = new HashMap<>();
        Random random = new Random();

        int limit = random.nextInt(51) + 50;

        for (SkillTemplate skillTemplate : skillTemplates) {
            int tempNumber = random.nextInt(limit - 1) + 1;
            limit -= tempNumber;

            skillTemplateHashMap.put(new BigDecimal(tempNumber).setScale(2, RoundingMode.DOWN), skillTemplate);
        }

        return skillTemplateHashMap;
    }

}

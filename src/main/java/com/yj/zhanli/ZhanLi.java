package com.yj.zhanli;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/9/8 12:29
 * 战力基本系统
 */
@Data
public class ZhanLi {
    private Double zhanliValue;

    //    基础属性
    private Double attackRatio;
    private Double healthRatio;
    private Double defendRatio;
    private Double minjieRatio;
    //    战斗属性  ,击晕，暴击，连击，闪避，反
    private Double jiyunRatio;
    private Double baojiRatio;
    private Double lianjiRatio;
    private Double shanbiRatio;
    private Double fanjiRatio;
    private Double xixueRatio;
    //    战斗抗性：抗击晕，暴击，连击，闪避，反击，吸血
    //    特殊属性 ：最终增伤，最终减伤，
    //    强化    爆伤，治疗，灵兽，道法
    //            弱化
    //    无视    战斗属性，战斗抗性
    //    格挡    抗格挡 破甲  抗破甲


    public Integer calculateZhanLi(Human human) {
        int zhanli = 0;

        if (human.getAttack() != null) {
            zhanli += human.getAttack() * this.getAttackRatio();
        }

        if (human.getDefend() != null) {
            zhanli += human.getDefend() * this.getDefendRatio();
        }

        if (human.getHealth() != null) {
            zhanli += human.getHealth() * this.getHealthRatio();
        }


        if (human.getMinjie() != null) {
            zhanli += human.getMinjie() * this.getMinjieRatio();
        }

        return zhanli;
    }

    public ArrayList<ZhanLi> calculateZhanLiRatio(Human human) {
        ArrayList<ZhanLi> zhanLiArrayList = new ArrayList<>();

        for (int i = 1; i < 100; i++) {
            for (int j = 1; j < 100; j++) {
                for (int k = 1; k < 100; k++) {
                    for (int l = 1; l < 100; l++) {
                        double temp = 0d;
                        if (human.getAttack() != null) {
                            temp += i * human.getAttack();
                        }

                        if (human.getDefend() != null) {
                            temp += j * human.getDefend();
                        }

                        if (human.getHealth() != null) {
                            temp += k * human.getHealth();
                        }
                        if (human.getMinjie() != null) {
                            temp += l * human.getMinjie();
                        }

                        if (temp == this.getZhanliValue()) {
                            ZhanLi zhanLi = new ZhanLi();
                            zhanLi.setZhanliValue(this.getZhanliValue());
                            zhanLi.setAttackRatio((double) i);
                            zhanLi.setHealthRatio((double) j);
                            zhanLi.setDefendRatio((double) k);
                            zhanLi.setMinjieRatio((double) l);
                            zhanLiArrayList.add(zhanLi);
                        }
                    }
                }
            }
        }
        return zhanLiArrayList;
    }

    public static boolean equal(ZhanLi... zhanliList) {
        boolean flag = false;
        if (zhanliList.length <= 1) {
            return false;
        }

        Set<Double> attackSet = Arrays.stream(zhanliList).map(ZhanLi::getAttackRatio).collect(Collectors.toSet());
        flag = equalSet(attackSet);
        if (!flag) {
            return false;
        }

        Set<Double> defendSet = Arrays.stream(zhanliList).map(ZhanLi::getDefendRatio).collect(Collectors.toSet());
        flag = equalSet(defendSet);
        if (!flag) {
            return false;
        }

        Set<Double> healthSet = Arrays.stream(zhanliList).map(ZhanLi::getHealthRatio).collect(Collectors.toSet());
        flag = equalSet(healthSet);
        if (!flag) {
            return false;
        }

        Set<Double> minjieSet = Arrays.stream(zhanliList).map(ZhanLi::getMinjieRatio).collect(Collectors.toSet());
        flag = equalSet(minjieSet);
        if (!flag) {
            return false;
        }

        return true;
    }

    private static boolean equalSet(Set<Double> attackSet) {
        if (attackSet.size() > 2) {
            return false;
        } else if (attackSet.size() == 2 && attackSet.contains(null)) {
            return true;
        } else if (attackSet.size() == 1) {
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        ArrayList<Double> attacks = new ArrayList<>();
        attacks.add(8d);
        attacks.add(11d);
        attacks.add(19d);
        attacks.add(30d);
        attacks.add(41d);
        attacks.add(52d);


        Human human1 = new Human();
        human1.setAttack(22);
        human1.setHealth(336 - 161);
        human1.setDefend(4);

        ZhanLi zhanLi1 = new ZhanLi();
        zhanLi1.setZhanliValue(1506.0);
        zhanLi1.setAttackRatio((double) 0);
        zhanLi1.setHealthRatio((double) 0);
        zhanLi1.setDefendRatio((double) 0);
        ArrayList<ZhanLi> zhanLis = zhanLi1.calculateZhanLiRatio(human1);
        zhanLis.removeIf(new Predicate<ZhanLi>() {
            @Override
            public boolean test(ZhanLi zhanLi) {
                if (zhanLi.getAttackRatio() == 8 && zhanLi.getHealthRatio() == 5) {

                }


                return false;
            }
        });


        Human human2 = new Human();
        human2.setAttack(17);
        human2.setHealth(212 - 92);
        human2.setDefend(3);
        human2.setMinjie(2);

        ZhanLi zhanLi2 = new ZhanLi();
        zhanLi2.setZhanliValue(1302d);
        zhanLi2.setAttackRatio(0d);
        zhanLi2.setHealthRatio(0d);
        zhanLi2.setDefendRatio(0d);
        zhanLi2.setMinjieRatio(0d);

        ArrayList<ZhanLi> zhanLis2 = zhanLi2.calculateZhanLiRatio(human2);


        zhanLis2.removeIf(next -> next.getHealthRatio() > 6);
        zhanLis2.removeIf(next -> next.getAttackRatio() > 60);

        Human human3 = new Human();
        human3.setAttack(25 - 9);
        human3.setHealth(175 - 66);
        human3.setDefend(3);
        human3.setMinjie(2);

        ZhanLi zhanLi3 = new ZhanLi();
        zhanLi3.setZhanliValue(1239d);
        zhanLi3.setAttackRatio(0d);
        zhanLi3.setHealthRatio(0d);
        zhanLi3.setDefendRatio(0d);
        zhanLi3.setMinjieRatio(0d);

        ArrayList<ZhanLi> zhanLis3 = zhanLi2.calculateZhanLiRatio(human2);
        zhanLis3.removeIf(next -> next.getHealthRatio() > 6);
        zhanLis3.removeIf(next -> next.getAttackRatio() > 60);

        int i = 0;
        ArrayList<ZhanLi> result = new ArrayList<>();
        for (ZhanLi zhanLi : zhanLis) {
            for (ZhanLi li : zhanLis2) {
                for (ZhanLi zhanLi4 : zhanLis3) {
                    System.out.println("i = " + (i++));
                    if (equal(zhanLi4, li, zhanLi)) {
                        System.out.println("zhanLi4 = " + zhanLi4);
                        result.add(zhanLi4);
                    }
                }
            }
        }


        System.out.println("result = " + result);


    }


}

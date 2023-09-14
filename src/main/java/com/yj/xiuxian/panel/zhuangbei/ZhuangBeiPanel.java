package com.yj.xiuxian.panel.zhuangbei;

import com.yj.xiuxian.backpack.Backpack;
import com.yj.xiuxian.backpack.BackpackItem;
import com.yj.xiuxian.panel.man.CharacterPanel;
import lombok.Data;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.yj.xiuxian.constant.BackpackConstants.*;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/9/14 9:58
 * 目前装备有：战斗用主要攻击法器，战斗用辅助法器
 * 防御用法袍等恒定防御
 * 防御主动法器
 * 储物法器
 * 历练飞行法器
 * 辅助法器（根据辅助法器的分类类型，每种只能生效一个）
 */
@Data
public class ZhuangBeiPanel {

    private ZhuangBeiSlot weaponSlot;

    private ZhuangBeiSlot clothSlot;


    //    主动防御
    private ZhuangBeiSlot shieldSlot;


    private List<ZhuangBeiSlot> storeSlotList;


    //    单人的话可以拆分的细致一些，多人的话
    private List<ZhuangBeiSlot> assistSlotList;


    //    自动装备，如果是单人游戏就是每人每个背包
    public void automicWearEquipment(String sort, List<CharacterPanel> characterPanelList, Backpack storeHouse) {
        if ("birthday".equalsIgnoreCase(sort)) {
            characterPanelList.sort(Comparator.comparing(CharacterPanel::getBirthday));
        } else {
            characterPanelList.sort(Comparator.comparing(CharacterPanel::getName));
        }

        List<BackpackItem> equipmentList = storeHouse.getBackpackItemList().stream()
                .filter(backpackItem -> EQUIPMENT.equals(backpackItem.getBackpackItemTemplate().getMainType()))
                .collect(Collectors.toList());

        List<BackpackItem> attackEquipmentList = equipmentList.stream()
                .filter(backpackItem -> ATTACK.equals(backpackItem.getBackpackItemTemplate().getSubType()))
                .collect(Collectors.toList());
        List<BackpackItem> defendEquipmentList = equipmentList.stream()
                .filter(backpackItem -> DEFEND.equals(backpackItem.getBackpackItemTemplate().getSubType()))
                .collect(Collectors.toList());

        for (CharacterPanel characterPanel : characterPanelList) {
            ZhuangBeiPanel zhuangBeiPanel = characterPanel.getZhuangBeiPanel();
            Backpack backpack = characterPanel.getBackpack();
//            1.获取到当前   攻击装备、防御装备  的槽位
            ZhuangBeiSlot currentWeaponSlot = zhuangBeiPanel.getWeaponSlot();
            ZhuangBeiSlot currentClothSlot = zhuangBeiPanel.getClothSlot();
//            2.扫描  仓库的所有攻击装备   和   防御装备

//            3.扫描  自身背包的   攻击装备    和防御装备
            List<BackpackItem> characterEquipmentList = characterPanel.getBackpack().getBackpackItemList().stream()
                    .filter(backpackItem -> EQUIPMENT.equals(backpackItem.getBackpackItemTemplate().getMainType()))
                    .collect(Collectors.toList());
            List<BackpackItem> characterAttackEquipmentList = characterEquipmentList.stream()
                    .filter(backpackItem -> ATTACK.equals(backpackItem.getBackpackItemTemplate().getSubType()))
                    .collect(Collectors.toList());
            List<BackpackItem> characterDefendEquipmentList = characterEquipmentList.stream()
                    .filter(backpackItem -> DEFEND.equals(backpackItem.getBackpackItemTemplate().getSubType()))
                    .collect(Collectors.toList());

//            4.如果身上当前装备槽    没有  装备
            if (OPENED_BACKPACK_SLOT.equals(currentWeaponSlot.getState())) {
//                  直接在上述两个list中找出一件最好的 且符合装备要求的装备，穿上


            }

//            5.如果身上有   装备  则比较身上装备 与上面两个   list    中 符合装备要求的装备
            if (OCCUPY_BACKPACK_SLOT.equals(currentWeaponSlot.getState())) {
//                  如果身上装备  比   上面2个list的好，那么下一个逻辑
//                  如果身上装备  比   上面2个list的差，那么将最好的装备与身上的交换 ，替换品放入    仓库列表中
            }

        }

//              6.最后将当前的装备仓库和个人的背包仓库    重置为 计算出来的结果

    }
}

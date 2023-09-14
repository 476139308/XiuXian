package com.yj.xiuxian.panel.zhuangbei;

import lombok.Data;

import static com.yj.xiuxian.constant.ZhuangBeiConstants.*;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/8/31 14:00
 */
@Data
public class ZhuangBeiSlot implements Comparable<ZhuangBeiSlot> {
    private String id;
    //    开启1，关闭0，占据2
    private Integer state;
    private Integer level;
    private ZhuanBei zhuanBei;

    private Integer type;

    @Override
    public int compareTo(ZhuangBeiSlot skillSlot) {
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
        if (CLOSED_EQUIPMENT_SLOT.equals(this.getState())) {
            this.setZhuanBei(null);
            return this.toString();
        }

        if (OPENED_EQUIPMENT_SLOT.equals(this.getState())) {
            this.setZhuanBei(null);
            return this.toString();
        }


        if (OCCUPY_EQUIPMENT_SLOT.equals(this.getState())) {
            return this.toString();
        }
        return "";
    }

    public boolean operable() {
        return OPENED_EQUIPMENT_SLOT.equals(this.getState()) || (OCCUPY_EQUIPMENT_SLOT.equals(this.getState()) && this.getZhuanBei().checkLimit());
    }

}

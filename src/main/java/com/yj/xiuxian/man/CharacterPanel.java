package com.yj.xiuxian.man;

import com.yj.xiuxian.entity.BaseEntity;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/9/4 18:03
 * 姓名
 */
@Data
public class CharacterPanel extends BaseEntity {
    //    ## 基本信息：
//
//    姓名
    private String name;
    //            年龄
    private LocalDate birthday;
    //    剩余寿元
    private LocalDate deadDate;

    //    移动速度：
    private Double moveSpeed;
    //    修为境界：
    private Integer level;

    //      当前修为值
    private Integer currentCultivationValue;
    //      当前境界修为值上限
    private Integer maxCultivationValue;
    //    御器速度
    private Double experienceSpeed;
}

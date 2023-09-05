package com.yj.xiuxian.panel.experienct;

import com.yj.xiuxian.entity.BaseEntity;
import lombok.Data;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/9/4 19:08
 */
@Data
public class ExperiencePanel extends BaseEntity {
    //    修为境界：
    private Integer level;

    //      当前修为值
    private Integer currentCultivationValue;
    //      当前境界修为值上限
    private Integer maxCultivationValue;

}

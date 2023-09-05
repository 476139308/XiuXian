package com.yj.xiuxian.panel.fight;

import com.yj.xiuxian.entity.BaseEntity;
import lombok.Data;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/9/4 18:48
 */
@Data
public class Disease extends BaseEntity {
    private String name;
    private String impactAttributeName;
    private Double impactAttributeValue;
    private Double impactAttributePercentage;
}

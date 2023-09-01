package com.yj.xiuxian.panel;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/8/31 22:55
 * addition:   加成
 * 加成大类
 * 温度      最低舒适温度      -10.1
 */
@Data
public class Addition {
    private String typeKey;
    private String specificKey;
    private BigDecimal value;
    private String description;

    @Override
    public String toString() {
        return StringUtils.isNotBlank(this.getDescription()) ? this.getDescription() : specificKey + ": " + value;
    }
}

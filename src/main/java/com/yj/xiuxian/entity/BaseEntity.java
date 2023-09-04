package com.yj.xiuxian.entity;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/9/4 18:27
 */
@Data
public class BaseEntity {
    private LocalDateTime createTime = LocalDateTime.now();
    private LocalDateTime updateTime = LocalDateTime.now();

    private Integer deleted = 0;

    private String desc = StringUtils.EMPTY;

}

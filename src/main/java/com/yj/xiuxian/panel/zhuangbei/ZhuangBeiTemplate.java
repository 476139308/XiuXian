package com.yj.xiuxian.panel.zhuangbei;

import com.yj.xiuxian.panel.Addition;
import lombok.Data;

import java.util.List;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/9/14 9:56
 */
@Data
public class ZhuangBeiTemplate {

    private Integer id;

    private String name;

    private Integer level;

    private List<Addition> additionList;

}

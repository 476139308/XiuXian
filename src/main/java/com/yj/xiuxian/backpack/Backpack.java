package com.yj.xiuxian.backpack;

import lombok.Data;

import java.util.List;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/9/14 10:19
 */
@Data
public class Backpack {
    private Integer id;

    private List<BackpackItem> backpackItemList;

    private Integer occupiedCapacity;
    private Integer totalCapacity;

}

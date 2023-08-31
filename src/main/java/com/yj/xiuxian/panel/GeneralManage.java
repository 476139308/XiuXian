package com.yj.xiuxian.panel;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/8/31 13:02
 */
@Data
public class GeneralManage {

    private static final Map<String, MingGe> MING_GE_MAP = new HashMap<>();

    public static void registerMingGe(Map<String, MingGe> mingGeMap) {
        MING_GE_MAP.putAll(mingGeMap);
    }

    private GeneralManage() {
    }
}

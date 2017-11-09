package com.fengjin.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 字符串工具
 */
public final class StringUtil {

    /**
     * 判断字符串是否为空
     */
    public static boolean isEmpty(String str) {
        if (str != null) {
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    /**
     * 判断字符串是否为非空
     */
    public static boolean isNotEmpty(String str) {
        if (str != null) {
            str = str.trim();
        }
        return StringUtils.isNotEmpty(str);
    }
}

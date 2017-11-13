package com.fengjin.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间转换工具
 */
public class DateUtil {

    /**
     * 转换时间为指定格式
     *
     * @param obj
     * @return
     */
    public static String format(Object obj) {
        if (obj != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            date.setTime(Long.parseLong(obj.toString()));
            return simpleDateFormat.format(date);
        } else {
            return null;
        }
    }

    public static String parse(String str) {
        if (str != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                return simpleDateFormat.parse(str).toString();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

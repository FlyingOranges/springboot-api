package com.vue.api.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

    /**
     * 获取当前时间戳(long 格式)
     *
     * @return
     */
    public static long getTimestamp() {
        return System.currentTimeMillis();
    }

    /**
     * 时间戳转时间格式
     *
     * @param timestamp (long)
     * @return
     */
    public static String getTime(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return sdf.format(new Date(Long.parseLong(String.valueOf(timestamp))));
    }

    /**
     * 时间戳转时间格式
     *
     * @param timestamp (string)
     * @return
     */
    public static String getTime(String timestamp) {
        return getTime(Long.valueOf(timestamp));
    }

}

package com.xq.log;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Desc：
 * author：Christiano
 * gitee:
 * time：2021/06/02 10:02
 */
public class GeLogMo {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss", Locale.CHINA);
    public long timeMillis;
    public int level;
    public String tag;
    public String log;

    public GeLogMo(long timeMillis, int level, String tag, String log) {
        this.timeMillis = timeMillis;
        this.level = level;
        this.tag = tag;
        this.log = log;
    }

    public String flattenedLog() {
        return getFlattened() + "\n" + log;
    }

    public String getFlattened() {
        return format(timeMillis) + '|' + level + '|' + tag + "|:";
    }

    private String format(long timeMillis) {
        return sdf.format(timeMillis);
    }
}


package com.xq.log;

import androidx.annotation.NonNull;

/**
 * Desc：
 * author：Christiano
 * gitee:
 * time：2021/06/01 9:25
 */
public interface GeLogPrinter {
    void print(@NonNull GeLogConfig config, int level, String tag, @NonNull String printString);
}

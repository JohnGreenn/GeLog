package com.xq.log;

/**
 * Desc：日志格式化接口
 */
public interface GeLogFormatter<T> {
    String format(T data);
}

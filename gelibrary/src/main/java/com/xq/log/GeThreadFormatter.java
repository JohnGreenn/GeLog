package com.xq.log;

/**
 * Desc：线程格式化器
 */
public class GeThreadFormatter implements GeLogFormatter<Thread> {
    @Override
    public String format(Thread data) {
        return "Thread:" + data.getName();
    }
}

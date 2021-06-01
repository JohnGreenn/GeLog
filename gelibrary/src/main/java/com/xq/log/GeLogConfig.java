package com.xq.log;

/**
 * Desc：log配置类
 */
public abstract class GeLogConfig {

    static int MAX_LEN = 512;
    static GeThreadFormatter GE_THREAD_FORMATTER = new GeThreadFormatter();
    static GeStackTraceFormatter GE_STACK_TRACE_FORMATTER = new GeStackTraceFormatter();

    public JsonParser injectJsonParser() {
        return null;
    }

    public String getGlobalTag() {
        return "GeLog";
    } //全局tag

    public boolean enable() { //是否启用gelog
        return true;
    }

    public boolean includeThread() {
        return false;
    }
    //堆栈信息深度
    public int stackTraceDepth() {
        return 5;
    }

    //让用户来注册打印器
    public GeLogPrinter[] printers() {
        return null;
    }

    /**
     * 讲对象序列化，方便解耦，不依赖框架
     */
    public interface JsonParser{
        String toJson(Object src);
    }
}

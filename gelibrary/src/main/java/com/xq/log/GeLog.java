package com.xq.log;

import android.util.Log;
import android.util.LogPrinter;

import androidx.annotation.NonNull;

import java.util.Arrays;
import java.util.List;
import java.util.logging.LogManager;

/**
 *Tips:
 *1.打印堆栈信息
 *2.File输出
 *3。模拟控制台
 */


public class GeLog {
    private static final String GE_LOG_PACKAGE;

    static {
        String className = GeLog.class.getName();
        GE_LOG_PACKAGE = className.substring(0, className.lastIndexOf('.') + 1);
    }

    public static void v(Object... contents) {//接收可变参数类型
        log(GeLogType.V, contents);
    }

    public static void vt(String tag, Object... contents) {
        log(GeLogType.V, tag, contents);
    }

    public static void d(Object... contents) {
        log(GeLogType.D, contents);
    }

    public static void dt(String tag, Object... contents) {
        log(GeLogType.D, tag, contents);
    }

    public static void i(Object... contents) {
        log(GeLogType.I, contents);
    }

    public static void it(String tag, Object... contents) {
        log(GeLogType.I, tag, contents);
    }

    public static void w(Object... contents) {
        log(GeLogType.W, contents);
    }

    public static void wt(String tag, Object... contents) {
        log(GeLogType.W, tag, contents);
    }

    public static void e(Object... contents) {
        log(GeLogType.E, contents);
    }

    public static void et(String tag, Object... contents) {
        log(GeLogType.E, tag, contents);
    }

    public static void a(Object... contents) {
        log(GeLogType.A, contents);
    }

    public static void at(String tag, Object... contents) {
        log(GeLogType.A, tag, contents);
    }

    public static void log(@GeLogType.TYPE int type, Object... contents) {
        log(type, GeLogManager.getInstance().getConfig().getGlobalTag(), contents);
    }

    public static void log(@GeLogType.TYPE int type, @NonNull String tag, Object... contents) {
        log(GeLogManager.getInstance().getConfig(), type, tag, contents);
    }

    public static void log(@NonNull GeLogConfig config, @GeLogType.TYPE int type, @NonNull String tag, Object... contents) {
        if (!config.enable()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (config.includeThread()) {
            String threadInfo = GeLogConfig.GE_THREAD_FORMATTER.format(Thread.currentThread());
            sb.append(threadInfo).append("\n");
        }
        if (config.stackTraceDepth() > 0) {
            String stackTrace = GeLogConfig.GE_STACK_TRACE_FORMATTER.format(
                    GeStackTraceUtil.getCroppedRealStackTrack(new Throwable().getStackTrace(), GE_LOG_PACKAGE, config.stackTraceDepth()));
            sb.append(stackTrace).append("\n");
        }
        String body = parseBody(contents, config);
        if (body != null) {//替换转义字符\
            body = body.replace("\\\"", "\"");
        }
        sb.append(body);
        //Log.println(type,tag,body);
        List<GeLogPrinter> printers =
                config.printers() != null ? Arrays.asList(config.printers()) : GeLogManager.getInstance().getPrinters();
        if (printers == null) {
            return;
        }
        //打印log
        for (GeLogPrinter printer : printers) {
            printer.print(config, type, tag, sb.toString());
        }
    }


    private static String parseBody(@NonNull Object[] contents, @NonNull GeLogConfig config) {
        if (config.injectJsonParser() != null) {
            //只有一个数据且为String的情况下不再进行序列化
            if (contents.length == 1 && contents[0] instanceof String) {
                return (String) contents[0];
            }
            return config.injectJsonParser().toJson(contents);
        }
        StringBuilder sb = new StringBuilder();
        for (Object o : contents) {
            sb.append(o.toString()).append(";");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
